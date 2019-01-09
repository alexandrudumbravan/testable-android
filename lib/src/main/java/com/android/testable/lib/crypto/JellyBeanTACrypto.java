package com.android.testable.lib.crypto;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import javax.security.auth.x500.X500Principal;
import java.security.spec.AlgorithmParameterSpec;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class JellyBeanTACrypto extends TACrypto {

    private Context context;

    public JellyBeanTACrypto(CertProperties certProperties, Context context) {
        super(certProperties);
        this.context = context.getApplicationContext();
    }

    @Nullable
    @Override
    protected AlgorithmParameterSpec createSpecs() {
        return new KeyPairGeneratorSpec.Builder(context)
                .setAlias(certProperties.getAlias())
                .setSubject(new X500Principal("CN=" + certProperties.getAlias()))
                .setSerialNumber(certProperties.getSerialNumber())
                .setStartDate(certProperties.getStartTime())
                .setEndDate(certProperties.getEndTime())
                .build();
    }
}
