package com.android.testable.lib.util;

import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class NonNullRunnableTest {

    @Test
    public void run() {
        String type = "type";
        NonNullRunnable<String> runnable = mock(NonNullRunnable.class);
        NonNullRunnable.Executor.execute(type, runnable);
        verify(runnable).run(type);
    }

    @Test
    public void run_null() {
        String type = null;
        NonNullRunnable<String> runnable = mock(NonNullRunnable.class);
        NonNullRunnable.Executor.execute(type, runnable);
        verify(runnable, never()).run(anyString());
    }
}