package com.android.testable.lib.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import com.android.testable.lib.ComponentGenerator;
import com.android.testable.lib.os.TABundle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ActivityCompat.class})
public class ActivityComponentStarterTest {

    private ActivityComponentStarter subject;
    @Mock
    private Activity activity;
    @Mock
    private ComponentGenerator componentGenerator;

    @Before
    public void setUp() {
        subject = new ActivityComponentStarter(activity, componentGenerator);
        mockStatic(ActivityCompat.class);
    }

    @Test
    public void getActivity() {
        assertEquals(activity, subject.getActivity());
    }

    @Test
    public void startActivityForResult() {
        int requestCode = 123;
        TAIntent taIntent = new TAIntent(mock(Intent.class));
        subject.startActivityForResult(taIntent, requestCode);
        verify(activity).startActivityForResult(taIntent.intent, requestCode);
    }

    @Test
    public void startActivityForResult_withOptions() {
        int requestCode = 123;
        TAIntent taIntent = new TAIntent(mock(Intent.class));
        TABundle taBundle = new TABundle(mock(Bundle.class));
        subject.startActivityForResult(taIntent, requestCode, taBundle);
        verify(activity).startActivityForResult(taIntent.intent, requestCode, taBundle.bundle);
    }

    @Test
    public void startActivityForResultCompat() {
        int requestCode = 123;
        TAIntent taIntent = new TAIntent(mock(Intent.class));
        TABundle taBundle = new TABundle(mock(Bundle.class));
        subject.startActivityForResultCompat(taIntent, requestCode, taBundle);
        verifyStatic();
        ActivityCompat.startActivityForResult(activity, taIntent.intent, requestCode, taBundle.bundle);
    }

    @Test
    public void requestPermissions() {
        int requestCode = 123;
        String[] permissions = new String[]{"p1", "p2"};
        subject.requestPermissions(permissions, requestCode);
        verifyStatic();
        ActivityCompat.requestPermissions(activity, permissions, requestCode);
    }
}