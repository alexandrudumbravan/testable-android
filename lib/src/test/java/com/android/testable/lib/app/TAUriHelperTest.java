package com.android.testable.lib.app;

import android.net.Uri;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Uri.class})
public class TAUriHelperTest {

    private static final String TEST_URI = "testUri";

    private TAUriHelper subject;
    @Mock
    private Uri uri;

    @Before
    public void setUp() {
        subject = new TAUriHelper();
        PowerMockito.mockStatic(Uri.class);
    }

    @Test
    public void decode() {
        String result = "result";
        when(Uri.decode(TEST_URI)).thenReturn(result);
        assertEquals(result, subject.decode(TEST_URI));
    }

    @Test
    public void encode() {
        String result = "result";
        when(Uri.encode(TEST_URI)).thenReturn(result);
        assertEquals(result, subject.encode(TEST_URI));
    }

    @Test
    public void encode_allow() {
        String result = "result";
        String allow = "allow";
        when(Uri.encode(TEST_URI, allow)).thenReturn(result);
        assertEquals(result, subject.encode(TEST_URI, allow));
    }

    @Test
    public void fromFile() {
        File file = mock(File.class);
        when(Uri.fromFile(file)).thenReturn(uri);
        assertEquals(uri, subject.fromFile(file).uri);
    }

    @Test
    public void fromParts() {
        String scheme = "scheme";
        String ssp = "ssp";
        String fragment = "fragment";
        when(Uri.fromParts(scheme, ssp, fragment)).thenReturn(uri);
        assertEquals(uri, subject.fromParts(scheme, ssp, fragment).uri);
    }

    @Test
    public void parse() {
        when(Uri.parse(TEST_URI)).thenReturn(uri);
        assertEquals(uri, subject.parse(TEST_URI).uri);
    }

    @Test
    public void withAppendedPath() {
        Uri baseUri = mock(Uri.class);
        String path = "path";
        when(Uri.withAppendedPath(baseUri, path)).thenReturn(uri);
        assertEquals(uri, subject.withAppendedPath(baseUri, path).uri);
    }
}