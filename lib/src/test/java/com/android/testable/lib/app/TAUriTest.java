package com.android.testable.lib.app;

import android.net.Uri;
import android.os.Parcel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TAUriTest {

    private TAUri subject;
    @Mock
    private Uri uri;

    @Before
    public void setUp() {
        subject = new TAUri(uri);
    }

    @Test
    public void buildUpon() {
        subject.buildUpon();
        verify(uri).buildUpon();
    }

    @Test
    public void compareTo() {
        TAUri other = new TAUri(mock(Uri.class));
        subject.compareTo(other);
        verify(uri).compareTo(other.uri);
    }

    @Test
    public void getAuthority() {
        subject.getAuthority();
        verify(uri).getAuthority();
    }

    @Test
    public void getBooleanQueryParameter() {
        String key = "key";
        subject.getBooleanQueryParameter(key, true);
        verify(uri).getBooleanQueryParameter(key, true);
    }

    @Test
    public void getEncodedAuthority() {
        subject.getEncodedAuthority();
        verify(uri).getEncodedAuthority();
    }

    @Test
    public void getEncodedFragment() {
        subject.getEncodedFragment();
        verify(uri).getEncodedFragment();
    }

    @Test
    public void getEncodedPath() {
        subject.getEncodedPath();
        verify(uri).getEncodedPath();
    }

    @Test
    public void getEncodedQuery() {
        subject.getEncodedQuery();
        verify(uri).getEncodedQuery();
    }

    @Test
    public void getEncodedSchemeSpecificPart() {
        subject.getEncodedSchemeSpecificPart();
        verify(uri).getEncodedSchemeSpecificPart();
    }

    @Test
    public void getEncodedUserInfo() {
        subject.getEncodedUserInfo();
        verify(uri).getEncodedUserInfo();
    }

    @Test
    public void getFragment() {
        subject.getFragment();
        verify(uri).getFragment();
    }

    @Test
    public void getHost() {
        subject.getHost();
        verify(uri).getHost();
    }

    @Test
    public void getLastPathSegment() {
        subject.getLastPathSegment();
        verify(uri).getLastPathSegment();
    }

    @Test
    public void getPath() {
        subject.getPath();
        verify(uri).getPath();
    }

    @Test
    public void getPathSegments() {
        subject.getPathSegments();
        verify(uri).getPathSegments();
    }

    @Test
    public void getPort() {
        subject.getPort();
        verify(uri).getPort();
    }

    @Test
    public void getQuery() {
        subject.getQuery();
        verify(uri).getQuery();
    }

    @Test
    public void getQueryParameter() {
        String key = "key";
        subject.getQueryParameter(key);
        verify(uri).getQueryParameter(key);
    }

    @Test
    public void getQueryParameterNames() {
        subject.getQueryParameterNames();
        verify(uri).getQueryParameterNames();
    }

    @Test
    public void getQueryParameters() {
        String key = "key";
        subject.getQueryParameters(key);
        verify(uri).getQueryParameters(key);
    }

    @Test
    public void getScheme() {
        subject.getScheme();
        verify(uri).getScheme();
    }

    @Test
    public void getSchemeSpecificPart() {
        subject.getSchemeSpecificPart();
        verify(uri).getSchemeSpecificPart();
    }

    @Test
    public void getUserInfo() {
        subject.getUserInfo();
        verify(uri).getUserInfo();
    }

    @Test
    public void isAbsolute() {
        subject.isAbsolute();
        verify(uri).isAbsolute();
    }

    @Test
    public void isHierarchical() {
        subject.isHierarchical();
        verify(uri).isHierarchical();
    }

    @Test
    public void isOpaque() {
        subject.isOpaque();
        verify(uri).isOpaque();
    }

    @Test
    public void isRelative() {
        subject.isRelative();
        verify(uri).isRelative();
    }

    @Test
    public void normalizeScheme() {
        subject.normalizeScheme();
        verify(uri).normalizeScheme();
    }

    @Test
    public void testEquals() {
        TAUri other = new TAUri(uri);
        assertTrue(subject.equals(other));
    }

    @Test
    public void testHashCode() {
        assertEquals(uri.hashCode(), subject.hashCode());
    }

    @Test
    public void testToString() {
        String string = "test";
        when(uri.toString()).thenReturn(string);
        assertEquals(string, subject.toString());
    }

    @Test
    public void describeContents() {
        int contents = 7;
        when(uri.describeContents()).thenReturn(contents);
        assertEquals(contents, subject.describeContents());
    }

    @Test
    public void writeToParcel() {
        Parcel parcel = mock(Parcel.class);
        subject.writeToParcel(parcel, 0);
        verify(parcel).writeParcelable(uri, 0);
    }
}