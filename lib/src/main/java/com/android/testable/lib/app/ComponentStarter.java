package com.android.testable.lib.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.android.testable.lib.os.TABundle;
import com.android.testable.lib.util.NonNullRunnable;

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
    public TABundle createExtras() {
        return new TABundle();
    }

    @Nullable
    public TAIntent createIntent(@NonNull String action, @NonNull TAUri taUri, @NonNull Class<?> activityClass) {
        Activity activity = getActivity();
        if (activity != null) {
            return new TAIntent(action, taUri, activity, activityClass);
        }
        return null;
    }

    public void startService(@NonNull final TAIntent taIntent) {
        NonNullRunnable.Executor.execute(getActivity(), new NonNullRunnable<Activity>() {
            @Override
            public void run(@NonNull Activity activity) {
                activity.startService(taIntent.intent);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void startServiceForeground(@NonNull final TAIntent taIntent) {
        NonNullRunnable.Executor.execute(getActivity(), new NonNullRunnable<Activity>() {
            @Override
            public void run(@NonNull Activity activity) {
                activity.startForegroundService(taIntent.intent);
            }
        });
    }

    public void startServiceForegroundCompat(@NonNull final TAIntent taIntent) {
        NonNullRunnable.Executor.execute(getActivity(), new NonNullRunnable<Activity>() {
            @Override
            public void run(@NonNull Activity activity) {
                ContextCompat.startForegroundService(activity, taIntent.intent);
            }
        });
    }

    public void startActivity(@NonNull final TAIntent taIntent) {
        NonNullRunnable.Executor.execute(getActivity(), new NonNullRunnable<Activity>() {
            @Override
            public void run(@NonNull Activity activity) {
                activity.startActivity(taIntent.intent);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void startActivity(@NonNull final TAIntent taIntent, @NonNull final TABundle options) {
        NonNullRunnable.Executor.execute(getActivity(), new NonNullRunnable<Activity>() {
            @Override
            public void run(@NonNull Activity activity) {
                activity.startActivity(taIntent.intent, options.bundle);
            }
        });
    }

    public void startActivityCompat(@NonNull final TAIntent taIntent, @NonNull final TABundle options) {
        NonNullRunnable.Executor.execute(getActivity(), new NonNullRunnable<Activity>() {
            @Override
            public void run(@NonNull Activity activity) {
                ActivityCompat.startActivity(activity, taIntent.intent, options.bundle);
            }
        });
    }

    public void startActivities(@NonNull final TAIntent[] taIntents) {
        NonNullRunnable.Executor.execute(getActivity(), new NonNullRunnable<Activity>() {
            @Override
            public void run(@NonNull Activity activity) {
                Intent[] intents = new Intent[taIntents.length];
                for (int i = 0; i < taIntents.length; i++) {
                    intents[i] = taIntents[i].intent;
                }
                activity.startActivities(intents);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void startActivities(@NonNull final TAIntent[] taIntents, @NonNull final TABundle options) {
        NonNullRunnable.Executor.execute(getActivity(), new NonNullRunnable<Activity>() {
            @Override
            public void run(@NonNull Activity activity) {
                Intent[] intents = new Intent[taIntents.length];
                for (int i = 0; i < taIntents.length; i++) {
                    intents[i] = taIntents[i].intent;
                }
                activity.startActivities(intents, options.bundle);
            }
        });
    }

    public void startActivitiesCompat(@NonNull final TAIntent[] taIntents, @NonNull final TABundle options) {
        NonNullRunnable.Executor.execute(getActivity(), new NonNullRunnable<Activity>() {
            @Override
            public void run(@NonNull Activity activity) {
                Intent[] intents = new Intent[taIntents.length];
                for (int i = 0; i < taIntents.length; i++) {
                    intents[i] = taIntents[i].intent;
                }
                ActivityCompat.startActivities(activity, intents, options.bundle);
            }
        });
    }

    public void finish() {
        NonNullRunnable.Executor.execute(getActivity(), new NonNullRunnable<Activity>() {
            @Override
            public void run(@NonNull Activity activity) {
                activity.finish();
            }
        });
    }

    public abstract void startActivityForResult(@NonNull TAIntent taIntent, int requestCode);

    public abstract void startActivityForResult(@NonNull TAIntent taIntent, int requestCode, @NonNull TABundle options);

    public abstract void startActivityForResultCompat(@NonNull TAIntent taIntent, int requestCode, @NonNull TABundle options);

    public boolean isGrantedPermission(@NonNull String permission) {
        Activity activity = getActivity();
        if (activity != null) {
            return ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED;
        }
        return false;
    }

    public boolean shouldShowPermissionRationale(@NonNull String permission) {
        Activity activity = getActivity();
        if (activity != null) {
            return ActivityCompat.shouldShowRequestPermissionRationale(activity, permission);
        }
        return false;
    }


    public abstract void requestPermissions(@NonNull String[] permissions, int requestCode);

}
