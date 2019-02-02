package com.android.testable.lib.broadcast;

import android.content.Context;
import android.content.IntentFilter;
import com.android.testable.lib.ComponentGenerator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TABroadcastManagerTest {

    private static final String ACTION = "action";

    private TABroadcastManager subject;
    @Mock
    private Context context;
    @Mock
    private LocalBroadcastManagerWrapper localBroadcastManagerWrapper;
    @Mock
    private ComponentGenerator componentGenerator;
    @Mock
    private IntentFilter intentFilter;
    @Mock
    private TABroadcastReceiver taBroadcastReceiver;


    @Before
    public void setUp() {
        subject = new TABroadcastManager(context, localBroadcastManagerWrapper, componentGenerator);
        when(componentGenerator.createIntentFilter(ACTION)).thenReturn(intentFilter);
    }

    @Test
    public void registerBroadcastReceiver() {
        subject.registerBroadcastReceiver(taBroadcastReceiver, ACTION);
        verify(context).registerReceiver(taBroadcastReceiver, intentFilter);
    }

    @Test
    public void unregisterBroadcastReceiver() {
        subject.unregisterBroadcastReceiver(taBroadcastReceiver);
        verify(context).unregisterReceiver(taBroadcastReceiver);
    }

    @Test
    public void registerLocalBroadcastReceiver() {
        subject.registerLocalBroadcastReceiver(taBroadcastReceiver, ACTION);
        verify(localBroadcastManagerWrapper).registerReceiver(taBroadcastReceiver, intentFilter);
    }

    @Test
    public void unregisterLocalBroadcastReceiver() {
        subject.unregisterLocalBroadcastReceiver(taBroadcastReceiver);
        verify(localBroadcastManagerWrapper).unregisterReceiver(taBroadcastReceiver);
    }
}