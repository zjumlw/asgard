package com.will.asgard.pattern.decorator;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 把输入流中的所有大写字母转化成小写字母。
 *
 * @author willmao
 * @date 2022-11-18 01:02
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

    /**
     * Reads the next byte of data from this input stream. The value
     * byte is returned as an <code>int</code> in the range <code>0</code>
     * to <code>255</code>. If no byte is available because the end of the stream has reached,
     * the value <code>-1</code> is returned. This method blocks until input data is available,
     * the end of the stream is detected, or and exception is thrown.
     *
     * @return the next byte of data, or <code>-1</code> if the end of the stream is reached.
     * @throws IOException if an I/O error occurs.
     */
    @Override
    public int read() throws IOException {
        int c = super.read();
        return c == -1 ? c : Character.toLowerCase((char) c);
    }

    /**
     * Reads up to <code>len</code> bytes of data from this input stream into an array of bytes.
     * If <code>len</code> is not zero, the method blocks until some input is available; otherwise,
     * no bytes are read and <code>0</code> is returned.
     * <p>
     *     This method simply performs <code>in.read(b, off, len)</code> and returns the result.
     * </p>
     *
     * @param b the buffer into which the data is read.
     * @param off the start offset in the destination array <code>b</code>
     * @param len the maximum number of bytes read.
     * @return the total number of bytes read into the buffer, or <code>-1</code> if there is no more data
     *         because the end of the stream has been reached.
     * @throws IOException if an I/O error occurs.
     */
    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int result = super.read(b, off, len);
        for (int i = off; i < off + result; i++) {
            b[i] = (byte) Character.toLowerCase((char) b[i]);
        }
        return result;
    }
}
