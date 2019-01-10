package com.android.testable.lib.crypto;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import androidx.annotation.NonNull;

import java.io.UnsupportedEncodingException;

public abstract class TACrypto {

    static final String ANDROID_KEY_STORE = "AndroidKeyStore";
    @NonNull
    CertProperties certProperties;
    @NonNull
    CryptoPrefs cryptoPrefs;

    TACrypto(@NonNull CertProperties certProperties, @NonNull CryptoPrefs cryptoPrefs) {
        this.certProperties = certProperties;
        this.cryptoPrefs = cryptoPrefs;
    }

    public String encryptAsBase64(String text) throws InvalidEncryptionException {
        return Base64.encodeToString(encryptString(text), Base64.NO_WRAP);
    }

    private byte[] encryptString(String text) throws InvalidEncryptionException {
        try {
            return encrypt(text.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new InvalidEncryptionException("Something went wrong when decoding the string", e);
        }
    }

    public abstract byte[] encrypt(byte[] bytes) throws InvalidEncryptionException;

    public String decryptFromBase64(String text) throws InvalidEncryptionException {
        return decryptAsString(Base64.decode(text, Base64.NO_WRAP));
    }

    private String decryptAsString(byte[] encryptedData) throws InvalidEncryptionException {
        try {
            return new String(decrypt(encryptedData), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new InvalidEncryptionException("Something went wrong when decoding the string", e);
        }
    }

    public abstract byte[] decrypt(byte[] encryptedData) throws InvalidEncryptionException;

    public static TACrypto createCrypto(CertProperties certProperties, Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return new MarshmallowTACrypto(certProperties, new CryptoPrefs(context));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            return new JellyBeanTACrypto(certProperties, new CryptoPrefs(context), context);
        } else {
            return new DefaultTACrypto(certProperties, new CryptoPrefs(context));
        }

    }
}
