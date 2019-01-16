package com.android.testable.lib.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public abstract class TABroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        onReceive();
    }

    public abstract void onReceive();

}
