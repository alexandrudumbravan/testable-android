package com.android.testable.lib.crypto;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import com.android.testable.lib.ComponentGenerator;
import com.android.testable.lib.util.TABase64;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ComponentGenerator.class})
public class TACryptoTest {

    private TACrypto subject;
    private CertProperties certProperties = mock(CertProperties.class);
    private CryptoPrefs cryptoPrefs = mock(CryptoPrefs.class);
    private TABase64 taBase64 = mock(TABase64.class);

    @Before
    public void setUp() {
        subject = spy(new TACrypto(certProperties, cryptoPrefs, taBase64) {
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
            protected String getEncryptionAlgorithm() {
                return "";
            }

            @NonNull
            @Override
            protected String getCipherAlgorithm() {
                return "";
            }
        });
    }

    @Test
    public void encryptAsBase64() throws InvalidEncryptionException, UnsupportedEncodingException {
        String input = "input";
        String output = "output";
        byte[] encrypted = new byte[]{1, 2, 3};
        when(subject.encrypt(input.getBytes("UTF-8"))).thenReturn(encrypted);
        when(taBase64.encodeToString(encrypted, TABase64.NO_WRAP)).thenReturn(output);
        assertEquals(output, subject.encryptAsBase64(input));
    }

    @Test
    public void decryptFromBase64() throws InvalidEncryptionException, UnsupportedEncodingException {
        String input = "input";
        String output = "output";
        byte[] encrypted = new byte[]{1, 2, 3};

        when(taBase64.decode(input, TABase64.NO_WRAP)).thenReturn(encrypted);
        when(subject.decrypt(encrypted)).thenReturn(output.getBytes("UTF-8"));
        assertEquals(output, subject.decryptFromBase64(input));
    }

    @Test
    public void createCrypto() {
        ComponentGenerator componentGenerator = mock(ComponentGenerator.class);
        PowerMockito.mockStatic(ComponentGenerator.class);
        when(ComponentGenerator.create()).thenReturn(componentGenerator);
        when(componentGenerator.getBuild()).thenReturn(Build.VERSION_CODES.M);
        assertTrue(MarshmallowTACrypto.class.isInstance(TACrypto.createCrypto(certProperties, mock(Context.class))));
        when(componentGenerator.getBuild()).thenReturn(Build.VERSION_CODES.LOLLIPOP_MR1);
        assertTrue(JellyBeanTACrypto.class.isInstance(TACrypto.createCrypto(certProperties, mock(Context.class))));
        when(componentGenerator.getBuild()).thenReturn(Build.VERSION_CODES.KITKAT);
        assertTrue(JellyBeanTACrypto.class.isInstance(TACrypto.createCrypto(certProperties, mock(Context.class))));
        when(componentGenerator.getBuild()).thenReturn(Build.VERSION_CODES.JELLY_BEAN_MR2);
        assertTrue(JellyBeanTACrypto.class.isInstance(TACrypto.createCrypto(certProperties, mock(Context.class))));
        when(componentGenerator.getBuild()).thenReturn(Build.VERSION_CODES.JELLY_BEAN_MR1);
        assertTrue(DefaultTACrypto.class.isInstance(TACrypto.createCrypto(certProperties, mock(Context.class))));

    }


}