package com.android.testable.lib.preferences;

import android.content.SharedPreferences;

public abstract class OnTASharedPreferencesChangeListener implements SharedPreferences.OnSharedPreferenceChangeListener {


    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        onTASharedPreferenceChanged(key);
    }

    /**
     * Called when the preferences changed
     *
     * @param key the changed key of the preferences that was changed added or removed
     */
    protected abstract void onTASharedPreferenceChanged(String key);
}
