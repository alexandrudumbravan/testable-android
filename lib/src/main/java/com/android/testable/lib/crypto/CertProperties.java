package com.android.testable.lib.crypto;

import android.os.Build;
import androidx.annotation.RequiresApi;

import java.math.BigInteger;
import java.util.Date;

public class CertProperties {

    private String alias;
    private Date startTime;
    private Date endTime;
    private BigInteger serialNumber;

    @RequiresApi(api = Build.VERSION_CODES.M)
    public CertProperties(String alias) {
        this(alias, null, null, null);
    }

    public CertProperties(String alias, Date startTime, Date endTime,
                          BigInteger serialNumber) {
        this.alias = alias;
        this.startTime = startTime;
        this.endTime = endTime;
        this.serialNumber = serialNumber;
    }

    public String getAlias() {
        return alias;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public BigInteger getSerialNumber() {
        return serialNumber;
    }
}
