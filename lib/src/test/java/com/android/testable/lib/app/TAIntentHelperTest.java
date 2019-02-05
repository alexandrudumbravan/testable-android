package com.android.testable.lib.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Resources;
import android.util.AttributeSet;
import com.android.testable.lib.res.TAResources;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Intent.class})
public class TAIntentHelperTest {

    private TAIntentHelper subject;
    @Mock
    private Intent intent;

    @Before
    public void setUp() {
        subject = new TAIntentHelper();
        PowerMockito.mockStatic(Intent.class);
    }

    @Test
    public void createChooser() {
        String title = "title";
        Intent chooserIntent = mock(Intent.class);
        when(Intent.createChooser(intent, title)).thenReturn(chooserIntent);
        assertEquals(chooserIntent, subject.createChooser(new TAIntent(intent), title).intent);
    }

    @Test
    public void createChooser_withSender() {
        String title = "title";
        IntentSender intentSender = mock(IntentSender.class);
        Intent chooserIntent = mock(Intent.class);
        when(Intent.createChooser(intent, title, intentSender)).thenReturn(chooserIntent);
        assertEquals(chooserIntent, subject.createChooser(new TAIntent(intent), title, intentSender).intent);
    }

    @Test
    public void getIntentOld() throws URISyntaxException {
        String uri = "uri";
        when(Intent.getIntentOld(uri)).thenReturn(intent);
        assertEquals(intent, subject.getIntentOld(uri).intent);
    }

    @Test
    public void makeMainActivity() {
        ComponentName componentName = mock(ComponentName.class);
        when(Intent.makeMainActivity(componentName)).thenReturn(intent);
        assertEquals(intent, subject.makeMainActivity(componentName).intent);
    }

    @Test
    public void makeMainSelectorActivity() {
        String action = "action";
        String category = "category";
        when(Intent.makeMainSelectorActivity(action, category)).thenReturn(intent);
        assertEquals(intent, subject.makeMainSelectorActivity(action, category).intent);
    }

    @Test
    public void makeRestartActivityTask() {
        ComponentName componentName = mock(ComponentName.class);
        when(Intent.makeRestartActivityTask(componentName)).thenReturn(intent);
        assertEquals(intent, subject.makeRestartActivityTask(componentName).intent);
    }

    @Test
    public void normalizeMimeType() {
        String type = "type";
        String result = "result";
        when(Intent.normalizeMimeType(type)).thenReturn(result);
        assertEquals(result, subject.normalizeMimeType(type));
    }

    @Test
    public void parseIntent() throws IOException, XmlPullParserException {
        Context context = mock(Context.class);
        Resources resources = mock(Resources.class);
        when(context.getApplicationContext()).thenReturn(context);
        when(context.getResources()).thenReturn(resources);
        TAResources taResources = new TAResources(context);
        XmlPullParser parser = mock(XmlPullParser.class);
        AttributeSet attrs = mock(AttributeSet.class);
        when(Intent.parseIntent(taResources.resources, parser, attrs)).thenReturn(intent);
        assertEquals(intent, subject.parseIntent(taResources, parser, attrs).intent);
    }

    @Test
    public void parseUri() throws URISyntaxException {
        String type = "type";
        int flags = 1;
        when(Intent.parseUri(type, flags)).thenReturn(intent);
        assertEquals(intent, subject.parseUri(type, flags).intent);
    }
}