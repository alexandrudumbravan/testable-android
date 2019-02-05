package com.android.testable.lib.presentable;

import androidx.annotation.NonNull;
import com.android.testable.lib.os.TABundle;

public interface StateSavable {

    void onSaveInstanceState(@NonNull TABundle outState);

    void onRestoreInstanceState(@NonNull TABundle savedInstanceState);
}
