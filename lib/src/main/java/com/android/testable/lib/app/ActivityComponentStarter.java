package com.android.testable.lib.app;

import android.app.Activity;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import com.android.testable.lib.ComponentGenerator;
import com.android.testable.lib.os.TABundle;
import com.android.testable.lib.util.NonNullRunnable;

public class ActivityComponentStarter extends ComponentStarter<Activity> {

    public ActivityComponentStarter(Activity activity, ComponentGenerator componentGenerator) {
        super(activity, componentGenerator);
    }

    @Nullable
    @Override
    protected Activity getActivity() {
        return reference.get();
    }

    @Override
    public void startActivityForResult(@NonNull final TAIntent taIntent, final int requestCode) {
        NonNullRunnable.Executor.execute(getActivity(), activity -> activity.startActivityForResult(taIntent.intent, requestCode));
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void startActivityForResult(@NonNull final TAIntent taIntent, final int requestCode, @NonNull final TABundle options) {
        NonNullRunnable.Executor.execute(getActivity(), activity -> activity.startActivityForResult(taIntent.intent, requestCode, options.bundle));
    }

    @Override
    public void startActivityForResultCompat(@NonNull final TAIntent taIntent, final int requestCode, @NonNull final TABundle options) {
        NonNullRunnable.Executor.execute(getActivity(), activity -> ActivityCompat.startActivityForResult(activity, taIntent.intent, requestCode, options.bundle));
    }

    @Override
    public void requestPermissions(@NonNull final String[] permissions, final int requestCode) {
        NonNullRunnable.Executor.execute(getActivity(), activity -> ActivityCompat.requestPermissions(activity, permissions, requestCode));
    }

    public static ActivityComponentStarter create(Activity activity) {
        return new ActivityComponentStarter(activity, new ComponentGenerator());
    }
}
