package com.android.testable.lib.crypto;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;

public abstract class TACrypto {

    private static final String ANDROID_KEY_STORE = "AndroidKeyStore";
    private static final String CIPHER_ALGORITHM = "AES/GCM/NoPadding";
    @NonNull
    CertProperties certProperties;

    TACrypto(@NonNull CertProperties certProperties) {
        this.certProperties = certProperties;
    }

    public String encryptAsBase64(String text) throws InvalidEncryptionException {
        return Base64.encodeToString(encryptString(text), Base64.NO_WRAP);
    }

    public byte[] encryptString(String text) throws InvalidEncryptionException {
        try {
            return encrypt(text.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new InvalidEncryptionException("Something went wrong when decoding the string", e);
        }
    }

    public byte[] encrypt(byte[] bytes) throws InvalidEncryptionException {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("RSA", ANDROID_KEY_STORE);
            keyGenerator.init(createSpecs());
            SecretKey secretKey = keyGenerator.generateKey();
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return cipher.doFinal(bytes);
        } catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidKeyException | InvalidAlgorithmParameterException
                | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException e) {
            throw new InvalidEncryptionException("Something went wrong during encryption", e);
        }
    }

    @NonNull
    protected abstract AlgorithmParameterSpec createSpecs();

    public String decryptFromBase64(String text) throws InvalidEncryptionException {
        return decryptAsString(Base64.decode(text, Base64.NO_WRAP));
    }

    public String decryptAsString(byte[] encryptedData) throws InvalidEncryptionException {
        try {
            return new String(decrypt(encryptedData), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new InvalidEncryptionException("Something went wrong when decoding the string", e);
        }
    }

    public byte[] decrypt(byte[] encryptedData) throws InvalidEncryptionException {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            KeyStore.SecretKeyEntry secretKeyEntry = (KeyStore.SecretKeyEntry) keyStore
                    .getEntry(certProperties.getAlias(), null);
            SecretKey secretKey = secretKeyEntry.getSecretKey();
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return cipher.doFinal(encryptedData);
        } catch (KeyStoreException | IOException | CertificateException | NoSuchAlgorithmException | InvalidKeyException
                | UnrecoverableEntryException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException e) {
            throw new InvalidEncryptionException("Something went wrong during decryption ", e);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    public static TACrypto createCrypto(CertProperties certProperties, Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return new JellyBeanTACrypto(certProperties, context);
        } else {
            return new MarshmallowTACrypto(certProperties);
        }
    }
}
