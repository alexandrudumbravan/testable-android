package com.android.testable.lib.util;

import android.os.Build;

public class BuildAccessor {

    public static int getBuild(){
       return Build.VERSION.SDK_INT;
    }
}
