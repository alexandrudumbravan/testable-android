package com.android.testable.lib.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TASharedPreferencesTest {

    private static final String KEY = "key";

    private TASharedPreferences subject;
    @Mock
    private SharedPreferences sharedPreferences;
    @Mock
    private Context context;

    @Before
    public void setUp() {
        when(context.getSharedPreferences(anyString(), anyInt())).thenReturn(sharedPreferences);
        subject = new TASharedPreferences(context, "name", TASharedPreferences.MODE_PRIVATE);
    }

    @Test
    public void contains() {
        subject.contains(KEY);
        verify(sharedPreferences).contains(KEY);
    }

    @Test
    public void edit() {
        SharedPreferences.Editor editor = mock(SharedPreferences.Editor.class);
        when(sharedPreferences.edit()).thenReturn(editor);
        assertEquals(editor, subject.edit().editor);
    }

    @Test
    public void getAll() {
        Map values = mock(Map.class);
        when(sharedPreferences.getAll()).thenReturn(values);
        assertEquals(values, subject.getAll());
    }

    @Test
    public void getBoolean() {
        when(sharedPreferences.getBoolean(KEY, true)).thenReturn(true);
        assertTrue(subject.getBoolean(KEY, true));
    }

    @Test
    public void getFloat() {
        float value = 1f;
        float defaultValue = 2f;
        when(sharedPreferences.getFloat(KEY, defaultValue)).thenReturn(value);
        assertEquals(value, subject.getFloat(KEY, defaultValue), 0);
    }

    @Test
    public void getInt() {
        int value = 1;
        int defaultValue = 2;
        when(sharedPreferences.getInt(KEY, defaultValue)).thenReturn(value);
        assertEquals(value, subject.getInt(KEY, defaultValue));
    }

    @Test
    public void getLong() {
        long value = 1;
        long defaultValue = 2;
        when(sharedPreferences.getLong(KEY, defaultValue)).thenReturn(value);
        assertEquals(value, subject.getLong(KEY, defaultValue));
    }

    @Test
    public void getString() {
        String value = "value";
        String defaultValue = "defaultValue";
        when(sharedPreferences.getString(KEY, defaultValue)).thenReturn(value);
        assertEquals(value, subject.getString(KEY, defaultValue));
    }

    @Test
    public void getStringSet() {
        Set<String> value = mock(Set.class);
        Set<String> defaultValue = mock(Set.class);
        when(sharedPreferences.getStringSet(KEY, defaultValue)).thenReturn(value);
        assertEquals(value, subject.getStringSet(KEY, defaultValue));
    }

    @Test
    public void registerOnSharedPreferenceChangeListener() {
        OnTASharedPreferencesChangeListener onTASharedPreferencesChangeListener = mock(OnTASharedPreferencesChangeListener.class);
        subject.registerOnSharedPreferenceChangeListener(onTASharedPreferencesChangeListener);
        verify(sharedPreferences).registerOnSharedPreferenceChangeListener(onTASharedPreferencesChangeListener);
    }

    @Test
    public void unregisterOnSharedPreferenceChangeListener() {
        OnTASharedPreferencesChangeListener onTASharedPreferencesChangeListener = mock(OnTASharedPreferencesChangeListener.class);
        subject.unregisterOnSharedPreferenceChangeListener(onTASharedPreferencesChangeListener);
        verify(sharedPreferences).unregisterOnSharedPreferenceChangeListener(onTASharedPreferencesChangeListener);
    }

    @Test
    public void checkModePrivate() {
        Context context = mock(Context.class);
        String name = "name";
        new TASharedPreferences(context, name, TASharedPreferences.MODE_PRIVATE);
        verify(context).getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    @Test
    public void checkModeWorldReadable() {
        Context context = mock(Context.class);
        String name = "name";
        new TASharedPreferences(context, name, TASharedPreferences.MODE_WORLD_READABLE);
        verify(context).getSharedPreferences(name, Context.MODE_WORLD_READABLE);
    }

    @Test
    public void checkModeWorldWriteable() {
        Context context = mock(Context.class);
        String name = "name";
        new TASharedPreferences(context, name, TASharedPreferences.MODE_WORLD_WRITEABLE);
        verify(context).getSharedPreferences(name, Context.MODE_WORLD_WRITEABLE);
    }

    @Test
    public void checkModeMultiProcess() {
        Context context = mock(Context.class);
        String name = "name";
        new TASharedPreferences(context, name, TASharedPreferences.MODE_MULTI_PROCESS);
        verify(context).getSharedPreferences(name, Context.MODE_MULTI_PROCESS);
    }
}