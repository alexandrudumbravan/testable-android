package com.android.testable.lib.app;

import android.content.Intent;
import android.os.Build;
import androidx.annotation.RequiresApi;

public interface TAIntentFlags {

    /**
     * Constant connected to {@link Intent#FLAG_ACTIVITY_BROUGHT_TO_FRONT}
     */
    int FLAG_ACTIVITY_BROUGHT_TO_FRONT = 0x00400000;
    /**
     * Constant connected to {@link Intent#FLAG_ACTIVITY_CLEAR_TASK}
     */
    int FLAG_ACTIVITY_CLEAR_TASK = 0x00008000;
    /**
     * Constant connected to {@link Intent#FLAG_ACTIVITY_CLEAR_TOP}
     */
    int FLAG_ACTIVITY_CLEAR_TOP = 0x04000000;
    /**
     * Constant connected to {@link Intent#FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET}
     */
    @Deprecated
    int FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET = 0x00080000;
    /**
     * Constant connected to {@link Intent#FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS}
     */
    int FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS = 0x00800000;
    /**
     * Constant connected to {@link Intent#FLAG_ACTIVITY_FORWARD_RESULT}
     */
    int FLAG_ACTIVITY_FORWARD_RESULT = 0x02000000;
    /**
     * Constant connected to {@link Intent#FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY}
     */
    int FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY = 0x00100000;
    /**
     * Constant connected to {@link Intent#FLAG_ACTIVITY_LAUNCH_ADJACENT}
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    int FLAG_ACTIVITY_LAUNCH_ADJACENT = 0x00001000;
    /**
     * Constant connected to {@link Intent#FLAG_ACTIVITY_MATCH_EXTERNAL}
     */
    @RequiresApi(api = Build.VERSION_CODES.P)
    int FLAG_ACTIVITY_MATCH_EXTERNAL = 0x00000800;
    /**
     * Constant connected to {@link Intent#FLAG_ACTIVITY_MULTIPLE_TASK}
     */
    int FLAG_ACTIVITY_MULTIPLE_TASK = 0x08000000;
    /**
     * Constant connected to {@link Intent#FLAG_ACTIVITY_NEW_DOCUMENT}
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    int FLAG_ACTIVITY_NEW_DOCUMENT = 0x00080000;
    /**
     * Constant connected to {@link Intent#FLAG_ACTIVITY_NEW_TASK}
     */
    int FLAG_ACTIVITY_NEW_TASK = 0x10000000;
    /**
     * Constant connected to {@link Intent#FLAG_ACTIVITY_NO_ANIMATION}
     */
    int FLAG_ACTIVITY_NO_ANIMATION = 0x00010000;
    /**
     * Constant connected to {@link Intent#FLAG_ACTIVITY_NO_HISTORY}
     */
    int FLAG_ACTIVITY_NO_HISTORY = 0x40000000;
    /**
     * Constant connected to {@link Intent#FLAG_ACTIVITY_NO_USER_ACTION}
     */
    int FLAG_ACTIVITY_NO_USER_ACTION = 0x00040000;
    /**
     * Constant connected to {@link Intent#FLAG_ACTIVITY_PREVIOUS_IS_TOP}
     */
    int FLAG_ACTIVITY_PREVIOUS_IS_TOP = 0x01000000;
    /**
     * Constant connected to {@link Intent#FLAG_ACTIVITY_REORDER_TO_FRONT}
     */
    int FLAG_ACTIVITY_REORDER_TO_FRONT = 0x00020000;
    /**
     * Constant connected to {@link Intent#FLAG_ACTIVITY_RESET_TASK_IF_NEEDED}
     */
    int FLAG_ACTIVITY_RESET_TASK_IF_NEEDED = 0x00200000;
    /**
     * Constant connected to {@link Intent#FLAG_ACTIVITY_RETAIN_IN_RECENTS}
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    int FLAG_ACTIVITY_RETAIN_IN_RECENTS = 0x00002000;
    /**
     * Constant connected to {@link Intent#FLAG_ACTIVITY_SINGLE_TOP}
     */
    int FLAG_ACTIVITY_SINGLE_TOP = 0x20000000;
    /**
     * Constant connected to {@link Intent#FLAG_ACTIVITY_TASK_ON_HOME}
     */
    int FLAG_ACTIVITY_TASK_ON_HOME = 0x00004000;
    /**
     * Constant connected to {@link Intent#FLAG_DEBUG_LOG_RESOLUTION}
     */
    int FLAG_DEBUG_LOG_RESOLUTION = 0x00000008;
    /**
     * Constant connected to {@link Intent#FLAG_EXCLUDE_STOPPED_PACKAGES}
     */
    int FLAG_EXCLUDE_STOPPED_PACKAGES = 0x00000010;
    /**
     * Constant connected to {@link Intent#FLAG_FROM_BACKGROUND}
     */
    int FLAG_FROM_BACKGROUND = 0x00000004;
    /**
     * Constant connected to {@link Intent#FLAG_GRANT_PERSISTABLE_URI_PERMISSION}
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    int FLAG_GRANT_PERSISTABLE_URI_PERMISSION = 0x00000040;
    /**
     * Constant connected to {@link Intent#FLAG_GRANT_PREFIX_URI_PERMISSION}
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    int FLAG_GRANT_PREFIX_URI_PERMISSION = 0x00000080;
    /**
     * Constant connected to {@link Intent#FLAG_GRANT_READ_URI_PERMISSION}
     */
    int FLAG_GRANT_READ_URI_PERMISSION = 0x00000001;
    /**
     * Constant connected to {@link Intent#FLAG_GRANT_WRITE_URI_PERMISSION}
     */
    int FLAG_GRANT_WRITE_URI_PERMISSION = 0x00000002;
    /**
     * Constant connected to {@link Intent#FLAG_INCLUDE_STOPPED_PACKAGES}
     */
    int FLAG_INCLUDE_STOPPED_PACKAGES = 0x00000020;
    /**
     * Constant connected to {@link Intent#FLAG_RECEIVER_FOREGROUND}
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    int FLAG_RECEIVER_FOREGROUND = 0x10000000;
    /**
     * Constant connected to {@link Intent#FLAG_RECEIVER_NO_ABORT}
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    int FLAG_RECEIVER_NO_ABORT = 0x08000000;
    /**
     * Constant connected to {@link Intent#FLAG_RECEIVER_REGISTERED_ONLY}
     */
    int FLAG_RECEIVER_REGISTERED_ONLY = 0x40000000;
    /**
     * Constant connected to {@link Intent#FLAG_RECEIVER_REPLACE_PENDING}
     */
    int FLAG_RECEIVER_REPLACE_PENDING = 0x20000000;
    /**
     * Constant connected to {@link Intent#FLAG_RECEIVER_VISIBLE_TO_INSTANT_APPS}
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    int FLAG_RECEIVER_VISIBLE_TO_INSTANT_APPS = 0x00200000;
    /**
     * Constant connected to {@link Intent#URI_ALLOW_UNSAFE}
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    int URI_ALLOW_UNSAFE = 0x00000004;
    /**
     * Constant connected to {@link Intent#URI_ANDROID_APP_SCHEME}
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    int URI_ANDROID_APP_SCHEME = 0x00000002;
    /**
     * Constant connected to {@link Intent#URI_INTENT_SCHEME}
     */
    int URI_INTENT_SCHEME = 0x00000001;
    /**
     * Constant connected to {@link Intent#FILL_IN_ACTION}
     */
    int FILL_IN_ACTION = 0x00000001;
    /**
     * Constant connected to {@link Intent#FILL_IN_CATEGORIES}
     */
    int FILL_IN_CATEGORIES = 0x00000004;
    /**
     * Constant connected to {@link Intent#FILL_IN_CLIP_DATA}
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    int FILL_IN_CLIP_DATA = 0x00000080;
    /**
     * Constant connected to {@link Intent#FILL_IN_COMPONENT}
     */
    int FILL_IN_COMPONENT = 0x00000008;
    /**
     * Constant connected to {@link Intent#FILL_IN_DATA}
     */
    int FILL_IN_DATA = 0x00000002;
    /**
     * Constant connected to {@link Intent#FILL_IN_PACKAGE}
     */
    int FILL_IN_PACKAGE = 0x00000010;
    /**
     * Constant connected to {@link Intent#FILL_IN_SELECTOR}
     */
    @RequiresApi(api = Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
    int FILL_IN_SELECTOR = 0x00000040;
    /**
     * Constant connected to {@link Intent#FILL_IN_SOURCE_BOUNDS}
     */
    int FILL_IN_SOURCE_BOUNDS = 0x00000020;
}
