package com.android.testable.lib.app;

import android.net.Uri;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TAUriBuilderTest {

    private static final String TEST_URI = "uri";
    private TAUri.Builder subject;
    @Mock
    private Uri.Builder builder;

    @Before
    public void setUp() {
        subject = new TAUri.Builder(builder);
    }

    @Test
    public void appendEncodedPath() {
        TAUri.Builder result = subject.appendEncodedPath(TEST_URI);
        verify(builder).appendEncodedPath(TEST_URI);
        assertEquals(subject, result);
    }

    @Test
    public void appendPath() {
        TAUri.Builder result = subject.appendPath(TEST_URI);
        verify(builder).appendPath(TEST_URI);
        assertEquals(subject, result);
    }

    @Test
    public void appendQueryParameter() {
        String key = "key";
        String value = "value";
        TAUri.Builder result = subject.appendQueryParameter(key, value);
        verify(builder).appendQueryParameter(key, value);
        assertEquals(subject, result);
    }

    @Test
    public void authority() {
        TAUri.Builder result = subject.authority(TEST_URI);
        verify(builder).authority(TEST_URI);
        assertEquals(subject, result);
    }

    @Test
    public void build() {
        Uri uri = mock(Uri.class);
        when(builder.build()).thenReturn(uri);
        TAUri result = subject.build();
        assertEquals(result.uri, uri);
    }

    @Test
    public void clearQuery() {
        TAUri.Builder result = subject.clearQuery();
        verify(builder).clearQuery();
        assertEquals(subject, result);
    }

    @Test
    public void encodedAuthority() {
        TAUri.Builder result = subject.encodedAuthority(TEST_URI);
        verify(builder).encodedAuthority(TEST_URI);
        assertEquals(subject, result);
    }

    @Test
    public void encodedFragment() {
        TAUri.Builder result = subject.encodedFragment(TEST_URI);
        verify(builder).encodedFragment(TEST_URI);
        assertEquals(subject, result);
    }

    @Test
    public void encodedOpaquePart() {
        TAUri.Builder result = subject.encodedOpaquePart(TEST_URI);
        verify(builder).encodedOpaquePart(TEST_URI);
        assertEquals(subject, result);
    }

    @Test
    public void encodedPath() {
        TAUri.Builder result = subject.encodedPath(TEST_URI);
        verify(builder).encodedPath(TEST_URI);
        assertEquals(subject, result);
    }

    @Test
    public void encodedQuery() {
        TAUri.Builder result = subject.encodedQuery(TEST_URI);
        verify(builder).encodedQuery(TEST_URI);
        assertEquals(subject, result);
    }

    @Test
    public void fragment() {
        TAUri.Builder result = subject.fragment(TEST_URI);
        verify(builder).fragment(TEST_URI);
        assertEquals(subject, result);
    }

    @Test
    public void opaquePart() {
        TAUri.Builder result = subject.opaquePart(TEST_URI);
        verify(builder).opaquePart(TEST_URI);
        assertEquals(subject, result);
    }

    @Test
    public void path() {
        TAUri.Builder result = subject.path(TEST_URI);
        verify(builder).path(TEST_URI);
        assertEquals(subject, result);
    }

    @Test
    public void query() {
        TAUri.Builder result = subject.query(TEST_URI);
        verify(builder).query(TEST_URI);
        assertEquals(subject, result);
    }

    @Test
    public void scheme() {
        TAUri.Builder result = subject.scheme(TEST_URI);
        verify(builder).scheme(TEST_URI);
        assertEquals(subject, result);
    }

    @Test
    public void testToString() {
        String string = "string";
        when(builder.toString()).thenReturn(string);
        String result = subject.toString();
        assertEquals(string, result);
    }
}
