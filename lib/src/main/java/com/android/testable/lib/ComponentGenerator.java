package com.android.testable.lib;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;

public class ComponentGenerator {

    public IntentFilter createIntentFilter(String action) {
        return new IntentFilter(action);
    }

    public int getBuild() {
        return Build.VERSION.SDK_INT;
    }

    public Intent createIntent(Context context, Class<?> myClass) {
        return new Intent(context, myClass);
    }

    public static ComponentGenerator create() {
        return new ComponentGenerator();
    }
}
