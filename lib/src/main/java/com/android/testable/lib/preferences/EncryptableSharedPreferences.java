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

    /**
     * Calls {@link #putString(String, String)} with the encrypted value obtained from {@link TACrypto#encryptAsBase64(String)}
     *
     * @param key   The name of the preference to modify
     * @param value The value for the preference
     * @throws InvalidEncryptionException if something goes wrong with the encryption
     */
    public void putEncryptedString(String key, String value) throws InvalidEncryptionException {
        putString(key, taCrypto.encryptAsBase64(value));
    }

    /**
     * Calls {@link #getString(String, String)} and decrypts the value returned by it with {@link TACrypto#decryptFromBase64(String)}
     *
     * @param key The name of the preference to retrieve
     * @return the decrypted string
     * @throws InvalidEncryptionException if something goes wrong with the decryption
     */
    @Nullable
    public String getEncryptedString(String key) throws InvalidEncryptionException {
        return taCrypto.decryptFromBase64(getString(key, ""));
    }

    /**
     * Calls {@link #putString(String, String)} with the encrypted value obtained from {@link TACrypto#encryptAsBase64(String)}
     * applied on the {@link Gson#toJson(Object)}
     *
     * @param key   The name of the preference to modify
     * @param value The value for the preference
     * @throws InvalidEncryptionException if something goes wrong with the encryption
     */
    public <T> void putEncryptedObject(String key, T value) throws InvalidEncryptionException {
        putString(key, taCrypto.encryptAsBase64(gson.toJson(value)));
    }

    /**
     * Calls {@link #getString(String, String)} after which it decrypts it using {@link TACrypto#decryptFromBase64(String)}
     * and at the end it converts it from a JSON using {@link Gson#fromJson(String, Class)}
     *
     * @param key       The name of the preference to retrieve
     * @param typeClass The Class of the object to be retrieved
     * @return the decrypted object
     * @throws InvalidEncryptionException if something goes wrong with the decryption
     */
    public <T> T getEncryptedObject(String key, Class<T> typeClass) throws InvalidEncryptionException {
        return gson.fromJson(taCrypto.decryptFromBase64(getString(key, "")), typeClass);
    }

    @NonNull
    public static EncryptableSharedPreferences createDefaultSharedPrefs(@NonNull Context context, @NonNull String name, @NonNull CertProperties certProperties) {
        return new EncryptableSharedPreferences(context, name, MODE_PRIVATE, new Gson(), TACrypto.createCrypto(certProperties, context));
    }
}
