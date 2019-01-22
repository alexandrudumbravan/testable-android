package com.android.testable.lib.app;

import android.content.Intent;
import android.os.Build;
import androidx.annotation.RequiresApi;

public interface TAIntentCategories {

    /**
     * Constant connected to {@link Intent#CATEGORY_ALTERNATIVE}
     */
    String CATEGORY_ALTERNATIVE = "android.intent.category.ALTERNATIVE";
    /**
     * Constant connected to {@link Intent#CATEGORY_APP_BROWSER}
     */
    @RequiresApi(api = Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
    String CATEGORY_APP_BROWSER = "android.intent.category.APP_BROWSER";
    /**
     * Constant connected to {@link Intent#CATEGORY_APP_CALCULATOR}
     */
    @RequiresApi(api = Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
    String CATEGORY_APP_CALCULATOR = "android.intent.category.APP_CALCULATOR";
    /**
     * Constant connected to {@link Intent#CATEGORY_APP_CALENDAR}
     */
    @RequiresApi(api = Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
    String CATEGORY_APP_CALENDAR = "android.intent.category.APP_CALENDAR";
    /**
     * Constant connected to {@link Intent#CATEGORY_APP_CONTACTS}
     */
    @RequiresApi(api = Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
    String CATEGORY_APP_CONTACTS = "android.intent.category.APP_CONTACTS";
    /**
     * Constant connected to {@link Intent#CATEGORY_APP_EMAIL}
     */
    @RequiresApi(api = Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
    String CATEGORY_APP_EMAIL = "android.intent.category.APP_EMAIL";
    /**
     * Constant connected to {@link Intent#CATEGORY_APP_GALLERY}
     */
    @RequiresApi(api = Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
    String CATEGORY_APP_GALLERY = "android.intent.category.APP_GALLERY";
    /**
     * Constant connected to {@link Intent#CATEGORY_APP_MAPS}
     */
    @RequiresApi(api = Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
    String CATEGORY_APP_MAPS = "android.intent.category.APP_MAPS";
    /**
     * Constant connected to {@link Intent#CATEGORY_APP_MARKET}
     */
    String CATEGORY_APP_MARKET = "android.intent.category.APP_MARKET";
    /**
     * Constant connected to {@link Intent#CATEGORY_APP_MESSAGING}
     */
    @RequiresApi(api = Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
    String CATEGORY_APP_MESSAGING = "android.intent.category.APP_MESSAGING";
    /**
     * Constant connected to {@link Intent#CATEGORY_APP_MUSIC}
     */
    @RequiresApi(api = Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
    String CATEGORY_APP_MUSIC = "android.intent.category.APP_MUSIC";
    /**
     * Constant connected to {@link Intent#CATEGORY_BROWSABLE}
     */
    String CATEGORY_BROWSABLE = "android.intent.category.BROWSABLE";
    /**
     * Constant connected to {@link Intent#CATEGORY_CAR_DOCK}
     */
    String CATEGORY_CAR_DOCK = "android.intent.category.CAR_DOCK";
    /**
     * Constant connected to {@link Intent#CATEGORY_CAR_MODE}
     */
    String CATEGORY_CAR_MODE = "android.intent.category.CAR_MODE";
    /**
     * Constant connected to {@link Intent#CATEGORY_DEFAULT}
     */
    String CATEGORY_DEFAULT = "android.intent.category.DEFAULT";
    /**
     * Constant connected to {@link Intent#CATEGORY_DESK_DOCK}
     */
    String CATEGORY_DESK_DOCK = "android.intent.category.DESK_DOCK";
    /**
     * Constant connected to {@link Intent#CATEGORY_DEVELOPMENT_PREFERENCE}
     */
    String CATEGORY_DEVELOPMENT_PREFERENCE = "android.intent.category.DEVELOPMENT_PREFERENCE";
    /**
     * Constant connected to {@link Intent#CATEGORY_EMBED}
     */
    String CATEGORY_EMBED = "android.intent.category.EMBED";
    /**
     * Constant connected to {@link Intent#CATEGORY_FRAMEWORK_INSTRUMENTATION_TEST}
     */
    String CATEGORY_FRAMEWORK_INSTRUMENTATION_TEST = "android.intent.category.FRAMEWORK_INSTRUMENTATION_TEST";
    /**
     * Constant connected to {@link Intent#CATEGORY_HE_DESK_DOCK}
     */
    String CATEGORY_HE_DESK_DOCK = "android.intent.category.HE_DESK_DOCK";
    /**
     * Constant connected to {@link Intent#CATEGORY_HOME}
     */
    String CATEGORY_HOME = "android.intent.category.HOME";
    /**
     * Constant connected to {@link Intent#CATEGORY_INFO}
     */
    String CATEGORY_INFO = "android.intent.category.INFO";
    /**
     * Constant connected to {@link Intent#CATEGORY_LAUNCHER}
     */
    String CATEGORY_LAUNCHER = "android.intent.category.LAUNCHER";
    /**
     * Constant connected to {@link Intent#CATEGORY_LEANBACK_LAUNCHER}
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    String CATEGORY_LEANBACK_LAUNCHER = "android.intent.category.LEANBACK_LAUNCHER";
    /**
     * Constant connected to {@link Intent#CATEGORY_LE_DESK_DOCK}
     */
    String CATEGORY_LE_DESK_DOCK = "android.intent.category.LE_DESK_DOCK";
    /**
     * Constant connected to {@link Intent#CATEGORY_MONKEY}
     */
    String CATEGORY_MONKEY = "android.intent.category.MONKEY";
    /**
     * Constant connected to {@link Intent#CATEGORY_OPENABLE}
     */
    String CATEGORY_OPENABLE = "android.intent.category.OPENABLE";
    /**
     * Constant connected to {@link Intent#CATEGORY_PREFERENCE}
     */
    String CATEGORY_PREFERENCE = "android.intent.category.PREFERENCE";
    /**
     * Constant connected to {@link Intent#CATEGORY_SAMPLE_CODE}
     */
    String CATEGORY_SAMPLE_CODE = "android.intent.category.SAMPLE_CODE";
    /**
     * Constant connected to {@link Intent#CATEGORY_SELECTED_ALTERNATIVE}
     */
    String CATEGORY_SELECTED_ALTERNATIVE = "android.intent.category.SELECTED_ALTERNATIVE";
    /**
     * Constant connected to {@link Intent#CATEGORY_TAB}
     */
    String CATEGORY_TAB = "android.intent.category.TAB";
    /**
     * Constant connected to {@link Intent#CATEGORY_TEST}
     */
    String CATEGORY_TEST = "android.intent.category.TEST";
    /**
     * Constant connected to {@link Intent#CATEGORY_TYPED_OPENABLE}
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    String CATEGORY_TYPED_OPENABLE = "android.intent.category.TYPED_OPENABLE";
    /**
     * Constant connected to {@link Intent#CATEGORY_UNIT_TEST}
     */
    String CATEGORY_UNIT_TEST = "android.intent.category.UNIT_TEST";
    /**
     * Constant connected to {@link Intent#CATEGORY_VOICE}
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    String CATEGORY_VOICE = "android.intent.category.VOICE";
    /**
     * Constant connected to {@link Intent#CATEGORY_VR_HOME}
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    String CATEGORY_VR_HOME = "android.intent.category.VR_HOME";
}
