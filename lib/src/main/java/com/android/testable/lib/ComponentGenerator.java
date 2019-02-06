package com.android.testable.lib;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.testable.lib.app.TAIntent;
import com.android.testable.lib.app.TAUri;
import com.android.testable.lib.os.TABundle;

public class ComponentGenerator {

    @NonNull
    public IntentFilter createIntentFilter(String action) {
        return new IntentFilter(action);
    }

    public int getBuild() {
        return Build.VERSION.SDK_INT;
    }

    @NonNull
    public TAIntent createIntent() {
        return new TAIntent();
    }

    @NonNull
    public TAIntent createIntent(@NonNull TAIntent taIntent) {
        return new TAIntent(taIntent);
    }

    @NonNull
    public TAIntent createIntent(@NonNull String action) {
        return new TAIntent(action);
    }

    @NonNull
    public TAIntent createIntent(@NonNull String action, @NonNull TAUri taUri) {
        return new TAIntent(action, taUri);
    }

    @NonNull
    public TAIntent createIntent(@NonNull Activity activity, @NonNull Class<?> activityClass) {
        return new TAIntent(activity, activityClass);
    }

    @NonNull
    public TAIntent createIntent(@NonNull Activity activity, @NonNull String action, @NonNull TAUri taUri,
                                 @NonNull Class<?> activityClass) {
        return new TAIntent(action, taUri, activity, activityClass);

    }

    @NonNull
    public TABundle createExtras() {
        return new TABundle();
    }

    @NonNull
    public static ComponentGenerator create() {
        return new ComponentGenerator();
    }
}
