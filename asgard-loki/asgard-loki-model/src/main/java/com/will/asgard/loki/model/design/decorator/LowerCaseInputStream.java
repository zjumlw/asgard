package com.will.asgard.loki.model.design.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName LowerCaseInputStream
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-04-25 21:00
 * @Version 1.0
 **/
public class LowerCaseInputStream extends FilterInputStream {
	/**
	 * Creates a <code>FilterInputStream</code>
	 * by assigning the  argument <code>in</code>
	 * to the field <code>this.in</code> so as
	 * to remember it for later use.
	 *
	 * @param in the underlying input stream, or <code>null</code> if
	 *           this instance is to be created without an underlying stream.
	 */
	protected LowerCaseInputStream(InputStream in) {
		super(in);
	}

	public int read() throws IOException {
		int c = super.read();
		return (c == -1) ? c : Character.toLowerCase((char) c);
	}

	public int read(byte[] b, int offset, int len) throws IOException {
		int result = super.read(b, offset, len);
		for (int i = offset; i < offset + result; i++) {
			b[i] = (byte) Character.toLowerCase((char) b[i]);
		}
		return result;
	}

	public static void main(String[] args) {
		int c;
		try (InputStream in = new LowerCaseInputStream(new BufferedInputStream(
				new FileInputStream("/home/will/workspace/asgard/asgard-loki/asgard-loki-model/src/main/java/com/will/asgard/loki/model/design/decorator/test.txt")))) {
			while ((c = in.read()) >= 0) {
				System.out.print((char) c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
