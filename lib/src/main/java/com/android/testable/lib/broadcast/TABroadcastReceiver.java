package com.android.testable.lib.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.testable.lib.app.TAIntent;

public abstract class TABroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        onReceive(new TAIntent(intent));
    }

    public abstract void onReceive(@NonNull TAIntent taIntent);

}
