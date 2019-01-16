package com.android.testable.lib.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import com.android.testable.lib.crypto.InvalidEncryptionException;
import com.android.testable.lib.crypto.TACrypto;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class EncryptableSharedPreferencesTest {

    private static final String KEY = "key";

    private EncryptableSharedPreferences subject;
    private Context context = mock(Context.class);
    private Gson gson = new Gson();
    private TACrypto taCrypto = mock(TACrypto.class);

    @Before
    public void setUp() {
        when(context.getSharedPreferences(anyString(), anyInt())).thenReturn(mock(SharedPreferences.class));
        subject = spy(new EncryptableSharedPreferences(context, "name",
                EncryptableSharedPreferences.MODE_PRIVATE, gson, taCrypto));
        doNothing().when(subject).putString(anyString(), anyString());
    }

    @Test
    public void putEncryptedString() throws InvalidEncryptionException {
        String value = "value";
        String encrypted = "encrypted";
        when(taCrypto.encryptAsBase64(value)).thenReturn(encrypted);
        subject.putEncryptedString(KEY, value);
        verify(subject).putString(KEY, encrypted);
    }

    @Test
    public void getEncryptedString() throws InvalidEncryptionException {
        String encrypted = "encrypted";
        String value = "value";
        doReturn(encrypted).when(subject).getString(KEY, "");
        when(taCrypto.decryptFromBase64(encrypted)).thenReturn(value);
        assertEquals(value, subject.getEncryptedString(KEY));
    }

    @Test
    public void putEncryptedObject() throws InvalidEncryptionException {
        TestGsonObject testGsonObject = new TestGsonObject("name1", "test1");
        String toJson = gson.toJson(testGsonObject);
        String asBase64 = "asBase64";
        when(taCrypto.encryptAsBase64(toJson)).thenReturn(asBase64);
        subject.putEncryptedObject(KEY, testGsonObject);
        verify(subject).putString(KEY, asBase64);
    }

    @Test
    public void getEncryptedObject() throws InvalidEncryptionException {
        TestGsonObject testGsonObject = new TestGsonObject("name1", "test1");
        String toJson = gson.toJson(testGsonObject);
        doReturn(toJson).when(subject).getString(KEY, "");
        when(taCrypto.decryptFromBase64(toJson)).thenReturn(toJson);
        TestGsonObject result = subject.getEncryptedObject(KEY, TestGsonObject.class);
        assertEquals(testGsonObject.getTest(), result.getTest());
        assertEquals(testGsonObject.getName(), result.getName());
    }

}