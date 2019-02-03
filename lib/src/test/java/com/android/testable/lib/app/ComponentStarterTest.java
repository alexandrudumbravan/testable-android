package com.android.testable.lib.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.android.testable.lib.ComponentGenerator;
import com.android.testable.lib.os.TABundle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ActivityCompat.class, ContextCompat.class})
public class ComponentStarterTest {

    private ComponentStarter<?> subject;
    @Mock
    private Activity activity;
    @Mock
    private ComponentGenerator componentGenerator;

    @Before
    public void setUp() {
        subject = new ComponentStarter<Object>(new Object(), componentGenerator) {
            @NonNull
            @Override
            protected Activity getActivity() {
                return activity;
            }

            @Override
            public void startActivityForResult(@NonNull TAIntent taIntent, int requestCode) {

            }

            @Override
            public void startActivityForResult(@NonNull TAIntent taIntent, int requestCode, @NonNull TABundle options) {

            }

            @Override
            public void startActivityForResultCompat(@NonNull TAIntent taIntent, int requestCode, @NonNull TABundle options) {

            }

            @Override
            public void requestPermissions(@NonNull String[] permissions, int requestCode) {

            }
        };
        PowerMockito.mockStatic(ActivityCompat.class);
        PowerMockito.mockStatic(ContextCompat.class);
    }

    @Test
    public void createIntent() {
        TAIntent taIntent = new TAIntent(mock(Intent.class));
        when(componentGenerator.createIntent()).thenReturn(taIntent);
        assertEquals(taIntent, subject.createIntent());
    }

    @Test
    public void createIntent_action() {
        String action = "action";
        TAIntent taIntent = new TAIntent(mock(Intent.class));
        when(componentGenerator.createIntent(action)).thenReturn(taIntent);
        assertEquals(taIntent, subject.createIntent(action));
    }

    @Test
    public void createIntent_wrapper() {
        TAIntent taIntent = new TAIntent(mock(Intent.class));
        TAIntent wrapper = new TAIntent(mock(Intent.class));
        when(componentGenerator.createIntent(wrapper)).thenReturn(taIntent);
        assertEquals(taIntent, subject.createIntent(wrapper));
    }

    @Test
    public void createIntent_actionAndUri() {
        String action = "action";
        TAUri taUri = new TAUri(mock(Uri.class));
        TAIntent taIntent = new TAIntent(mock(Intent.class));
        when(componentGenerator.createIntent(action, taUri)).thenReturn(taIntent);
        assertEquals(taIntent, subject.createIntent(action, taUri));
    }

    @Test
    public void createIntent_class() {
        Class<?> activityClass = getClass();
        TAIntent taIntent = new TAIntent(mock(Intent.class));
        when(componentGenerator.createIntent(activity, activityClass)).thenReturn(taIntent);
        assertEquals(taIntent, subject.createIntent(activityClass));
    }

    @Test
    public void createIntent_classAndUriAndAction() {
        Class<?> activityClass = getClass();
        String action = "action";
        TAUri taUri = new TAUri(mock(Uri.class));
        TAIntent taIntent = new TAIntent(mock(Intent.class));
        when(componentGenerator.createIntent(activity, action, taUri, activityClass)).thenReturn(taIntent);
        assertEquals(taIntent, subject.createIntent(action, taUri, activityClass));
    }


    @Test
    public void createExtras() {
        TABundle taBundle = new TABundle(mock(Bundle.class));
        when(componentGenerator.createExtras()).thenReturn(taBundle);
        assertEquals(taBundle, subject.createExtras());
    }

    @Test
    public void startService() {
        TAIntent taIntent = new TAIntent(mock(Intent.class));
        subject.startService(taIntent);
        verify(activity).startService(taIntent.intent);
    }

    @Test
    public void startServiceForeground() {
        TAIntent taIntent = new TAIntent(mock(Intent.class));
        subject.startServiceForeground(taIntent);
        verify(activity).startForegroundService(taIntent.intent);
    }

    @Test
    public void startServiceForegroundCompat() {
        TAIntent taIntent = new TAIntent(mock(Intent.class));
        subject.startServiceForegroundCompat(taIntent);
        verifyStatic();
        ActivityCompat.startForegroundService(activity, taIntent.intent);
    }

    @Test
    public void startActivity() {
        TAIntent taIntent = new TAIntent(mock(Intent.class));
        subject.startActivity(taIntent);
        verify(activity).startActivity(taIntent.intent);
    }

    @Test
    public void startActivity_withOptions() {
        TAIntent taIntent = new TAIntent(mock(Intent.class));
        TABundle taBundle = new TABundle(mock(Bundle.class));
        subject.startActivity(taIntent, taBundle);
        verify(activity).startActivity(taIntent.intent, taBundle.bundle);
    }

    @Test
    public void startActivityCompat() {
        TAIntent taIntent = new TAIntent(mock(Intent.class));
        TABundle taBundle = new TABundle(mock(Bundle.class));
        subject.startActivityCompat(taIntent, taBundle);
        verifyStatic();
        ActivityCompat.startActivity(activity, taIntent.intent, taBundle.bundle);
    }

    @Test
    public void startActivities() {
        TAIntent[] taIntents = new TAIntent[]{new TAIntent(mock(Intent.class)),
                new TAIntent(mock(Intent.class)),
                new TAIntent(mock(Intent.class))};

        subject.startActivities(taIntents);

        Intent[] intents = new Intent[taIntents.length];
        for (int i = 0; i < taIntents.length; i++) {
            intents[i] = taIntents[i].intent;
        }
        verify(activity).startActivities(intents);
    }

    @Test
    public void startActivities_withOptions() {
        TAIntent[] taIntents = new TAIntent[]{new TAIntent(mock(Intent.class)),
                new TAIntent(mock(Intent.class)),
                new TAIntent(mock(Intent.class))};
        TABundle taBundle = new TABundle(mock(Bundle.class));

        subject.startActivities(taIntents, taBundle);

        Intent[] intents = new Intent[taIntents.length];
        for (int i = 0; i < taIntents.length; i++) {
            intents[i] = taIntents[i].intent;
        }
        verify(activity).startActivities(intents, taBundle.bundle);
    }

    @Test
    public void startActivitiesCompat() {
        TAIntent[] taIntents = new TAIntent[]{new TAIntent(mock(Intent.class)),
                new TAIntent(mock(Intent.class)),
                new TAIntent(mock(Intent.class))};
        TABundle taBundle = new TABundle(mock(Bundle.class));

        subject.startActivitiesCompat(taIntents, taBundle);

        Intent[] intents = new Intent[taIntents.length];
        for (int i = 0; i < taIntents.length; i++) {
            intents[i] = taIntents[i].intent;
        }
        verifyStatic();
        ActivityCompat.startActivities(activity, intents, taBundle.bundle);
    }

    @Test
    public void finish() {
        subject.finish();
        verify(activity).finish();
    }

    @Test
    public void isGrantedPermission_granted() {
        String permission = "permission";
        PowerMockito.when(ContextCompat.checkSelfPermission(activity, permission)).thenReturn(TAAndroidPermissions.PERMISSION_GRANTED);
        assertTrue(subject.isGrantedPermission(permission));
    }

    @Test
    public void isGrantedPermission_denied() {
        String permission = "permission";
        PowerMockito.when(ContextCompat.checkSelfPermission(activity, permission)).thenReturn(TAAndroidPermissions.PERMISSION_DENIED);
        assertFalse(subject.isGrantedPermission(permission));
    }

    @Test
    public void shouldShowPermissionRationale_true() {
        String permission = "permission";
        PowerMockito.when(ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)).thenReturn(true);
        assertTrue(subject.shouldShowPermissionRationale(permission));
    }

    @Test
    public void shouldShowPermissionRationale_false() {
        String permission = "permission";
        PowerMockito.when(ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)).thenReturn(false);
        assertFalse(subject.shouldShowPermissionRationale(permission));
    }

}