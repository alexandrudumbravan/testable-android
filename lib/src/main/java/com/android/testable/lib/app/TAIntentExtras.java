package com.android.testable.lib.app;

import android.content.Intent;
import android.os.Build;
import androidx.annotation.RequiresApi;

public interface TAIntentExtras {

    /**
     * Constant connected to {@link Intent#EXTRA_ALARM_COUNT}
     */
    String EXTRA_ALARM_COUNT = "android.intent.extra.ALARM_COUNT";
    /**
     * Constant connected to {@link Intent#EXTRA_ALLOW_MULTIPLE}
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    String EXTRA_ALLOW_MULTIPLE = "android.intent.extra.ALLOW_MULTIPLE";
    /**
     * Constant connected to {@link Intent#EXTRA_ALLOW_REPLACE}
     */
    String EXTRA_ALLOW_REPLACE = "android.intent.extra.ALLOW_REPLACE";
    /**
     * Constant connected to {@link Intent#EXTRA_ALTERNATE_INTENTS}
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    String EXTRA_ALTERNATE_INTENTS = "android.intent.extra.ALTERNATE_INTENTS";
    /**
     * Constant connected to {@link Intent#EXTRA_ASSIST_CONTEXT}
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    String EXTRA_ASSIST_CONTEXT = "android.intent.extra.ASSIST_CONTEXT";
    /**
     * Constant connected to {@link Intent#EXTRA_ASSIST_INPUT_DEVICE_ID}
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    String EXTRA_ASSIST_INPUT_DEVICE_ID = "android.intent.extra.ASSIST_INPUT_DEVICE_ID";
    /**
     * Constant connected to {@link Intent#EXTRA_ASSIST_INPUT_HINT_KEYBOARD}
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    String EXTRA_ASSIST_INPUT_HINT_KEYBOARD = "android.intent.extra.ASSIST_INPUT_HINT_KEYBOARD";
    /**
     * Constant connected to {@link Intent#EXTRA_ASSIST_PACKAGE}
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    String EXTRA_ASSIST_PACKAGE = "android.intent.extra.ASSIST_PACKAGE";
    /**
     * Constant connected to {@link Intent#EXTRA_ASSIST_UID}
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    String EXTRA_ASSIST_UID = "android.intent.extra.ASSIST_UID";
    /**
     * Constant connected to {@link Intent#EXTRA_BCC}
     */
    String EXTRA_BCC = "android.intent.extra.BCC";
    /**
     * Constant connected to {@link Intent#EXTRA_BUG_REPORT}
     */
    String EXTRA_BUG_REPORT = "android.intent.extra.BUG_REPORT";
    /**
     * Constant connected to {@link Intent#EXTRA_CC}
     */
    String EXTRA_CC = "android.intent.extra.CC";
    /**
     * Constant connected to {@link Intent#EXTRA_CHANGED_COMPONENT_NAME}
     */
    @Deprecated
    String EXTRA_CHANGED_COMPONENT_NAME = "android.intent.extra.changed_component_name";
    /**
     * Constant connected to {@link Intent#EXTRA_CHANGED_COMPONENT_NAME_LIST}
     */
    String EXTRA_CHANGED_COMPONENT_NAME_LIST = "android.intent.extra.changed_component_name_list";
    /**
     * Constant connected to {@link Intent#EXTRA_CHANGED_PACKAGE_LIST}
     */
    String EXTRA_CHANGED_PACKAGE_LIST = "android.intent.extra.changed_package_list";
    /**
     * Constant connected to {@link Intent#EXTRA_CHANGED_UID_LIST}
     */
    String EXTRA_CHANGED_UID_LIST = "android.intent.extra.changed_uid_list";
    /**
     * Constant connected to {@link Intent#EXTRA_CHOOSER_REFINEMENT_INTENT_SENDER}
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    String EXTRA_CHOOSER_REFINEMENT_INTENT_SENDER = "android.intent.extra.CHOOSER_REFINEMENT_INTENT_SENDER";
    /**
     * Constant connected to {@link Intent#EXTRA_CHOOSER_TARGETS}
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    String EXTRA_CHOOSER_TARGETS = "android.intent.extra.CHOOSER_TARGETS";
    /**
     * Constant connected to {@link Intent#EXTRA_CHOSEN_COMPONENT}
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    String EXTRA_CHOSEN_COMPONENT = "android.intent.extra.CHOSEN_COMPONENT";
    /**
     * Constant connected to {@link Intent#EXTRA_CHOSEN_COMPONENT_INTENT_SENDER}
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    String EXTRA_CHOSEN_COMPONENT_INTENT_SENDER = "android.intent.extra.CHOSEN_COMPONENT_INTENT_SENDER";
    /**
     * Constant connected to {@link Intent#EXTRA_COMPONENT_NAME}
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    String EXTRA_COMPONENT_NAME = "android.intent.extra.COMPONENT_NAME";
    /**
     * Constant connected to {@link Intent#EXTRA_CONTENT_ANNOTATIONS}
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    String EXTRA_CONTENT_ANNOTATIONS = "android.intent.extra.CONTENT_ANNOTATIONS";
    /**
     * Constant connected to {@link Intent#EXTRA_DATA_REMOVED}
     */
    String EXTRA_DATA_REMOVED = "android.intent.extra.DATA_REMOVED";
    /**
     * Constant connected to {@link Intent#EXTRA_DOCK_STATE}
     */
    String EXTRA_DOCK_STATE = "android.intent.extra.DOCK_STATE";
    /**
     * Constant connected to {@link Intent#EXTRA_DOCK_STATE_CAR}
     */
    int EXTRA_DOCK_STATE_CAR = 2;
    /**
     * Constant connected to {@link Intent#EXTRA_DOCK_STATE_DESK}
     */
    int EXTRA_DOCK_STATE_DESK = 1;
    /**
     * Constant connected to {@link Intent#EXTRA_DOCK_STATE_HE_DESK}
     */
    int EXTRA_DOCK_STATE_HE_DESK = 4;
    /**
     * Constant connected to {@link Intent#EXTRA_DOCK_STATE_LE_DESK}
     */
    int EXTRA_DOCK_STATE_LE_DESK = 3;
    /**
     * Constant connected to {@link Intent#EXTRA_DOCK_STATE_UNDOCKED}
     */
    int EXTRA_DOCK_STATE_UNDOCKED = 0;
    /**
     * Constant connected to {@link Intent#EXTRA_DONT_KILL_APP}
     */
    String EXTRA_DONT_KILL_APP = "android.intent.extra.DONT_KILL_APP";
    /**
     * Constant connected to {@link Intent#EXTRA_EMAIL}
     */
    String EXTRA_EMAIL = "android.intent.extra.EMAIL";
    /**
     * Constant connected to {@link Intent#EXTRA_EXCLUDE_COMPONENTS}
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    String EXTRA_EXCLUDE_COMPONENTS = "android.intent.extra.EXCLUDE_COMPONENTS";
    /**
     * Constant connected to {@link Intent#EXTRA_FROM_STORAGE}
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    String EXTRA_FROM_STORAGE = "android.intent.extra.FROM_STORAGE";
    /**
     * Constant connected to {@link Intent#EXTRA_HTML_TEXT}
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
    /**
     * Constant connected to {@link Intent#EXTRA_INDEX}
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    String EXTRA_INDEX = "android.intent.extra.INDEX";
    /**
     * Constant connected to {@link Intent#EXTRA_INITIAL_INTENTS}
     */
    String EXTRA_INITIAL_INTENTS = "android.intent.extra.INITIAL_INTENTS";
    /**
     * Constant connected to {@link Intent#EXTRA_INSTALLER_PACKAGE_NAME}
     */
    String EXTRA_INSTALLER_PACKAGE_NAME = "android.intent.extra.INSTALLER_PACKAGE_NAME";
    /**
     * Constant connected to {@link Intent#EXTRA_INTENT}
     */
    String EXTRA_INTENT = "android.intent.extra.INTENT";
    /**
     * Constant connected to {@link Intent#EXTRA_KEY_EVENT}
     */
    String EXTRA_KEY_EVENT = "android.intent.extra.KEY_EVENT";
    /**
     * Constant connected to {@link Intent#EXTRA_LOCAL_ONLY}
     */
    String EXTRA_LOCAL_ONLY = "android.intent.extra.LOCAL_ONLY";
    /**
     * Constant connected to {@link Intent#EXTRA_MIME_TYPES}
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    String EXTRA_MIME_TYPES = "android.intent.extra.MIME_TYPES";
    /**
     * Constant connected to {@link Intent#EXTRA_NOT_UNKNOWN_SOURCE}
     */
    String EXTRA_NOT_UNKNOWN_SOURCE = "android.intent.extra.NOT_UNKNOWN_SOURCE";
    /**
     * Constant connected to {@link Intent#EXTRA_ORIGINATING_URI}
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    String EXTRA_ORIGINATING_URI = "android.intent.extra.ORIGINATING_URI";
    /**
     * Constant connected to {@link Intent#EXTRA_PACKAGE_NAME}
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    String EXTRA_PACKAGE_NAME = "android.intent.extra.PACKAGE_NAME";
    /**
     * Constant connected to {@link Intent#EXTRA_PHONE_NUMBER}
     */
    String EXTRA_PHONE_NUMBER = "android.intent.extra.PHONE_NUMBER";
    /**
     * Constant connected to {@link Intent#EXTRA_PROCESS_TEXT}
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    String EXTRA_PROCESS_TEXT = "android.intent.extra.PROCESS_TEXT";
    /**
     * Constant connected to {@link Intent#EXTRA_PROCESS_TEXT_READONLY}
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    String EXTRA_PROCESS_TEXT_READONLY = "android.intent.extra.PROCESS_TEXT_READONLY";
    /**
     * Constant connected to {@link Intent#EXTRA_QUICK_VIEW_FEATURES}
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    String EXTRA_QUICK_VIEW_FEATURES = "android.intent.extra.QUICK_VIEW_FEATURES";
    /**
     * Constant connected to {@link Intent#EXTRA_QUIET_MODE}
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    String EXTRA_QUIET_MODE = "android.intent.extra.QUIET_MODE";
    /**
     * Constant connected to {@link Intent#EXTRA_REFERRER}
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    String EXTRA_REFERRER = "android.intent.extra.REFERRER";
    /**
     * Constant connected to {@link Intent#EXTRA_REFERRER_NAME}
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    String EXTRA_REFERRER_NAME = "android.intent.extra.REFERRER_NAME";
    /**
     * Constant connected to {@link Intent#EXTRA_REMOTE_INTENT_TOKEN}
     */
    String EXTRA_REMOTE_INTENT_TOKEN = "android.intent.extra.remote_intent_token";
    /**
     * Constant connected to {@link Intent#EXTRA_REPLACEMENT_EXTRAS}
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    String EXTRA_REPLACEMENT_EXTRAS = "android.intent.extra.REPLACEMENT_EXTRAS";
    /**
     * Constant connected to {@link Intent#EXTRA_REPLACING}
     */
    String EXTRA_REPLACING = "android.intent.extra.REPLACING";
    /**
     * Constant connected to {@link Intent#EXTRA_RESTRICTIONS_BUNDLE}
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    String EXTRA_RESTRICTIONS_BUNDLE = "android.intent.extra.restrictions_bundle";
    /**
     * Constant connected to {@link Intent#EXTRA_RESTRICTIONS_INTENT}
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    String EXTRA_RESTRICTIONS_INTENT = "android.intent.extra.restrictions_intent";
    /**
     * Constant connected to {@link Intent#EXTRA_RESTRICTIONS_LIST}
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    String EXTRA_RESTRICTIONS_LIST = "android.intent.extra.restrictions_list";
    /**
     * Constant connected to {@link Intent#EXTRA_RESULT_RECEIVER}
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    String EXTRA_RESULT_RECEIVER = "android.intent.extra.RESULT_RECEIVER";
    /**
     * Constant connected to {@link Intent#EXTRA_RETURN_RESULT}
     */
    String EXTRA_RETURN_RESULT = "android.intent.extra.RETURN_RESULT";
    /**
     * Constant connected to {@link Intent#EXTRA_SHORTCUT_ICON}
     */
    @Deprecated
    String EXTRA_SHORTCUT_ICON = "android.intent.extra.ICON";
    /**
     * Constant connected to {@link Intent#EXTRA_SHORTCUT_ICON_RESOURCE}
     */
    @Deprecated
    String EXTRA_SHORTCUT_ICON_RESOURCE = "android.intent.extra.ICON_RESOURCE";
    /**
     * Constant connected to {@link Intent#EXTRA_SHORTCUT_INTENT}
     */
    @Deprecated
    String EXTRA_SHORTCUT_INTENT = "android.intent.extra.INTENT";
    /**
     * Constant connected to {@link Intent#EXTRA_SHORTCUT_NAME}
     */
    @Deprecated
    String EXTRA_SHORTCUT_NAME = "android.intent.extra.NAME";
    /**
     * Constant connected to {@link Intent#EXTRA_SHUTDOWN_USERSPACE_ONLY}
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    String EXTRA_SHUTDOWN_USERSPACE_ONLY = "android.intent.extra.SHUTDOWN_USERSPACE_ONLY";
    /**
     * Constant connected to {@link Intent#EXTRA_SPLIT_NAME}
     */
    @RequiresApi(api = Build.VERSION_CODES.O_MR1)
    String EXTRA_SPLIT_NAME = "android.intent.extra.SPLIT_NAME";
    /**
     * Constant connected to {@link Intent#EXTRA_STREAM}
     */
    String EXTRA_STREAM = "android.intent.extra.STREAM";
    /**
     * Constant connected to {@link Intent#EXTRA_SUBJECT}
     */
    String EXTRA_SUBJECT = "android.intent.extra.SUBJECT";
    /**
     * Constant connected to {@link Intent#EXTRA_SUSPENDED_PACKAGE_EXTRAS}
     */
    @RequiresApi(api = Build.VERSION_CODES.P)
    String EXTRA_SUSPENDED_PACKAGE_EXTRAS = "android.intent.extra.SUSPENDED_PACKAGE_EXTRAS";
    /**
     * Constant connected to {@link Intent#EXTRA_TEMPLATE}
     */
    String EXTRA_TEMPLATE = "android.intent.extra.TEMPLATE";
    /**
     * Constant connected to {@link Intent#EXTRA_TEXT}
     */
    String EXTRA_TEXT = "android.intent.extra.TEXT";
    /**
     * Constant connected to {@link Intent#EXTRA_TITLE}
     */
    String EXTRA_TITLE = "android.intent.extra.TITLE";
    /**
     * Constant connected to {@link Intent#EXTRA_UID}
     */
    String EXTRA_UID = "android.intent.extra.UID";
    /**
     * Constant connected to {@link Intent#EXTRA_USER}
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    String EXTRA_USER = "android.intent.extra.USER";
    /**
     * Constant connected to {@link Intent#METADATA_DOCK_HOME}
     */
    String METADATA_DOCK_HOME = "android.dock_home";

}
