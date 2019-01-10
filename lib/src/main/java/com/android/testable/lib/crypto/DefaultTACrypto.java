package com.android.testable.lib.crypto;

import androidx.annotation.NonNull;

public class DefaultTACrypto extends TACrypto {

    DefaultTACrypto(@NonNull CertProperties certProperties, @NonNull CryptoPrefs cryptoPrefs) {
        super(certProperties, cryptoPrefs);
    }

    @Override
    public byte[] encrypt(byte[] bytes) {
        return bytes;
    }

    @Override
    public byte[] decrypt(byte[] encryptedData) {
        return encryptedData;
    }
}
