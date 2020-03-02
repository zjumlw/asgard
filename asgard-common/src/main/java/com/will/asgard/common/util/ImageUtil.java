package com.will.asgard.common.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

import javax.annotation.Nullable;
import javax.imageio.ImageIO;

import org.springframework.util.Base64Utils;

import com.google.common.base.Preconditions;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @ClassName ImageUtil
 * @Description rt
 * @Author maolingwei
 * @Date 2020-02-28 23:53
 * @Version 1.0
 **/
@Slf4j
public class ImageUtil {

	private ImageUtil() {
		throw new IllegalStateException();
	}

	/**
	 * resize image
	 * @param base64Img img
	 * @param expectedSize unit KB
	 * @return compressed img
	 */
	public static String resizeBase64Image(String base64Img, int expectedSize) throws IOException {
		Preconditions.checkNotNull(base64Img);
		if (expectedSize <= 0) {
			throw new IllegalArgumentException("expected size should larger than 0");
		}

		int size = getBase64ImageSize(base64Img);
		if (size <= expectedSize) {
			return base64Img;
		}

		double firstScale = expectedSize * 1.0 / size;
		BufferedImage src = base64StringToBufferedImage(base64Img);
		BufferedImage out = Thumbnails.of(src).scale(firstScale).asBufferedImage();
		String base64 = imageToBase64String(out);
		while (getBase64ImageSize(base64) > expectedSize) {
			out = Thumbnails.of(out).scale(0.9).asBufferedImage();
			base64 = imageToBase64String(out);
		}

		return base64;
	}

	@Nullable
	public static BufferedImage base64StringToBufferedImage(String base64String) {
		Preconditions.checkNotNull(base64String);
		BufferedImage image = null;
		try (InputStream stream = base64StringToInputStream(base64String)) {
			if (stream == null) {
				return null;
			}
			image = ImageIO.read(stream);
		} catch (IOException ex) {
			log.error("base64 to bufferedImage error", ex);
		}

		return image;
	}

	@Nullable
	public static InputStream base64StringToInputStream(String base64String) {
		Preconditions.checkNotNull(base64String);
		ByteArrayInputStream stream = null;
		try {
			Base64.Decoder decoder = Base64.getDecoder();
			byte[] buf = decoder.decode(base64String);
			stream = new ByteArrayInputStream(buf);
		} catch (Exception ex) {
			log.error("base64 to inputStream error", ex);
		}
		return stream;
	}

	@Nullable
	public static String imageToBase64String(BufferedImage bufferedImage) {
		return imageToBase64String(bufferedImage, "png");
	}

	@Nullable
	public static String imageToBase64String(BufferedImage bufferedImage, String formatName) {
		try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
			ImageIO.write(bufferedImage, formatName, outputStream);
			return Base64Utils.encodeToString(outputStream.toByteArray());
		} catch (IOException ex) {
			log.error("image to base64 error", ex);
			return null;
		}
	}

	/**
	 * get base64 image size
	 * @param base64Img img
	 * @return size KB
	 */
	public static int getBase64ImageSize(String base64Img) {
		Preconditions.checkNotNull(base64Img);

		String str = base64Img.substring(22);
		int equalIndex = str.indexOf('=');
		if (equalIndex > 0) {
			str = str.substring(0, equalIndex);
		}
		int length = str.length();
		return (length - length / 4) / 1024;
	}

	public static String replaceImgUrlToHttps(String imgUrl) {
		Preconditions.checkNotNull(imgUrl);
		if (imgUrl.startsWith("http://")) {
			return imgUrl.replaceFirst("http://", "https://");
		} else {
			return imgUrl;
		}
	}

	public static String encodeImageToBase64(String url) throws Exception {
		Preconditions.checkNotNull(url);
		URL url1 = new URL(url);
		return encodeImageToBase64(url1);
	}

	public static String encodeImageToBase64(URL url) throws Exception {
		HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(5 * 1000);
			InputStream inStream = conn.getInputStream();
			ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = inStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, len);
			}
			inStream.close();
			byte[] data = outStream.toByteArray();
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(data); //返回Base64编码过的字节数组字符串
		} catch (IOException e) {
			throw new Exception("Failed to get base64 from url", e);
		}
	}
}
