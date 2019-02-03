package com.android.testable.lib.app;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.android.testable.lib.ComponentGenerator;
import com.android.testable.lib.os.TABundle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FragmentComponentStarterTest {

    private FragmentComponentStarter subject;
    @Mock
    private Fragment fragment;
    @Mock
    private ComponentGenerator componentGenerator;

    @Before
    public void setUp() {
        subject = new FragmentComponentStarter(fragment, componentGenerator);
    }

    @Test
    public void getActivity() {
        FragmentActivity activity = mock(FragmentActivity.class);
        when(fragment.getContext()).thenReturn(activity);
        assertEquals(activity, subject.getActivity());
    }

    @Test
    public void startActivityForResult() {
        int requestCode = 123;
        TAIntent taIntent = new TAIntent(mock(Intent.class));
        subject.startActivityForResult(taIntent, requestCode);
        verify(fragment).startActivityForResult(taIntent.intent, requestCode);
    }

    @Test
    public void startActivityForResult_withOptions() {
        int requestCode = 123;
        TAIntent taIntent = new TAIntent(mock(Intent.class));
        TABundle taBundle = new TABundle(mock(Bundle.class));
        subject.startActivityForResult(taIntent, requestCode, taBundle);
        verify(fragment).startActivityForResult(taIntent.intent, requestCode, taBundle.bundle);
    }

    @Test
    public void startActivityForResultCompat() {
        FragmentComponentStarter spy = spy(subject);
        int requestCode = 123;
        TAIntent taIntent = new TAIntent(mock(Intent.class));
        TABundle taBundle = new TABundle(mock(Bundle.class));
        spy.startActivityForResultCompat(taIntent, requestCode, taBundle);
        verify(spy).startActivityForResult(taIntent, requestCode, taBundle);
    }

    @Test
    public void requestPermissions() {
        FragmentComponentStarter spy = spy(subject);
        int requestCode = 123;
        String[] permissions = new String[]{"p1", "p2"};
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) {
                return null;
            }
        }).when(spy).requestPermissions(fragment, permissions, requestCode);
        spy.requestPermissions(permissions, requestCode);
        verify(spy).requestPermissions(fragment, permissions, requestCode);
    }
}