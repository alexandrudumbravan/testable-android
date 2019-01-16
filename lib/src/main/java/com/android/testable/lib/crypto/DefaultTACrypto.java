package com.android.testable.lib.crypto;

import androidx.annotation.NonNull;
import com.android.testable.lib.util.TABase64;

public class DefaultTACrypto extends TACrypto {

    protected DefaultTACrypto(@NonNull CertProperties certProperties, @NonNull CryptoPrefs cryptoPrefs,
                              @NonNull TABase64 taBase64) {
        super(certProperties, cryptoPrefs, taBase64);
    }

    @Override
    public byte[] encrypt(byte[] bytes) {
        return bytes;
    }

    @Override
    public byte[] decrypt(byte[] encryptedData) {
        return encryptedData;
    }

    @NonNull
    @Override
    protected String getCipherAlgorithm() {
        return "";
    }

    @NonNull
    @Override
    protected String getEncryptionAlgorithm() {
        return "";
    }
}
