package com.android.testable.lib.app;

import android.content.Context;
import android.content.Intent;

public class TAIntent implements TAIntentActions {

    public final Intent intent;

    public TAIntent() {
        this(new Intent());
    }

    public TAIntent(TAIntent taIntent) {
        this(new Intent(taIntent.intent));
    }

    public TAIntent(String action) {
        this(new Intent(action));
    }

    public TAIntent(String action, TAUri taUri) {
        this(new Intent(action, taUri.uri));
    }

    public TAIntent(Context context, Class<?> activityClass) {
        this(new Intent(context, activityClass));
    }

    public TAIntent(String action, TAUri taUri, Context context, Class<?> activityClass) {
        this(new Intent(action, taUri.uri, context, activityClass));
    }

    public TAIntent(Intent intent) {
        this.intent = intent;
    }

}
