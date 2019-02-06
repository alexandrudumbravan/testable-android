package com.android.testable.lib.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class LocalBroadcastManagerWrapper {

    @NonNull
    private LocalBroadcastManager localBroadcastManager;

    public LocalBroadcastManagerWrapper(@NonNull LocalBroadcastManager localBroadcastManager) {
        this.localBroadcastManager = localBroadcastManager;
    }

    /**
     * Invokes {@link LocalBroadcastManager#registerReceiver(BroadcastReceiver, IntentFilter)}
     *
     * @param broadcastReceiver the receiver to register
     * @param intentFilter      the intent filter with the actions associated with the broadcast
     */
    public void registerReceiver(@NonNull BroadcastReceiver broadcastReceiver, @NonNull IntentFilter intentFilter) {
        localBroadcastManager.registerReceiver(broadcastReceiver, intentFilter);
    }

    /**
     * Invokes {@link LocalBroadcastManager#unregisterReceiver(BroadcastReceiver)}
     *
     * @param broadcastReceiver the receiver to unregister
     */
    public void unregisterReceiver(@NonNull BroadcastReceiver broadcastReceiver) {
        localBroadcastManager.unregisterReceiver(broadcastReceiver);
    }

    @NonNull
    public static LocalBroadcastManagerWrapper create(@NonNull Context context) {
        return new LocalBroadcastManagerWrapper(LocalBroadcastManager.getInstance(context.getApplicationContext()));
    }

}
