package com.android.testable.lib.util;

import android.util.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Base64.class})
public class TABase64Test {

    private TABase64 subject = new TABase64();

    @Test
    public void decode_string() {
        String input = "input";
        int flags = TABase64.NO_WRAP;
        byte[] result = new byte[]{1, 2, 3};
        PowerMockito.mockStatic(Base64.class);
        when(Base64.decode(input, flags)).thenReturn(result);

        assertArrayEquals(result, subject.decode(input, flags));
    }

    @Test
    public void decode_fullByteArray() {
        byte[] input = new byte[]{10, 11, 12};
        int flags = TABase64.NO_WRAP;
        byte[] result = new byte[]{1, 2, 3};
        PowerMockito.mockStatic(Base64.class);
        when(Base64.decode(input, flags)).thenReturn(result);

        assertArrayEquals(result, subject.decode(input, flags));
    }

    @Test
    public void decode_partialByteArray() {
        byte[] input = new byte[]{10, 11, 12};
        int offset = 1;
        int length = 2;
        int flags = TABase64.NO_WRAP;
        byte[] result = new byte[]{1, 2, 3};
        PowerMockito.mockStatic(Base64.class);
        when(Base64.decode(input, offset, length, flags)).thenReturn(result);

        assertArrayEquals(result, subject.decode(input, offset, length, flags));
    }

    @Test
    public void encode_fullByteArray() {
        byte[] input = new byte[]{10, 11, 12};
        int flags = TABase64.NO_WRAP;
        byte[] result = new byte[]{1, 2, 3};
        PowerMockito.mockStatic(Base64.class);
        when(Base64.encode(input, flags)).thenReturn(result);

        assertArrayEquals(result, subject.encode(input, flags));
    }

    @Test
    public void encode_partialByteArray() {
        byte[] input = new byte[]{10, 11, 12};
        int flags = TABase64.NO_WRAP;
        int offset = 1;
        int length = 2;
        byte[] result = new byte[]{1, 2, 3};
        PowerMockito.mockStatic(Base64.class);
        when(Base64.encode(input, offset, length, flags)).thenReturn(result);

        assertArrayEquals(result, subject.encode(input, offset, length, flags));
    }

    @Test
    public void encodeToString_partialByteArray() {
        byte[] input = new byte[]{10, 11, 12};
        int flags = TABase64.NO_WRAP;
        int offset = 1;
        int length = 2;
        String result = "result";
        PowerMockito.mockStatic(Base64.class);
        when(Base64.encodeToString(input, offset, length, flags)).thenReturn(result);

        assertEquals(result, subject.encodeToString(input, offset, length, flags));
    }

    @Test
    public void encodeToString_fullByteArray() {
        byte[] input = new byte[]{10, 11, 12};
        int flags = TABase64.NO_WRAP;
        String result = "result";
        PowerMockito.mockStatic(Base64.class);
        when(Base64.encodeToString(input, flags)).thenReturn(result);

        assertEquals(result, subject.encodeToString(input, flags));
    }

    @Test
    public void convertFlags() {
        assertEquals(Base64.DEFAULT, TABase64.convertFlags(TABase64.DEFAULT));
        assertEquals(Base64.NO_PADDING, TABase64.convertFlags(TABase64.NO_PADDING));
        assertEquals(Base64.NO_WRAP, TABase64.convertFlags(TABase64.NO_WRAP));
        assertEquals(Base64.CRLF, TABase64.convertFlags(TABase64.CRLF));
        assertEquals(Base64.URL_SAFE, TABase64.convertFlags(TABase64.URL_SAFE));
        assertEquals(Base64.NO_CLOSE, TABase64.convertFlags(TABase64.NO_CLOSE));
        assertEquals(-1, TABase64.convertFlags(-2));
    }
}