package com.android.testable.lib.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.android.testable.lib.ComponentGenerator;

public class TABroadcastManager {

    @NonNull
    private Context context;
    @NonNull
    private LocalBroadcastManagerWrapper localBroadcastManagerWrapper;
    @NonNull
    private ComponentGenerator componentGenerator;

    TABroadcastManager(@NonNull Context context,
                       @NonNull LocalBroadcastManagerWrapper localBroadcastManagerWrapper,
                       @NonNull ComponentGenerator componentGenerator) {
        this.context = context;
        this.localBroadcastManagerWrapper = localBroadcastManagerWrapper;
        this.componentGenerator = componentGenerator;
    }

    /**
     * Invokes {@link Context#registerReceiver(BroadcastReceiver, IntentFilter)}
     *
     * @param taBroadcastReceiver the receiver to register
     * @param action              the action associated with receiver
     */
    public void registerBroadcastReceiver(@NonNull TABroadcastReceiver taBroadcastReceiver, @NonNull String action) {
        context.registerReceiver(taBroadcastReceiver, componentGenerator.createIntentFilter(action));
    }

    /**
     * Invokes {@link Context#unregisterReceiver(BroadcastReceiver)}
     *
     * @param taBroadcastReceiver the receiver to unregister
     */
    public void unregisterBroadcastReceiver(@NonNull TABroadcastReceiver taBroadcastReceiver) {
        context.unregisterReceiver(taBroadcastReceiver);
    }

    /**
     * Invokes {@link LocalBroadcastManager#registerReceiver(BroadcastReceiver, IntentFilter)}
     *
     * @param taBroadcastReceiver the receiver to register
     * @param action              the action associated with receiver
     */
    public void registerLocalBroadcastReceiver(@NonNull TABroadcastReceiver taBroadcastReceiver, @NonNull String action) {
        localBroadcastManagerWrapper.registerReceiver(taBroadcastReceiver, componentGenerator.createIntentFilter(action));
    }

    /**
     * Invokes {@link LocalBroadcastManager#unregisterReceiver(BroadcastReceiver)}
     *
     * @param taBroadcastReceiver the receiver to unregister
     */
    public void unregisterLocalBroadcastReceiver(@NonNull TABroadcastReceiver taBroadcastReceiver) {
        localBroadcastManagerWrapper.unregisterReceiver(taBroadcastReceiver);
    }


    @NonNull
    public static TABroadcastManager create(@NonNull Context context) {
        return new TABroadcastManager(context.getApplicationContext(),
                LocalBroadcastManagerWrapper.create(context),
                new ComponentGenerator());
    }

}
