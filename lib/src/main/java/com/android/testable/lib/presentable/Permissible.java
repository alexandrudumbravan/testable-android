package com.android.testable.lib.presentable;

import androidx.annotation.NonNull;

public interface Permissible {

    void onPermissionGranted(int requestCode, @NonNull String[] permissions,@NonNull int[] grantResults);
}
