package com.android.testable.lib.broadcast;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.android.testable.lib.app.TAIntent;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TABroadcastReceiverTest {

    private TABroadcastReceiver subject;

    @Before
    public void setUp() {
        subject = spy(new TABroadcastReceiver() {
            @Override
            public void onReceive(@NonNull TAIntent taIntent) {

            }
        });
    }

    @Test
    public void onReceive() {
        Context context = mock(Context.class);
        Intent intent = mock(Intent.class);
        subject.onReceive(context, intent);

        ArgumentCaptor<TAIntent> captor = ArgumentCaptor.forClass(TAIntent.class);
        verify(subject).onReceive(captor.capture());
        assertEquals(intent, captor.getValue().intent);
    }
}