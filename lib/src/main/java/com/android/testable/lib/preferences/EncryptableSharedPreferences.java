package com.android.testable.lib.preferences;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.testable.lib.crypto.CertProperties;
import com.android.testable.lib.crypto.InvalidEncryptionException;
import com.android.testable.lib.crypto.TACrypto;
import com.google.gson.Gson;


public class EncryptableSharedPreferences extends TASharedPreferences {

    private TACrypto taCrypto;

    public EncryptableSharedPreferences(Context context, String name, @SharedPrefsMode int mode, @NonNull Gson gson, TACrypto taCrypto) {
        super(context, name, mode, gson);
        this.taCrypto = taCrypto;
    }

    public void putEncryptedString(String key, String value) throws InvalidEncryptionException {
        putString(key, taCrypto.encryptAsBase64(value));
    }

    @Nullable
    public String getEncryptedString(String key) throws InvalidEncryptionException {
        return taCrypto.decryptFromBase64(getString(key, ""));
    }

    public <T> void putEncryptedObject(String key, T value) throws InvalidEncryptionException {
        putString(key, taCrypto.encryptAsBase64(gson.toJson(value)));
    }

    public <T> T getEncryptedObject(String key, Class<T> typeClass) throws InvalidEncryptionException {
        return gson.fromJson(taCrypto.decryptFromBase64(getString(key, "")), typeClass);
    }

    public static EncryptableSharedPreferences createDefaultSharedPrefs(Context context, String name, CertProperties certProperties) {
        return new EncryptableSharedPreferences(context, name, MODE_PRIVATE, new Gson(), TACrypto.createCrypto(certProperties, context));
    }
}
