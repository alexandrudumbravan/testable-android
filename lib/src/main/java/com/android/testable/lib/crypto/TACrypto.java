package com.android.testable.lib.crypto;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import com.android.testable.lib.util.BuildAccessor;
import com.android.testable.lib.util.TABase64;

import java.io.UnsupportedEncodingException;

public abstract class TACrypto {

    static final String ANDROID_KEY_STORE = "AndroidKeyStore";
    @NonNull
    CertProperties certProperties;
    @NonNull
    CryptoPrefs cryptoPrefs;
    @NonNull
    TABase64 taBase64;

    protected TACrypto(@NonNull CertProperties certProperties, @NonNull CryptoPrefs cryptoPrefs,
                       @NonNull TABase64 taBase64) {
        this.certProperties = certProperties;
        this.cryptoPrefs = cryptoPrefs;
        this.taBase64 = taBase64;
    }

    public String encryptAsBase64(String text) throws InvalidEncryptionException {
        return taBase64.encodeToString(encryptString(text), TABase64.NO_WRAP);
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
        return decryptAsString(taBase64.decode(text, TABase64.NO_WRAP));
    }

    private String decryptAsString(byte[] encryptedData) throws InvalidEncryptionException {
        try {
            return new String(decrypt(encryptedData), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new InvalidEncryptionException("Something went wrong when decoding the string", e);
        }
    }

    public abstract byte[] decrypt(byte[] encryptedData) throws InvalidEncryptionException;

    @NonNull
    protected abstract String getEncryptionAlgorithm();

    @NonNull
    protected abstract String getCipherAlgorithm();

    @SuppressLint("NewApi")
    public static TACrypto createCrypto(CertProperties certProperties, Context context) {
        int build = BuildAccessor.getBuild();
        if (build >= Build.VERSION_CODES.M) {
            return new MarshmallowTACrypto(certProperties, new CryptoPrefs(context), new TABase64());
        } else if (build >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            return new JellyBeanTACrypto(certProperties, new CryptoPrefs(context), context, new TABase64());
        } else {
            return new DefaultTACrypto(certProperties, new CryptoPrefs(context), new TABase64());
        }

    }
}
