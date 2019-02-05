package com.android.testable.lib.presentable;

import androidx.annotation.NonNull;
import com.android.testable.lib.app.TAIntent;

public interface Intentable {

    void onIntentReady(@NonNull TAIntent taIntent);
}
