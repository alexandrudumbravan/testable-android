package com.android.testable.lib.preferences;

import android.content.SharedPreferences;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class OnTASharedPreferencesChangeListenerTest {

    private OnTASharedPreferencesChangeListener subject;

    @Before
    public void setUp() {
        subject = spy(new OnTASharedPreferencesChangeListener() {
            @Override
            protected void onTASharedPreferenceChanged(String key) {

            }
        });
    }

    @Test
    public void onSharedPreferenceChanged() {
        String key = "key";
        subject.onSharedPreferenceChanged(mock(SharedPreferences.class), key);
        verify(subject).onTASharedPreferenceChanged(key);
    }
}