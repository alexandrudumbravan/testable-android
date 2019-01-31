package com.android.testable.lib.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface NonNullRunnable<T> {

    void run(@NonNull T t);

    class Executor {

        public static  <T> void execute(@Nullable T type, @NonNull NonNullRunnable<T> runnable) {
            if (type != null) {
                runnable.run(type);
            }
        }
    }
}
