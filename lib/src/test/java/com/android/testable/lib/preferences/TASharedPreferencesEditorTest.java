package com.android.testable.lib.preferences;

import android.content.SharedPreferences;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TASharedPreferencesEditorTest {

    private static final String KEY = "key";

    private TASharedPreferencesEditor subject;
    @Mock
    private SharedPreferences.Editor editor;

    @Before
    public void setUp() {
        subject = new TASharedPreferencesEditor(editor);
    }

    @Test
    public void apply() {
        subject.apply();
        verify(editor).apply();
    }

    @Test
    public void clear() {
        subject.clear();
        verify(editor).clear();
    }

    @Test
    public void commit() {
        subject.commit();
        verify(editor).commit();
    }

    @Test
    public void putBoolean() {
        subject.putBoolean(KEY, true);
        verify(editor).putBoolean(KEY, true);
    }

    @Test
    public void putFloat() {
        float value = 1f;
        subject.putFloat(KEY, value);
        verify(editor).putFloat(KEY, value);
    }

    @Test
    public void putInt() {
        int value = 1;
        subject.putInt(KEY, value);
        verify(editor).putInt(KEY, value);
    }

    @Test
    public void putLong() {
        long value = 1L;
        subject.putLong(KEY, value);
        verify(editor).putLong(KEY, value);
    }

    @Test
    public void putString() {
        String value = "value";
        subject.putString(KEY, value);
        verify(editor).putString(KEY, value);
    }

    @Test
    public void putStringSet() {
        Set<String> value = mock(Set.class);
        subject.putStringSet(KEY, value);
        verify(editor).putStringSet(KEY, value);
    }

    @Test
    public void remove() {
        subject.remove(KEY);
        verify(editor).remove(KEY);
    }
}