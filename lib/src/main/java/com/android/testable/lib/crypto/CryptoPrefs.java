package com.android.testable.lib.crypto;

import android.content.Context;
import com.android.testable.lib.preferences.TASharedPreferences;
import com.google.gson.Gson;

public class CryptoPrefs extends TASharedPreferences {

    private static final String NAME = "com.android.testable.lib.CryptoPrefs";

    private static final String KEY_IV_DATA = "com.android.testable.lib.CryptoPrefs.IV_DATA";

    public CryptoPrefs(Context context) {
        super(context, NAME, MODE_PRIVATE, new Gson());
    }

    public void putIvData(String ivData) {
        putString(KEY_IV_DATA, ivData);
    }

    public String getIvData() {
        return getString(KEY_IV_DATA, "");
    }
}
