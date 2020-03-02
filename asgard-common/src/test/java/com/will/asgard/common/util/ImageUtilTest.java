package com.will.asgard.common.util;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

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
		final BASE64Encoder encoder = new BASE64Encoder();
		final BASE64Decoder decoder = new BASE64Decoder();
		final byte[] textByte = text.getBytes(StandardCharsets.UTF_8);

		final String encodedText = encoder.encode(textByte);
		Assert.assertEquals(expectedEncodedText, encodedText);

		String decodedText = new String(decoder.decodeBuffer(encodedText), StandardCharsets.UTF_8);
		Assert.assertEquals(text, decodedText);

		byte[] val = decoder.decodeBuffer(encodedText);
		Assert.assertEquals(12, val.length);
	}
}