package com.android.testable.lib.util;

import android.util.Base64;

public class TABase64 {

    /**
     * Same value as {@link android.util.Base64#DEFAULT}
     */
    public static final int DEFAULT = 0;

    /**
     * Same value as {@link android.util.Base64#NO_PADDING}
     */
    public static final int NO_PADDING = 1;

    /**
     * Same value as {@link android.util.Base64#NO_WRAP}
     */
    public static final int NO_WRAP = 2;

    /**
     * Same value as {@link android.util.Base64#CRLF}
     */
    public static final int CRLF = 4;

    /**
     * Same value as {@link android.util.Base64#URL_SAFE}
     */
    public static final int URL_SAFE = 8;

    /**
     * Same value as {@link android.util.Base64#NO_CLOSE}
     */
    public static final int NO_CLOSE = 16;


    /**
     * Invokes {@link android.util.Base64#decode(String, int)}
     *
     * @param input the string to be decoded
     * @param flags the encoding flags
     * @return the decoded array
     */
    public byte[] decode(String input, @Base64Flag int flags) {
        return Base64.decode(input, convertFlags(flags));
    }

    /**
     * Invokes {@link android.util.Base64#decode(byte[], int)}
     *
     * @param input the byte array to be decoded
     * @param flags the encoding flags
     * @return the decoded array
     */
    public byte[] decode(byte[] input, @Base64Flag int flags) {
        return Base64.decode(input, convertFlags(flags));
    }

    /**
     * Invokes {@link android.util.Base64#decode(byte[], int, int, int)}
     *
     * @param input  the byte array to be decoded
     * @param offset the offset from which the decoding should begin
     * @param len    the length of array to be decoded
     * @param flags  the encoding flags
     * @return the decoded array
     */
    public byte[] decode(byte[] input, int offset, int len, @Base64Flag int flags) {
        return Base64.decode(input, offset, len, convertFlags(flags));
    }

    /**
     * Invokes {@link android.util.Base64#encode(byte[], int)}
     *
     * @param input the byte array to be encoded
     * @param flags the encoding flags
     * @return the encoded array
     */
    public byte[] encode(byte[] input, @Base64Flag int flags) {
        return Base64.encode(input, convertFlags(flags));
    }

    /**
     * Invokes {@link android.util.Base64#encode(byte[], int, int, int)}
     *
     * @param input  the byte array to be encoded
     * @param offset the offset from which the encoding should begin
     * @param len    the length of array to be encoded
     * @param flags  the encoding flags
     * @return the encoded array
     */
    public byte[] encode(byte[] input, int offset, int len, @Base64Flag int flags) {
        return Base64.encode(input, offset, len, convertFlags(flags));
    }

    /**
     * Invokes {@link android.util.Base64#encodeToString(byte[], int, int, int)}
     *
     * @param input  the byte array to be encoded
     * @param offset the offset from which the encoding should begin
     * @param len    the length of array to be encoded
     * @param flags  the encoding flags
     * @return the encoded string
     */
    public String encodeToString(byte[] input, int offset, int len, @Base64Flag int flags) {
        return Base64.encodeToString(input, offset, len, convertFlags(flags));
    }

    /**
     * Invokes {@link android.util.Base64#encodeToString(byte[], int)}
     *
     * @param input the byte array to be encoded
     * @param flags the encoding flags
     * @return the encoded string
     */
    public String encodeToString(byte[] input, @Base64Flag int flags) {
        return Base64.encodeToString(input, convertFlags(flags));
    }


    static int convertFlags(@Base64Flag int flag) {
        switch (flag) {
            case DEFAULT:
                return Base64.DEFAULT;
            case NO_PADDING:
                return Base64.NO_PADDING;
            case NO_WRAP:
                return Base64.NO_WRAP;
            case CRLF:
                return Base64.CRLF;
            case URL_SAFE:
                return Base64.URL_SAFE;
            case NO_CLOSE:
                return Base64.NO_CLOSE;
            default:
                return -1;
        }
    }
}
