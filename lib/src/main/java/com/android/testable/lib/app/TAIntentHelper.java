package com.android.testable.lib.app;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Resources;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.android.testable.lib.res.TAResources;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.net.URISyntaxException;

public class TAIntentHelper {

    /**
     * Invokes {@link Intent#createChooser(Intent, CharSequence, IntentSender)}
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    @NonNull
    public TAIntent createChooser(@NonNull TAIntent target, @Nullable CharSequence title, @Nullable IntentSender sender) {
        return new TAIntent(Intent.createChooser(target.intent, title, sender));
    }

    /**
     * Invokes {@link Intent#createChooser(Intent, CharSequence)}
     */
    @NonNull
    public TAIntent createChooser(@NonNull TAIntent target, @Nullable CharSequence title) {
        return new TAIntent(Intent.createChooser(target.intent, title));
    }

    /**
     * Invokes {@link Intent#getIntentOld(String)}
     */
    @NonNull
    public TAIntent getIntentOld(@NonNull String uri) throws URISyntaxException {
        return new TAIntent(Intent.getIntentOld(uri));
    }

    /**
     * Invokes {@link Intent#makeMainActivity(ComponentName)}
     */
    @NonNull
    public TAIntent makeMainActivity(@NonNull ComponentName mainActivity) {
        return new TAIntent(Intent.makeMainActivity(mainActivity));
    }

    /**
     * Invokes {@link Intent#makeMainSelectorActivity(String, String)}
     */
    @NonNull
    public TAIntent makeMainSelectorActivity(@NonNull String selectorAction, @Nullable String selectorCategory) {
        return new TAIntent(Intent.makeMainSelectorActivity(selectorAction, selectorCategory));
    }

    /**
     * Invokes {@link Intent#makeRestartActivityTask(ComponentName)}
     */
    @NonNull
    public TAIntent makeRestartActivityTask(@NonNull ComponentName mainActivity) {
        return new TAIntent(Intent.makeRestartActivityTask(mainActivity));
    }

    /**
     * Invokes {@link Intent#normalizeMimeType(String)}
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Nullable
    public String normalizeMimeType(@Nullable String type) {
        return Intent.normalizeMimeType(type);
    }

    /**
     * Invokes {@link Intent#parseIntent(Resources, XmlPullParser, AttributeSet)}
     */
    @NonNull
    public TAIntent parseIntent(TAResources resources, XmlPullParser parser, AttributeSet attrs) throws IOException, XmlPullParserException {
        return new TAIntent(Intent.parseIntent(resources.resources, parser, attrs));
    }

    /**
     * Invokes {@link Intent#parseUri(String, int)}
     */
    @NonNull
    public TAIntent parseUri(String uri, int flags) throws URISyntaxException {
        return new TAIntent(Intent.parseUri(uri, flags));
    }
}
