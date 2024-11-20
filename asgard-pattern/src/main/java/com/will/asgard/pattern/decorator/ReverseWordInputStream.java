package com.will.asgard.pattern.decorator;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * 反转单词。
 *
 * @author willmao
 * @date 2022-11-18 19:19
 **/
public class ReverseWordInputStream extends FilterInputStream {

    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected ReverseWordInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int result = super.read(b, off, len);
        int left = off;
        int right = off + result - 1;
        int mid = (left + right) / 2;
        for (int i = left; i < mid; i++) {
            byte tmp = b[i];
            int offset = i - left;
            b[i] = b[right - offset];
            b[right - offset] = tmp;
        }
        return result;
    }
}
