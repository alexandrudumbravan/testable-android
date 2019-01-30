package com.android.testable.lib.app;

import android.app.Activity;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import com.android.testable.lib.os.TABundle;

public class ActivityComponentStarter extends ComponentStarter<Activity> {

    public ActivityComponentStarter(Activity type) {
        super(type);
    }

    @Nullable
    @Override
    protected Activity getActivity() {
        return reference.get();
    }

    @Override
    public void startActivityForResult(@NonNull TAIntent taIntent, int requestCode) {
        Activity activity = getActivity();
        if (activity != null) {
            activity.startActivityForResult(taIntent.intent, requestCode);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void startActivityForResult(@NonNull TAIntent taIntent, int requestCode, @NonNull TABundle options) {
        Activity activity = getActivity();
        if (activity != null) {
            activity.startActivityForResult(taIntent.intent, requestCode, options.bundle);
        }
    }

    @Override
    public void startActivityForResultCompat(@NonNull TAIntent taIntent, int requestCode, @NonNull TABundle options) {
        Activity activity = getActivity();
        if (activity != null) {
            ActivityCompat.startActivityForResult(activity, taIntent.intent, requestCode, options.bundle);
        }
    }
}
