package com.android.testable.lib.app;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.android.testable.lib.ComponentGenerator;
import com.android.testable.lib.os.TABundle;
import com.android.testable.lib.util.NonNullRunnable;

public class FragmentComponentStarter extends ComponentStarter<Fragment> {

    public FragmentComponentStarter(Fragment fragment, ComponentGenerator componentGenerator) {
        super(fragment, componentGenerator);
    }

    @Nullable
    @Override
    protected Activity getActivity() {
        Fragment fragment = reference.get();
        if (fragment != null) {
            return (Activity) fragment.getContext();
        }
        return null;
    }

    @Override
    public void startActivityForResult(@NonNull final TAIntent taIntent, final int requestCode) {
        NonNullRunnable.Executor.execute(getFragment(), fragment -> fragment.startActivityForResult(taIntent.intent, requestCode));
    }

    @Override
    public void startActivityForResult(@NonNull final TAIntent taIntent, final int requestCode, @NonNull final TABundle options) {
        NonNullRunnable.Executor.execute(getFragment(), fragment -> fragment.startActivityForResult(taIntent.intent, requestCode, options.bundle));
    }

    @Override
    public void startActivityForResultCompat(@NonNull TAIntent taIntent, int requestCode, @NonNull TABundle options) {
        startActivityForResult(taIntent, requestCode, options);
    }

    @Override
    public void requestPermissions(@NonNull final String[] permissions, final int requestCode) {
        NonNullRunnable.Executor.execute(getFragment(), fragment -> requestPermissions(fragment, permissions, requestCode));
    }

    @Nullable
    private Fragment getFragment() {
        Fragment fragment = reference.get();
        if (fragment != null) {
            return fragment;
        }
        return null;
    }

    void requestPermissions(@NonNull Fragment fragment, @NonNull String[] permissions, int requestCode) {
        fragment.requestPermissions(permissions, requestCode);
    }

    @NonNull
    public static FragmentComponentStarter create(@NonNull Fragment fragment) {
        return new FragmentComponentStarter(fragment, new ComponentGenerator());
    }
}
