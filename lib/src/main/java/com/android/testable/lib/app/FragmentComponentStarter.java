package com.android.testable.lib.app;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.android.testable.lib.os.TABundle;

public class FragmentComponentStarter extends ComponentStarter<Fragment> {

    public FragmentComponentStarter(Fragment fragment) {
        super(fragment);
    }

    @Nullable
    @Override
    protected Activity getActivity() {
        Fragment fragment = reference.get();
        if (fragment != null) {
            return fragment.getActivity();
        }
        return null;
    }

    @Override
    public void startActivityForResult(@NonNull TAIntent taIntent, int requestCode) {
        Fragment fragment = getFragment();
        if (fragment != null) {
            fragment.startActivityForResult(taIntent.intent, requestCode);
        }
    }

    @Override
    public void startActivityForResult(@NonNull TAIntent taIntent, int requestCode, @NonNull TABundle options) {
        Fragment fragment = getFragment();
        if (fragment != null) {
            fragment.startActivityForResult(taIntent.intent, requestCode, options.bundle);
        }
    }

    @Override
    public void startActivityForResultCompat(@NonNull TAIntent taIntent, int requestCode, @NonNull TABundle options) {
        startActivityForResult(taIntent, requestCode, options);
    }

    @Nullable
    private Fragment getFragment() {
        Fragment fragment = reference.get();
        if (fragment != null) {
            return fragment;
        }
        return null;
    }
}
