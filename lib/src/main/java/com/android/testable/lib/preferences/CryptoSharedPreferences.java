package com.android.testable.lib.preferences;

import android.content.Context;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.android.testable.lib.crypto.CertProperties;
import com.android.testable.lib.crypto.InvalidEncryptionException;
import com.android.testable.lib.crypto.TACrypto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class CryptoSharedPreferences extends TASharedPreferences {

    private TACrypto taCrypto;

    public CryptoSharedPreferences(Context context, String name, @SharedPrefsMode int mode, CertProperties certProperties) {
        super(context, name, mode);
        taCrypto = TACrypto.createCrypto(certProperties, context);
    }

    public CryptoSharedPreferences(Context context, String name, @SharedPrefsMode int mode, @Nullable Gson gson, CertProperties certProperties) {
        super(context, name, mode, gson);
        taCrypto = TACrypto.createCrypto(certProperties, context);
    }


    public void putEncryptedString(String key, String value) throws InvalidEncryptionException {
        putString(key, taCrypto.encryptAsBase64(value));
    }

    @Nullable
    public String getEncryptedString(String key, String defaultValue) throws InvalidEncryptionException {
        return taCrypto.decryptFromBase64(getString(key, ""));
    }

    public <T> void putEncryptedObject(String key, T value) throws InvalidEncryptionException {
        putString(key, taCrypto.encryptAsBase64(gson.toJson(value)));
    }

    public <T> T getEncryptedObject(String key) throws InvalidEncryptionException {
        return gson.fromJson(taCrypto.decryptFromBase64(getString(key, "")), new TypeToken<T>() {
        }.getType());
    }
}
