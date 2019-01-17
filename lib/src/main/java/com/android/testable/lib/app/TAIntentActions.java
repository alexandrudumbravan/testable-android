package com.android.testable.lib.app;

import android.content.Intent;
import android.os.Build;
import androidx.annotation.RequiresApi;

public interface TAIntentActions {

    /**
     * Constant connected to {@link Intent#ACTION_AIRPLANE_MODE_CHANGED}
     */
    String ACTION_AIRPLANE_MODE_CHANGED = "android.intent.action.AIRPLANE_MODE";
    /**
     * Constant connected to {@link Intent#ACTION_ALL_APPS}
     */
    String ACTION_ALL_APPS = "android.intent.action.ALL_APPS";
    /**
     * Constant connected to {@link Intent#ACTION_ANSWER}
     */
    String ACTION_ANSWER = "android.intent.action.ANSWER";
    /**
     * Constant connected to {@link Intent#ACTION_APPLICATION_PREFERENCES}
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    String ACTION_APPLICATION_PREFERENCES = "android.intent.action.APPLICATION_PREFERENCES";
    /**
     * Constant connected to {@link Intent#ACTION_APPLICATION_RESTRICTIONS_CHANGED}
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    String ACTION_APPLICATION_RESTRICTIONS_CHANGED = "android.intent.action.APPLICATION_RESTRICTIONS_CHANGED";
    /**
     * Constant connected to {@link Intent#ACTION_APP_ERROR}
     */
    String ACTION_APP_ERROR = "android.intent.action.APP_ERROR";
    /**
     * Constant connected to {@link Intent#ACTION_ASSIST}
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    String ACTION_ASSIST = "android.intent.action.ASSIST";
    /**
     * Constant connected to {@link Intent#ACTION_ATTACH_DATA}
     */
    String ACTION_ATTACH_DATA = "android.intent.action.ATTACH_DATA";
    /**
     * Constant connected to {@link Intent#ACTION_BATTERY_CHANGED}
     */
    String ACTION_BATTERY_CHANGED = "android.intent.action.BATTERY_CHANGED";
    /**
     * Constant connected to {@link Intent#ACTION_BATTERY_LOW}
     */
    String ACTION_BATTERY_LOW = "android.intent.action.BATTERY_LOW";
    /**
     * Constant connected to {@link Intent#ACTION_BATTERY_OKAY}
     */
    String ACTION_BATTERY_OKAY = "android.intent.action.ACTION_BATTERY_OKAY";
    /**
     * Constant connected to {@link Intent#ACTION_BOOT_COMPLETED}
     */
    String ACTION_BOOT_COMPLETED = "android.intent.action.ACTION_BOOT_COMPLETED";
    /**
     * Constant connected to {@link Intent#ACTION_BUG_REPORT}
     */
    String ACTION_BUG_REPORT = "android.intent.action.BUG_REPORT";
    /**
     * Constant connected to {@link Intent#ACTION_CALL}
     */
    String ACTION_CALL = "android.intent.action.CALL";
    /**
     * Constant connected to {@link Intent#ACTION_CALL_BUTTON}
     */
    String ACTION_CALL_BUTTON = "android.intent.action.CALL_BUTTON";
    /**
     * Constant connected to {@link Intent#ACTION_CAMERA_BUTTON}
     */
    String ACTION_CAMERA_BUTTON = "android.intent.action.CAMERA_BUTTON";
    /**
     * Constant connected to {@link Intent#ACTION_CARRIER_SETUP}
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    String ACTION_CARRIER_SETUP = "android.intent.action.CARRIER_SETUP";
    /**
     * Constant connected to {@link Intent#ACTION_CHOOSER}
     */
    String ACTION_CHOOSER = "android.intent.action.CHOOSER";
    /**
     * Constant connected to {@link Intent#ACTION_CLOSE_SYSTEM_DIALOGS}
     */
    String ACTION_CLOSE_SYSTEM_DIALOGS = "android.intent.action.CLOSE_SYSTEM_DIALOGS";
    /**
     * Constant connected to {@link Intent#ACTION_CONFIGURATION_CHANGED}
     */
    String ACTION_CONFIGURATION_CHANGED = "android.intent.action.CONFIGURATION_CHANGED";
    /**
     * Constant connected to {@link Intent#ACTION_CREATE_DOCUMENT}
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    String ACTION_CREATE_DOCUMENT = "android.intent.action.CREATE_DOCUMENT";
    /**
     * Constant connected to {@link Intent#ACTION_CREATE_SHORTCUT}
     */
    String ACTION_CREATE_SHORTCUT = "android.intent.action.CREATE_SHORTCUT";
    /**
     * Constant connected to {@link Intent#ACTION_DATE_CHANGED}
     */
    String ACTION_DATE_CHANGED = "android.intent.action.DATE_CHANGED";
    /**
     * Constant connected to {@link Intent#ACTION_DEFAULT}
     */
    String ACTION_DEFAULT = "android.intent.action.VIEW";
    /**
     * Constant connected to {@link Intent#ACTION_DELETE}
     */
    String ACTION_DELETE = "android.intent.action.DELETE";
    /**
     * Constant connected to {@link Intent#ACTION_DEVICE_STORAGE_LOW}
     */
    @Deprecated
    String ACTION_DEVICE_STORAGE_LOW = "android.intent.action.DEVICE_STORAGE_LOW";
    /**
     * Constant connected to {@link Intent#ACTION_DEVICE_STORAGE_OK}
     */
    @Deprecated
    String ACTION_DEVICE_STORAGE_OK = "android.intent.action.DEVICE_STORAGE_OK";
    /**
     * Constant connected to {@link Intent#ACTION_DIAL}
     */
    String ACTION_DIAL = "android.intent.action.DIAL";
    /**
     * Constant connected to {@link Intent#ACTION_DOCK_EVENT}
     */
    String ACTION_DOCK_EVENT = "android.intent.action.DOCK_EVENT";
    /**
     * Constant connected to {@link Intent#ACTION_DREAMING_STARTED}
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    String ACTION_DREAMING_STARTED = "android.intent.action.DREAMING_STARTED";
    /**
     * Constant connected to {@link Intent#ACTION_DREAMING_STOPPED}
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    String ACTION_DREAMING_STOPPED = "android.intent.action.DREAMING_STOPPED";
    /**
     * Constant connected to {@link Intent#ACTION_EDIT}
     */
    String ACTION_EDIT = "android.intent.action.EDIT";
    /**
     * Constant connected to {@link Intent#ACTION_EXTERNAL_APPLICATIONS_AVAILABLE}
     */
    String ACTION_EXTERNAL_APPLICATIONS_AVAILABLE = "android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE";
    /**
     * Constant connected to {@link Intent#ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE}
     */
    String ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE = "android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE";
    /**
     * Constant connected to {@link Intent#ACTION_FACTORY_TEST}
     */
    String ACTION_FACTORY_TEST = "android.intent.action.FACTORY_TEST";
    /**
     * Constant connected to {@link Intent#ACTION_GET_CONTENT}
     */
    String ACTION_GET_CONTENT = "android.intent.action.GET_CONTENT";
    /**
     * Constant connected to {@link Intent#ACTION_GET_RESTRICTION_ENTRIES}
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    String ACTION_GET_RESTRICTION_ENTRIES = "android.intent.action.GET_RESTRICTION_ENTRIES";
    /**
     * Constant connected to {@link Intent#ACTION_GTALK_SERVICE_CONNECTED}
     */
    String ACTION_GTALK_SERVICE_CONNECTED = "android.intent.action.GTALK_CONNECTED";
    /**
     * Constant connected to {@link Intent#ACTION_GTALK_SERVICE_DISCONNECTED}
     */
    String ACTION_GTALK_SERVICE_DISCONNECTED = "android.intent.action.GTALK_DISCONNECTED";
    /**
     * Constant connected to {@link Intent#ACTION_HEADSET_PLUG}
     */
    String ACTION_HEADSET_PLUG = "android.intent.action.HEADSET_PLUG";
    /**
     * Constant connected to {@link Intent#ACTION_INPUT_METHOD_CHANGED}
     */
    String ACTION_INPUT_METHOD_CHANGED = "android.intent.action.INPUT_METHOD_CHANGED";
    /**
     * Constant connected to {@link Intent#ACTION_INSERT}
     */
    String ACTION_INSERT = "android.intent.action.INSERT";
    /**
     * Constant connected to {@link Intent#ACTION_INSERT_OR_EDIT}
     */
    String ACTION_INSERT_OR_EDIT = "android.intent.action.INSERT_OR_EDIT";
    /**
     * Constant connected to {@link Intent#ACTION_INSTALL_FAILURE}
     */
    @RequiresApi(api = Build.VERSION_CODES.O_MR1)
    String ACTION_INSTALL_FAILURE = "android.intent.action.INSTALL_FAILURE";
    /**
     * Constant connected to {@link Intent#ACTION_INSTALL_PACKAGE}
     */
    String ACTION_INSTALL_PACKAGE = "android.intent.action.INSTALL_PACKAGE";
    /**
     * Constant connected to {@link Intent#ACTION_LOCALE_CHANGED}
     */
    String ACTION_LOCALE_CHANGED = "android.intent.action.LOCALE_CHANGED";
    /**
     * Constant connected to {@link Intent#ACTION_LOCKED_BOOT_COMPLETED}
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    String ACTION_LOCKED_BOOT_COMPLETED = "android.intent.action.LOCKED_BOOT_COMPLETED";
    /**
     * Constant connected to {@link Intent#ACTION_MAIN}
     */
    String ACTION_MAIN = "android.intent.action.MAIN";
    /**
     * Constant connected to {@link Intent#ACTION_MANAGED_PROFILE_ADDED}
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    String ACTION_MANAGED_PROFILE_ADDED = "android.intent.action.MANAGED_PROFILE_ADDED";
    /**
     * Constant connected to {@link Intent#ACTION_MANAGED_PROFILE_AVAILABLE}
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    String ACTION_MANAGED_PROFILE_AVAILABLE = "android.intent.action.MANAGED_PROFILE_AVAILABLE";
    /**
     * Constant connected to {@link Intent#ACTION_MANAGED_PROFILE_REMOVED}
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    String ACTION_MANAGED_PROFILE_REMOVED = "android.intent.action.MANAGED_PROFILE_REMOVED";
    /**
     * Constant connected to {@link Intent#ACTION_MANAGED_PROFILE_UNAVAILABLE}
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    String ACTION_MANAGED_PROFILE_UNAVAILABLE = "android.intent.action.MANAGED_PROFILE_UNAVAILABLE";
    /**
     * Constant connected to {@link Intent#ACTION_MANAGED_PROFILE_UNLOCKED}
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    String ACTION_MANAGED_PROFILE_UNLOCKED = "android.intent.action.MANAGED_PROFILE_UNLOCKED";
    /**
     * Constant connected to {@link Intent#ACTION_MANAGE_NETWORK_USAGE}
     */
    String ACTION_MANAGE_NETWORK_USAGE = "android.intent.action.MANAGE_NETWORK_USAGE";
    /**
     * Constant connected to {@link Intent#ACTION_MANAGE_PACKAGE_STORAGE}
     */
    String ACTION_MANAGE_PACKAGE_STORAGE = "android.intent.action.MANAGE_PACKAGE_STORAGE";
    /**
     * Constant connected to {@link Intent#ACTION_MEDIA_BAD_REMOVAL}
     */
    String ACTION_MEDIA_BAD_REMOVAL = "android.intent.action.MEDIA_BAD_REMOVAL";
    /**
     * Constant connected to {@link Intent#ACTION_MEDIA_BUTTON}
     */
    String ACTION_MEDIA_BUTTON = "android.intent.action.MEDIA_BUTTON";
    /**
     * Constant connected to {@link Intent#ACTION_MEDIA_CHECKING}
     */
    String ACTION_MEDIA_CHECKING = "android.intent.action.MEDIA_CHECKING";
    /**
     * Constant connected to {@link Intent#ACTION_MEDIA_EJECT}
     */
    String ACTION_MEDIA_EJECT = "android.intent.action.MEDIA_EJECT";
    /**
     * Constant connected to {@link Intent#ACTION_MEDIA_MOUNTED}
     */
    String ACTION_MEDIA_MOUNTED = "android.intent.action.MEDIA_MOUNTED";
    /**
     * Constant connected to {@link Intent#ACTION_MEDIA_NOFS}
     */
    String ACTION_MEDIA_NOFS = "android.intent.action.MEDIA_NOFS";
    /**
     * Constant connected to {@link Intent#ACTION_MEDIA_REMOVED}
     */
    String ACTION_MEDIA_REMOVED = "android.intent.action.MEDIA_REMOVED";
    /**
     * Constant connected to {@link Intent#ACTION_MEDIA_SCANNER_FINISHED}
     */
    String ACTION_MEDIA_SCANNER_FINISHED = "android.intent.action.MEDIA_SCANNER_FINISHED";
    /**
     * Constant connected to {@link Intent#ACTION_MEDIA_SCANNER_SCAN_FILE}
     */
    String ACTION_MEDIA_SCANNER_SCAN_FILE = "android.intent.action.MEDIA_SCANNER_SCAN_FILE";
    /**
     * Constant connected to {@link Intent#ACTION_MEDIA_SCANNER_STARTED}
     */
    String ACTION_MEDIA_SCANNER_STARTED = "android.intent.action.MEDIA_SCANNER_STARTED";
    /**
     * Constant connected to {@link Intent#ACTION_MEDIA_SHARED}
     */
    String ACTION_MEDIA_SHARED = "android.intent.action.MEDIA_SHARED";
    /**
     * Constant connected to {@link Intent#ACTION_MEDIA_UNMOUNTABLE}
     */
    String ACTION_MEDIA_UNMOUNTABLE = "android.intent.action.MEDIA_UNMOUNTABLE";
    /**
     * Constant connected to {@link Intent#ACTION_MEDIA_UNMOUNTED}
     */
    String ACTION_MEDIA_UNMOUNTED = "android.intent.action.MEDIA_UNMOUNTED";
    /**
     * Constant connected to {@link Intent#ACTION_MY_PACKAGE_REPLACED}
     */
    String ACTION_MY_PACKAGE_REPLACED = "android.intent.action.MY_PACKAGE_REPLACED";
    /**
     * Constant connected to {@link Intent#ACTION_MY_PACKAGE_SUSPENDED}
     */
    @RequiresApi(api = Build.VERSION_CODES.P)
    String ACTION_MY_PACKAGE_SUSPENDED = "android.intent.action.MY_PACKAGE_SUSPENDED";
    /**
     * Constant connected to {@link Intent#ACTION_MY_PACKAGE_UNSUSPENDED}
     */
    @RequiresApi(api = Build.VERSION_CODES.P)
    String ACTION_MY_PACKAGE_UNSUSPENDED = "android.intent.action.MY_PACKAGE_UNSUSPENDED";
    /**
     * Constant connected to {@link Intent#ACTION_NEW_OUTGOING_CALL}
     */
    String ACTION_NEW_OUTGOING_CALL = "android.intent.action.NEW_OUTGOING_CALL";
    /**
     * Constant connected to {@link Intent#ACTION_OPEN_DOCUMENT}
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    String ACTION_OPEN_DOCUMENT = "android.intent.action.OPEN_DOCUMENT";
    /**
     * Constant connected to {@link Intent#ACTION_OPEN_DOCUMENT_TREE}
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    String ACTION_OPEN_DOCUMENT_TREE = "android.intent.action.OPEN_DOCUMENT_TREE";
    /**
     * Constant connected to {@link Intent#ACTION_PACKAGES_SUSPENDED}
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    String ACTION_PACKAGES_SUSPENDED = "android.intent.action.PACKAGES_SUSPENDED";
    /**
     * Constant connected to {@link Intent#ACTION_PACKAGES_UNSUSPENDED}
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    String ACTION_PACKAGES_UNSUSPENDED = "android.intent.action.PACKAGES_UNSUSPENDED";
    /**
     * Constant connected to {@link Intent#ACTION_PACKAGE_ADDED}
     */
    String ACTION_PACKAGE_ADDED = "android.intent.action.PACKAGE_ADDED";
    /**
     * Constant connected to {@link Intent#ACTION_PACKAGE_CHANGED}
     */
    String ACTION_PACKAGE_CHANGED = "android.intent.action.PACKAGE_CHANGED";
    /**
     * Constant connected to {@link Intent#ACTION_PACKAGE_DATA_CLEARED}
     */
    String ACTION_PACKAGE_DATA_CLEARED = "android.intent.action.PACKAGE_DATA_CLEARED";
    /**
     * Constant connected to {@link Intent#ACTION_PACKAGE_FIRST_LAUNCH}
     */
    String ACTION_PACKAGE_FIRST_LAUNCH = "android.intent.action.PACKAGE_FIRST_LAUNCH";
    /**
     * Constant connected to {@link Intent#ACTION_PACKAGE_FULLY_REMOVED}
     */
    String ACTION_PACKAGE_FULLY_REMOVED = "android.intent.action.PACKAGE_FULLY_REMOVED";
    /**
     * Constant connected to {@link Intent#ACTION_PACKAGE_INSTALL}
     */
    @Deprecated
    String ACTION_PACKAGE_INSTALL = "android.intent.action.ACTION_PACKAGE_INSTALL";
    /**
     * Constant connected to {@link Intent#ACTION_PACKAGE_NEEDS_VERIFICATION}
     */
    String ACTION_PACKAGE_NEEDS_VERIFICATION = "android.intent.action.PACKAGE_NEEDS_VERIFICATION";
    /**
     * Constant connected to {@link Intent#ACTION_PACKAGE_REMOVED}
     */
    String ACTION_PACKAGE_REMOVED = "android.intent.action.PACKAGE_REMOVED";
    /**
     * Constant connected to {@link Intent#ACTION_PACKAGE_REPLACED}
     */
    String ACTION_PACKAGE_REPLACED = "android.intent.action.PACKAGE_REPLACED";
    /**
     * Constant connected to {@link Intent#ACTION_PACKAGE_RESTARTED}
     */
    String ACTION_PACKAGE_RESTARTED = "android.intent.action.PACKAGE_RESTARTED";
    /**
     * Constant connected to {@link Intent#ACTION_PACKAGE_VERIFIED}
     */
    String ACTION_PACKAGE_VERIFIED = "android.intent.action.PACKAGE_VERIFIED";
    /**
     * Constant connected to {@link Intent#ACTION_PASTE}
     */
    String ACTION_PASTE = "android.intent.action.PASTE";
    /**
     * Constant connected to {@link Intent#ACTION_PICK}
     */
    String ACTION_PICK = "android.intent.action.PICK";
    /**
     * Constant connected to {@link Intent#ACTION_PICK_ACTIVITY}
     */
    String ACTION_PICK_ACTIVITY = "android.intent.action.PICK_ACTIVITY";
    /**
     * Constant connected to {@link Intent#ACTION_POWER_CONNECTED}
     */
    String ACTION_POWER_CONNECTED = "android.intent.action.ACTION_POWER_CONNECTED";
    /**
     * Constant connected to {@link Intent#ACTION_POWER_DISCONNECTED}
     */
    String ACTION_POWER_DISCONNECTED = "android.intent.action.ACTION_POWER_DISCONNECTED";
    /**
     * Constant connected to {@link Intent#ACTION_POWER_USAGE_SUMMARY}
     */
    String ACTION_POWER_USAGE_SUMMARY = "android.intent.action.POWER_USAGE_SUMMARY";
    /**
     * Constant connected to {@link Intent#ACTION_PROCESS_TEXT}
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    String ACTION_PROCESS_TEXT = "android.intent.action.PROCESS_TEXT";
    /**
     * Constant connected to {@link Intent#ACTION_PROVIDER_CHANGED}
     */
    String ACTION_PROVIDER_CHANGED = "android.intent.action.PROVIDER_CHANGED";
    /**
     * Constant connected to {@link Intent#ACTION_QUICK_CLOCK}
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    String ACTION_QUICK_CLOCK = "android.intent.action.QUICK_CLOCK";
    /**
     * Constant connected to {@link Intent#ACTION_QUICK_VIEW}
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    String ACTION_QUICK_VIEW = "android.intent.action.QUICK_VIEW";
    /**
     * Constant connected to {@link Intent#ACTION_REBOOT}
     */
    String ACTION_REBOOT = "android.intent.action.REBOOT";
    /**
     * Constant connected to {@link Intent#ACTION_RUN}
     */
    String ACTION_RUN = "android.intent.action.RUN";
    /**
     * Constant connected to {@link Intent#ACTION_SCREEN_OFF}
     */
    String ACTION_SCREEN_OFF = "android.intent.action.SCREEN_OFF";
    /**
     * Constant connected to {@link Intent#ACTION_SCREEN_ON}
     */
    String ACTION_SCREEN_ON = "android.intent.action.SCREEN_ON";
    /**
     * Constant connected to {@link Intent#ACTION_SEARCH}
     */
    String ACTION_SEARCH = "android.intent.action.SEARCH";
    /**
     * Constant connected to {@link Intent#ACTION_SEARCH_LONG_PRESS}
     */
    String ACTION_SEARCH_LONG_PRESS = "android.intent.action.SEARCH_LONG_PRESS";
    /**
     * Constant connected to {@link Intent#ACTION_SEND}
     */
    String ACTION_SEND = "android.intent.action.SEND";
    /**
     * Constant connected to {@link Intent#ACTION_SENDTO}
     */
    String ACTION_SENDTO = "android.intent.action.SENDTO";
    /**
     * Constant connected to {@link Intent#ACTION_SEND_MULTIPLE}
     */
    String ACTION_SEND_MULTIPLE = "android.intent.action.SEND_MULTIPLE";
    /**
     * Constant connected to {@link Intent#ACTION_SET_WALLPAPER}
     */
    String ACTION_SET_WALLPAPER = "android.intent.action.SET_WALLPAPER";
    /**
     * Constant connected to {@link Intent#ACTION_SHOW_APP_INFO}
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    String ACTION_SHOW_APP_INFO = "android.intent.action.SHOW_APP_INFO";
    /**
     * Constant connected to {@link Intent#ACTION_SHUTDOWN}
     */
    String ACTION_SHUTDOWN = "android.intent.action.ACTION_SHUTDOWN";
    /**
     * Constant connected to {@link Intent#ACTION_SYNC}
     */
    String ACTION_SYNC = "android.intent.action.SYNC";
    /**
     * Constant connected to {@link Intent#ACTION_SYSTEM_TUTORIAL}
     */
    String ACTION_SYSTEM_TUTORIAL = "android.intent.action.SYSTEM_TUTORIAL";
    /**
     * Constant connected to {@link Intent#ACTION_TIMEZONE_CHANGED}
     */
    String ACTION_TIMEZONE_CHANGED = "android.intent.action.TIMEZONE_CHANGED";
    /**
     * Constant connected to {@link Intent#ACTION_TIME_CHANGED}
     */
    String ACTION_TIME_CHANGED = "android.intent.action.TIME_SET";
    /**
     * Constant connected to {@link Intent#ACTION_TIME_TICK}
     */
    String ACTION_TIME_TICK = "android.intent.action.TIME_TICK";
    /**
     * Constant connected to {@link Intent#ACTION_UID_REMOVED}
     */
    String ACTION_UID_REMOVED = "android.intent.action.UID_REMOVED";
    /**
     * Constant connected to {@link Intent#ACTION_UMS_CONNECTED}
     */
    @Deprecated
    String ACTION_UMS_CONNECTED = "android.intent.action.UMS_CONNECTED";
    /**
     * Constant connected to {@link Intent#ACTION_UMS_DISCONNECTED}
     */
    @Deprecated
    String ACTION_UMS_DISCONNECTED = "android.intent.action.UMS_DISCONNECTED";
    /**
     * Constant connected to {@link Intent#ACTION_UNINSTALL_PACKAGE}
     */
    String ACTION_UNINSTALL_PACKAGE = "android.intent.action.UNINSTALL_PACKAGE";
    /**
     * Constant connected to {@link Intent#ACTION_USER_BACKGROUND}
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    String ACTION_USER_BACKGROUND = "android.intent.action.USER_BACKGROUND";
    /**
     * Constant connected to {@link Intent#ACTION_USER_FOREGROUND}
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    String ACTION_USER_FOREGROUND = "android.intent.action.USER_FOREGROUND";
    /**
     * Constant connected to {@link Intent#ACTION_USER_INITIALIZE}
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    String ACTION_USER_INITIALIZE = "android.intent.action.USER_INITIALIZE";
    /**
     * Constant connected to {@link Intent#ACTION_USER_PRESENT}
     */
    String ACTION_USER_PRESENT = "android.intent.action.USER_PRESENT";
    /**
     * Constant connected to {@link Intent#ACTION_USER_UNLOCKED}
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    String ACTION_USER_UNLOCKED = "android.intent.action.USER_UNLOCKED";
    /**
     * Constant connected to {@link Intent#ACTION_VIEW}
     */
    String ACTION_VIEW = "android.intent.action.VIEW";
    /**
     * Constant connected to {@link Intent#ACTION_VOICE_COMMAND}
     */
    String ACTION_VOICE_COMMAND = "android.intent.action.VOICE_COMMAND";
    /**
     * Constant connected to {@link Intent#ACTION_WALLPAPER_CHANGED}
     */
    @Deprecated
    String ACTION_WALLPAPER_CHANGED = "android.intent.action.WALLPAPER_CHANGED";
    /**
     * Constant connected to {@link Intent#ACTION_WEB_SEARCH}
     */
    String ACTION_WEB_SEARCH = "android.intent.action.WEB_SEARCH";

}
