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
    public Intent createChooser(@NonNull Intent target, @Nullable CharSequence title, @Nullable IntentSender sender) {
        return Intent.createChooser(target, title, sender);
    }

    /**
     * Invokes {@link Intent#createChooser(Intent, CharSequence)}
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    @NonNull
    public Intent createChooser(@NonNull Intent target, @Nullable CharSequence title) {
        return Intent.createChooser(target, title);
    }

    /**
     * Invokes {@link Intent#getIntentOld(String)}
     */
    @NonNull
    public Intent getIntentOld(@NonNull String uri) throws URISyntaxException {
        return Intent.getIntentOld(uri);
    }

    /**
     * Invokes {@link Intent#makeMainActivity(ComponentName)}
     */
    @NonNull
    public Intent makeMainActivity(@NonNull ComponentName mainActivity) {
        return Intent.makeMainActivity(mainActivity);
    }

    /**
     * Invokes {@link Intent#makeMainSelectorActivity(String, String)}
     */
    @NonNull
    public Intent makeMainSelectorActivity(@NonNull String selectorAction, @Nullable String selectorCategory) {
        return Intent.makeMainSelectorActivity(selectorAction, selectorCategory);
    }

    /**
     * Invokes {@link Intent#makeRestartActivityTask(ComponentName)}
     */
    @NonNull
    public Intent makeRestartActivityTask(@NonNull ComponentName mainActivity) {
        return Intent.makeRestartActivityTask(mainActivity);
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
    public Intent parseIntent(TAResources resources, XmlPullParser parser, AttributeSet attrs) throws IOException, XmlPullParserException {
        return Intent.parseIntent(resources.resources, parser, attrs);
    }

    /**
     * Invokes {@link Intent#parseUri(String, int)}
     */
    @NonNull
    public Intent parseUri(String uri, int flags) throws URISyntaxException {
        return Intent.parseUri(uri, flags);
    }
}
