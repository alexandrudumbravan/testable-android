package com.android.testable.lib.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.android.testable.lib.ComponentGenerator;

public class ComponentStarter {

    @NonNull
    private Activity activity;
    @NonNull
    private ComponentGenerator componentGenerator;

    protected ComponentStarter(@NonNull Fragment fragment, @NonNull ComponentGenerator componentGenerator) {
        this(fragment.getActivity(), componentGenerator);
    }

    protected ComponentStarter(@NonNull Activity activity, @NonNull ComponentGenerator componentGenerator) {
        this.activity = activity;
        this.componentGenerator = componentGenerator;
    }

    public void startService(@NonNull StarterConfig starterConfig) {
        activity.startService(createServiceIntent(starterConfig));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void startServiceForeground(@NonNull StarterConfig starterConfig) {
        activity.startForegroundService(createServiceIntent(starterConfig));
    }

    public void startServiceForegroundCompat(@NonNull StarterConfig starterConfig) {
        ContextCompat.startForegroundService(activity, createServiceIntent(starterConfig));
    }

    @NonNull
    private Intent createServiceIntent(@NonNull StarterConfig starterConfig) {
        Intent intent = componentGenerator.createIntent(activity, starterConfig.getComponentClass());
        if (starterConfig.getExtras() != null) {
            intent.putExtras(starterConfig.getExtras().bundle);
        }
        intent.setAction(starterConfig.getAction());
        return intent;
    }


    public static ComponentStarter create(Fragment fragment) {
        return new ComponentStarter(fragment, ComponentGenerator.create());
    }

    public static ComponentStarter create(Activity activity) {
        return new ComponentStarter(activity, ComponentGenerator.create());
    }
}
