package com.android.testable.lib.crypto;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyProperties;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.security.spec.AlgorithmParameterSpec;

@RequiresApi(api = Build.VERSION_CODES.M)
public class MarshmallowTACrypto extends TACrypto {

    public MarshmallowTACrypto(CertProperties certProperties) {
        super(certProperties);
    }

    @Nullable
    @Override
    protected AlgorithmParameterSpec createSpecs() {
        return new KeyGenParameterSpec.Builder(certProperties.getAlias(),
                KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
                .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                .build();
    }
}
