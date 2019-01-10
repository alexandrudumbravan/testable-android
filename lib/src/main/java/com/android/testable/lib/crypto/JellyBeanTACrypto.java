package com.android.testable.lib.crypto;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.security.auth.x500.X500Principal;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class JellyBeanTACrypto extends TACrypto {

    @NonNull
    private Context context;

    JellyBeanTACrypto(@NonNull CertProperties certProperties, @NonNull CryptoPrefs cryptoPrefs, @NonNull Context context) {
        super(certProperties, cryptoPrefs);
        this.context = context;
    }

    @Override
    public byte[] encrypt(byte[] bytes) throws InvalidEncryptionException {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", ANDROID_KEY_STORE);
            keyPairGenerator.initialize(new KeyPairGeneratorSpec.Builder(context)
                    .setAlias(certProperties.getAlias())
                    .setSubject(new X500Principal("CN=" + certProperties.getAlias()))
                    .setSerialNumber(certProperties.getSerialNumber())
                    .setStartDate(certProperties.getStartTime())
                    .setEndDate(certProperties.getEndTime())
                    .build());
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
            return cipher.doFinal(bytes);
        } catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidKeyException | InvalidAlgorithmParameterException
                | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException e) {
            throw new InvalidEncryptionException("Something went wrong during encryption", e);
        }
    }

    @Override
    public byte[] decrypt(byte[] encryptedData) throws InvalidEncryptionException {
        try {
            KeyStore keyStore = KeyStore.getInstance(ANDROID_KEY_STORE);
            keyStore.load(null);
            KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore
                    .getEntry(certProperties.getAlias(), null);
            Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, privateKeyEntry.getPrivateKey());
            return cipher.doFinal(encryptedData);
        } catch (KeyStoreException | IOException | CertificateException | NoSuchAlgorithmException | InvalidKeyException
                | UnrecoverableEntryException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException e) {
            throw new InvalidEncryptionException("Something went wrong during decryption ", e);
        }
    }
}
