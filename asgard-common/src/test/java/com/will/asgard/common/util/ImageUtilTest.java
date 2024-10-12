package com.will.asgard.common.util;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import cn.hutool.core.codec.Base64Decoder;
import cn.hutool.core.codec.Base64Encoder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ImageUtilTest {

	private String text;
	private String expectedEncodedText;

	@Before
	public void before() {
		text = "字串文字";
		expectedEncodedText = "5a2X5Liy5paH5a2X";
	}

	@Test
	public void testBase64() {
		final Base64.Decoder decoder = Base64.getDecoder();
		final Base64.Encoder encoder = Base64.getEncoder();
		final byte[] textByte = text.getBytes(StandardCharsets.UTF_8);

		//编码
		final String encodedText = encoder.encodeToString(textByte);
		Assert.assertEquals(expectedEncodedText, encodedText);

		//解码
		String decodedText = new String(decoder.decode(encodedText), StandardCharsets.UTF_8);
		Assert.assertEquals(text, decodedText);

		byte[] val = decoder.decode(encodedText);
		Assert.assertEquals(12, val.length);
	}

	@Test
	public void testAnotherBase64() throws IOException {
		final byte[] textByte = text.getBytes(StandardCharsets.UTF_8);

		final String encodedText = Base64Encoder.encode(textByte);
		Assert.assertEquals(expectedEncodedText, encodedText);

		String decodedText = new String(Base64Decoder.decode(encodedText), StandardCharsets.UTF_8);
		Assert.assertEquals(text, decodedText);

		byte[] val = Base64Decoder.decode(encodedText);
		Assert.assertEquals(12, val.length);
	}
}