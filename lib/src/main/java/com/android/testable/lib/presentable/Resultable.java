package com.android.testable.lib.presentable;

import androidx.annotation.NonNull;
import com.android.testable.lib.app.TAIntent;

public interface Resultable {

    void onActivityResult(int requestCode, int resultCode, @NonNull TAIntent data);
}
