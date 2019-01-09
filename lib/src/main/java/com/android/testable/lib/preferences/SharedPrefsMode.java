package com.android.testable.lib.preferences;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@IntDef({TASharedPreferences.MODE_MULTI_PROCESS, TASharedPreferences.MODE_PRIVATE,
        TASharedPreferences.MODE_WORLD_READABLE, TASharedPreferences.MODE_WORLD_WRITEABLE})
@interface SharedPrefsMode {
}
