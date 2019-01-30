package com.android.testable.lib;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.annotation.NonNull;

public class ComponentGenerator {

    @NonNull
    public IntentFilter createIntentFilter(String action) {
        return new IntentFilter(action);
    }

    public int getBuild() {
        return Build.VERSION.SDK_INT;
    }

    @NonNull
    public static ComponentGenerator create() {
        return new ComponentGenerator();
    }
}
