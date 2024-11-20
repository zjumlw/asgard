package com.will.asgard.common.util;

import javax.annotation.Nullable;
import java.awt.image.BufferedImage;
import java.io.File;

import com.google.common.base.Preconditions;
import com.will.asgard.common.model.Constants;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.bytedeco.javacpp.avcodec;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;

/**
 * @ClassName VideoUtil
 * @Description
 *  v1.1 2020-07-07 重构了部分实现，增加了内部静态类 {@link VideoInfoWrapper} 用于包装想要的信息
 *  v1.2 2020-07-30 增加了视频编码形式的转换
 *
 * @Auther zjumlw
 * @Date 2020-05-27 20:07
 * @Version 1.2
 **/
@Slf4j
public class VideoUtil {

	private VideoUtil() {
		throw new IllegalStateException();
	}

	private static final String TEMP_FILE_DIRECTORY = "/tmp/video-util/";

	@Getter
	@Setter
	@NoArgsConstructor
	public static class VideoInfoWrapper {
		// 视频文件名字
		private String videoName;
		// 视频大小，单位字节
		private long videoSize;
		// 获取到图像的那帧
		private int frameNumber;
		// 获取到的那一帧的图像
		private BufferedImage bufferedImage;
		private int imageHeight;
		private int imageWidth;
		// 视频时长，单位秒
		private int duration;
		// 视频总帧数
		private int frameLength;
		// 视频的编码格式，具体指代查看 org.bytedeco.javacpp.avcodec
		private int videoCodec;
		// 帧率
		private int frameRate;
		// 视频比特率
		private int videoBitrate;
		// 视频旋转角度
		private String rotate;

		@Override
		public String toString() {
			return "VideoInfoWrapper{" +
					"videoName='" + videoName + '\'' +
					", videoSize=" + videoSize +
					", frameNumber=" + frameNumber +
					", imageHeight=" + imageHeight +
					", imageWidth=" + imageWidth +
					", duration=" + duration +
					", frameLength=" + frameLength +
					", videoCodec=" + videoCodec +
					", frameRate=" + frameRate +
					", videoBitrate=" + videoBitrate +
					", rotate='" + rotate + '\'' +
					'}';
		}
	}

	public static long getVideoDuration(File video) {
		long duration = 0L;
		try (FFmpegFrameGrabber ff = new FFmpegFrameGrabber(video)) {
			ff.start();
			duration = ff.getLengthInTime() / (1000 * 1000);
			ff.stop();
		} catch (FrameGrabber.Exception e) {
			log.error("getVideoDuration error", e);
		}
		return duration;
	}

	/**
	 * 获取视频的某一帧的图像
	 *
	 * @param video       视频文件
	 * @param frameNumber 要获取的帧数
	 * @return 某一帧的图像
	 */
	@Nullable
	public static BufferedImage fetchVideoFrame(File video, int frameNumber) throws Exception {
		VideoInfoWrapper wrapper = getVideoInfoWrapper(video, frameNumber);
		return wrapper.getBufferedImage();
	}

	/**
	 * 获取视频的第一帧图像
	 * @param video 视频文件
	 * @return 第一帧图像
	 */
	public static BufferedImage fetchFirstFrameOfVideo(File video) throws Exception {
		return fetchVideoFrame(video, 1);
	}

	/**
	 * 获取视频信息的包装，可以从包装中获取想要的信息
	 * 其中存储了视频第一帧的图像
	 */
	public static VideoInfoWrapper getVideoInfoWrapper(File video) throws Exception {
		return getVideoInfoWrapper(video, 1);
	}

	/**
	 * 获取视频信息的包装，可以从包装中获取想要的信息
	 */
	public static VideoInfoWrapper getVideoInfoWrapper(File video, int frameNumber) throws Exception {
		Preconditions.checkNotNull(video);
		if (frameNumber <= 0) {
			throw new IllegalArgumentException("Illegal argument frameNumber: " + frameNumber + ", must bigger than 0");
		}

		VideoInfoWrapper wrapper = new VideoInfoWrapper();
		wrapper.setVideoName(video.getName());
		wrapper.setVideoSize(video.length());

		try (FFmpegFrameGrabber ff = new FFmpegFrameGrabber(video)) {
			ff.start();

			// 获取视频总帧数
			int ffLength = ff.getLengthInFrames();
			// 获取视频时长，单位s
			int duration = (int) (ff.getLengthInTime() / (1000 * 1000));
			String rotate = ff.getVideoMetadata("rotate");

			wrapper.setFrameLength(ffLength);
			wrapper.setDuration(duration);
			wrapper.setRotate(rotate);
			wrapper.setVideoCodec(ff.getVideoCodec());
			wrapper.setFrameRate((int) ff.getFrameRate());
			wrapper.setVideoBitrate(ff.getVideoBitrate());

			int imageWidth = ff.getImageWidth();
			int imageHeight = ff.getImageHeight();
			wrapper.setImageWidth(imageWidth);
			wrapper.setImageHeight(imageHeight);

			// 获取 frameNumber 那一帧（附近）的有效图像
			if (frameNumber > ffLength) {
				log.error("frameNumber {} is bigger than frameLength {}", frameNumber, ffLength);
				return wrapper;
			}
			Frame frame = null;
			int i = 0;
			while (i < ffLength) {
				frame = ff.grabFrame();
				if (i >= frameNumber && frame.image != null) {
					wrapper.setFrameNumber(i);
					break;
				}
				i++;
			}
			Java2DFrameConverter converter = new Java2DFrameConverter();
			BufferedImage bufferedImage = converter.getBufferedImage(frame);
			wrapper.setBufferedImage(bufferedImage);

			// 视频有旋转，则将宽高和视频帧正过来
			if (StringUtils.isNotBlank(rotate)) {
				int rotateAngle = CommonUtil.safeParseInteger(rotate);
				BufferedImage fixedImage = ImageUtil.rotateImage(bufferedImage, rotateAngle);
				int fixedImageWidth = fixedImage.getWidth();
				int fixedImageHeight = fixedImage.getHeight();
				wrapper.setImageWidth(fixedImageWidth);
				wrapper.setImageHeight(fixedImageHeight);
				wrapper.setBufferedImage(fixedImage);
			}

			ff.stop();
		} catch (FrameGrabber.Exception e) {
			log.error("Get video info error", e);
			throw new Exception("Failed to get video info", e);
		}

		return wrapper;
	}

	public static File convertVideoCodecToH264(File video) throws Exception {
		log.info("convertVideoCodecToH264, video: {}", video.getAbsolutePath());
		return convertVideoCodec(video, avcodec.AV_CODEC_ID_H264);
	}

	/**
	 * 转换视频文件的编码格式。
	 * 处理后的视频文件保存在临时目录，在 VM 退出时会删除；最好不再需要时及时进行删除，释放硬盘空间。
	 *
	 * @param video 被处理的视频文件
	 * @return 转换编码格式后的视频文件
	 */
	public static File convertVideoCodec(File video, int videoCodec) throws Exception {
		Preconditions.checkNotNull(video);

		File directory = new File(TEMP_FILE_DIRECTORY);
		if (!directory.exists()) {
			synchronized (VideoUtil.class) {
				boolean success = directory.mkdirs();
				if (!success) {
					throw new IllegalStateException("Failed to create temp directory");
				}
			}
		}

		String videoName = video.getName();
		String tempVideoName = CommonUtil.getCurrentTimestamp() + "_" + videoName;
		String tempFilePath = TEMP_FILE_DIRECTORY + tempVideoName;
		File fileToReturn = new File(tempFilePath);

		log.info("Start convertVideoCodec, video: {}, videoCodec: {}, tempFilePath: {}",
				video.getAbsolutePath(), videoCodec, tempFilePath);

		// 抓取视频
		try (FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(video)) {
			grabber.start();
			double frameRate = grabber.getFrameRate();
			int videoBitrate = grabber.getVideoBitrate();
			int imageHeight = grabber.getImageHeight();
			int imageWidth = grabber.getImageWidth();

			log.info("convertVideoCodec, frameRate: {}, videoBitrate: {}, height: {}, width: {}",
					frameRate, videoBitrate, imageHeight, imageWidth);

			try (FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(tempFilePath, imageWidth, imageHeight, 1)) {
				recorder.setFrameRate(frameRate);
				recorder.setVideoBitrate(videoBitrate);
				recorder.setVideoCodec(videoCodec);
				recorder.start();

				// 不断抓取视频和录制视频，直到所有帧抓取/录制完或者超时
				long t1 = CommonUtil.getCurrentTimestamp();
				Frame frame;
				while ((frame = grabber.grabFrame()) != null) {
					long t2 = CommonUtil.getCurrentTimestamp();
					// 超时就停止，30分钟
					if (t2 - t1 > 30 * Constants.TimeStampPerMinute) {
						log.warn("total time bigger than 30min, break!");
						throw new Exception("转换视频编码超时");
					} else {
						recorder.record(frame);
					}
				}
				long t3 = CommonUtil.getCurrentTimestamp();
				long totalTime = t3 - t1;
				log.info("convertVideoCodec, file: {} ,codec: {}, took {} ms", video.getName(), videoCodec, totalTime);

				recorder.stop();
			}
			grabber.stop();
			return fileToReturn;
		} finally {
			if (fileToReturn.exists()) {
				fileToReturn.deleteOnExit();
			}
		}
	}
}
