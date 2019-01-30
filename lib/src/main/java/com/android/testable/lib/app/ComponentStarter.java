package com.android.testable.lib.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.android.testable.lib.os.TABundle;

import java.lang.ref.WeakReference;

public abstract class ComponentStarter<T> {

    public static final int ACTIVITY_RESULT_OK = -1;
    public static final int ACTIVITY_RESULT_CANCELLED = 0;
    public static final int ACTIVITY_RESULT_FIRST_USER = 1;

    @NonNull
    WeakReference<T> reference;

    ComponentStarter(T type) {
        this.reference = new WeakReference<>(type);
    }

    @Nullable
    protected abstract Activity getActivity();

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

    @Nullable
    public TAIntent createIntent(@NonNull Class<?> activityClass) {
        Activity activity = getActivity();
        if (activity != null) {
            return new TAIntent(activity, activityClass);
        }
        return null;
    }

    @Nullable
    public TAIntent createIntent(@NonNull String action, @NonNull TAUri taUri, @NonNull Class<?> activityClass) {
        Activity activity = getActivity();
        if (activity != null) {
            return new TAIntent(action, taUri, activity, activityClass);
        }
        return null;
    }

    public void startService(@NonNull TAIntent taIntent) {
        Activity activity = getActivity();
        if (activity != null) {
            activity.startService(taIntent.intent);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void startServiceForeground(@NonNull TAIntent taIntent) {
        Activity activity = getActivity();
        if (activity != null) {
            activity.startForegroundService(taIntent.intent);
        }
    }

    public void startServiceForegroundCompat(@NonNull TAIntent taIntent) {
        Activity activity = getActivity();
        if (activity != null) {
            ContextCompat.startForegroundService(activity, taIntent.intent);
        }
    }

    public void startActivity(@NonNull TAIntent taIntent) {
        Activity activity = getActivity();
        if (activity != null) {
            activity.startActivity(taIntent.intent);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void startActivity(@NonNull TAIntent taIntent, @NonNull TABundle options) {
        Activity activity = getActivity();
        if (activity != null) {
            activity.startActivity(taIntent.intent, options.bundle);
        }
    }

    public void startActivityCompat(@NonNull TAIntent taIntent, @NonNull TABundle options) {
        Activity activity = getActivity();
        if (activity != null) {
            ActivityCompat.startActivity(activity, taIntent.intent, options.bundle);
        }
    }

    public void startActivities(@NonNull TAIntent[] taIntents) {
        Activity activity = getActivity();
        if (activity != null) {
            Intent[] intents = new Intent[taIntents.length];
            for (int i = 0; i < taIntents.length; i++) {
                intents[i] = taIntents[i].intent;
            }
            activity.startActivities(intents);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void startActivities(@NonNull TAIntent[] taIntents, @NonNull TABundle options) {
        Activity activity = getActivity();
        if (activity != null) {
            Intent[] intents = new Intent[taIntents.length];
            for (int i = 0; i < taIntents.length; i++) {
                intents[i] = taIntents[i].intent;
            }
            activity.startActivities(intents, options.bundle);
        }
    }

    public void startActivitiesCompat(@NonNull TAIntent[] taIntents, @NonNull TABundle options) {
        Activity activity = getActivity();
        if (activity != null) {
            Intent[] intents = new Intent[taIntents.length];
            for (int i = 0; i < taIntents.length; i++) {
                intents[i] = taIntents[i].intent;
            }
            ActivityCompat.startActivities(activity, intents, options.bundle);
        }
    }

    public abstract void startActivityForResult(@NonNull TAIntent taIntent, int requestCode);

    public abstract void startActivityForResult(@NonNull TAIntent taIntent, int requestCode, @NonNull TABundle options);

    public abstract void startActivityForResultCompat(@NonNull TAIntent taIntent, int requestCode, @NonNull TABundle options);

}
