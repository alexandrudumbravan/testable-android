package com.android.testable.lib.crypto;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyProperties;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;

@RequiresApi(api = Build.VERSION_CODES.M)
public class MarshmallowTACrypto extends TACrypto {

    MarshmallowTACrypto(@NonNull CertProperties certProperties, @NonNull CryptoPrefs cryptoPrefs) {
        super(certProperties, cryptoPrefs);
    }

    @Override
    public byte[] encrypt(byte[] bytes) throws InvalidEncryptionException {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", ANDROID_KEY_STORE);
            keyGenerator.init(new KeyGenParameterSpec.Builder(certProperties.getAlias(),
                    KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
                    .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
                    .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                    .build());
            SecretKey secretKey = keyGenerator.generateKey();
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            cryptoPrefs.putIvData(Base64.encodeToString(cipher.getIV(), Base64.NO_WRAP));
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
            KeyStore.SecretKeyEntry secretKeyEntry = (KeyStore.SecretKeyEntry) keyStore
                    .getEntry(certProperties.getAlias(), null);
            SecretKey secretKey = secretKeyEntry.getSecretKey();
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            GCMParameterSpec ivParameterSpec = new GCMParameterSpec(128, Base64.decode(cryptoPrefs.getIvData(), Base64.NO_WRAP));
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
            return cipher.doFinal(encryptedData);
        } catch (KeyStoreException | IOException | CertificateException | NoSuchAlgorithmException | InvalidKeyException
                | UnrecoverableEntryException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException
                | InvalidAlgorithmParameterException e) {
            throw new InvalidEncryptionException("Something went wrong during decryption ", e);
        }
    }
}
