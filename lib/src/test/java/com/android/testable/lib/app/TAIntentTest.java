package com.android.testable.lib.app;

import android.content.*;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.android.testable.lib.os.TABundle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TAIntentTest {

    private TAIntent subject;
    @Mock
    private Intent intent;

    @Before
    public void setUp() {
        subject = new TAIntent(intent);
    }

    @Test
    public void addCategory() {
        String category = "category";
        TAIntent result = subject.addCategory(category);
        verify(intent).addCategory(category);
        assertEquals(subject, result);
    }

    @Test
    public void addFlags() {
        int flags = 123;
        TAIntent result = subject.addFlags(flags);
        verify(intent).addFlags(flags);
        assertEquals(subject, result);
    }

    @Test
    public void fillIn() {
        TAIntent other = new TAIntent(mock(Intent.class));
        int flags = 12;
        int fillInResult = 1;
        when(intent.fillIn(other.intent, flags)).thenReturn(fillInResult);
        int result = subject.fillIn(other, flags);
        verify(intent).fillIn(other.intent, flags);
        assertEquals(fillInResult, result);

    }

    @Test
    public void filterEquals() {
        TAIntent other = new TAIntent(mock(Intent.class));
        when(intent.filterEquals(other.intent)).thenReturn(true);
        boolean result = subject.filterEquals(other);
        assertTrue(result);
    }

    @Test
    public void filterHashCode() {
        int hash = 12;
        when(intent.filterHashCode()).thenReturn(hash);
        int result = subject.filterHashCode();
        assertEquals(hash, result);
    }

    @Test
    public void getAction() {
        String action = "action";
        when(intent.getAction()).thenReturn(action);
        String result = subject.getAction();
        assertEquals(action, result);
    }

    @Test
    public void getCategories() {
        Set<String> categories = new HashSet<>();
        categories.add("1");
        categories.add("2");
        when(intent.getCategories()).thenReturn(categories);
        Set<String> result = subject.getCategories();
        assertEquals(categories, result);
    }

    @Test
    public void getClipData() {
        ClipData clipData = mock(ClipData.class);
        when(intent.getClipData()).thenReturn(clipData);
        assertEquals(clipData, subject.getClipData());
    }

    @Test
    public void getComponent() {
        ComponentName componentName = mock(ComponentName.class);
        when(intent.getComponent()).thenReturn(componentName);
        assertEquals(componentName, subject.getComponent());
    }

    @Test
    public void getData() {
        TAUri taUri = new TAUri(mock(Uri.class));
        when(intent.getData()).thenReturn(taUri.uri);
        assertEquals(taUri.uri, subject.getData().uri);
    }

    @Test
    public void getDataString() {
        String uri = "uri";
        when(intent.getDataString()).thenReturn(uri);
        assertEquals(uri, subject.getDataString());
    }

    @Test
    public void getExtras() {
        TABundle taBundle = new TABundle(mock(Bundle.class));
        when(intent.getExtras()).thenReturn(taBundle.bundle);
        assertEquals(taBundle.bundle, subject.getExtras().bundle);
    }

    @Test
    public void getFlags() {
        int flags = 123;
        when(intent.getFlags()).thenReturn(flags);
        assertEquals(flags, subject.getFlags());
    }

    @Test
    public void getPackage() {
        String pack = "pack";
        when(intent.getPackage()).thenReturn(pack);
        assertEquals(pack, subject.getPackage());
    }

    @Test
    public void getScheme() {
        String scheme = "scheme";
        when(intent.getScheme()).thenReturn(scheme);
        assertEquals(scheme, subject.getScheme());
    }

    @Test
    public void getSelector() {
        TAIntent selector = new TAIntent(mock(Intent.class));
        when(intent.getSelector()).thenReturn(selector.intent);
        assertEquals(selector.intent, subject.getSelector().intent);
    }

    @Test
    public void getSourceBounds() {
        Rect rect = mock(Rect.class);
        when(intent.getSourceBounds()).thenReturn(rect);
        assertEquals(rect, subject.getSourceBounds());
    }

    @Test
    public void getType() {
        String type = "type";
        when(intent.getType()).thenReturn(type);
        assertEquals(type, subject.getType());
    }

    @Test
    public void hasCategory() {
        String category = "category";
        when(intent.hasCategory(category)).thenReturn(true);
        assertTrue(subject.hasCategory(category));
    }

    @Test
    public void hasExtra() {
        String extra = "extra";
        when(intent.hasExtra(extra)).thenReturn(true);
        assertTrue(subject.hasExtra(extra));
    }

    @Test
    public void hasFileDescriptors() {
        when(intent.hasFileDescriptors()).thenReturn(true);
        assertTrue(subject.hasFileDescriptors());
    }

    @Test
    public void putExtras() {
        TABundle taBundle = new TABundle(mock(Bundle.class));
        TAIntent result = subject.putExtras(taBundle);
        verify(intent).putExtras(taBundle.bundle);
        assertEquals(subject, result);
    }

    @Test
    public void putExtras_intent() {
        TAIntent extras = new TAIntent(mock(Intent.class));
        TAIntent result = subject.putExtras(extras);
        verify(intent).putExtras(extras.intent);
        assertEquals(subject, result);
    }

    @Test
    public void removeCategory() {
        String category = "category";
        subject.removeCategory(category);
        verify(intent).removeCategory(category);
    }

    @Test
    public void removeExtra() {
        String extra = "extra";
        subject.removeExtra(extra);
        verify(intent).removeExtra(extra);
    }

    @Test
    public void removeFlags() {
        int flags = 123;
        subject.removeFlags(flags);
        verify(intent).removeFlags(flags);
    }

    @Test
    public void replaceExtras() {
        TABundle taBundle = new TABundle(mock(Bundle.class));
        Intent replacedExtrasIntent = mock(Intent.class);
        when(intent.replaceExtras(taBundle.bundle)).thenReturn(replacedExtrasIntent);
        TAIntent result = subject.replaceExtras(taBundle);
        assertEquals(replacedExtrasIntent, result.intent);
    }

    @Test
    public void replaceExtras_intent() {
        TAIntent extras = new TAIntent(mock(Intent.class));
        Intent replacedExtrasIntent = mock(Intent.class);
        when(intent.replaceExtras(extras.intent)).thenReturn(replacedExtrasIntent);
        TAIntent result = subject.replaceExtras(extras);
        assertEquals(replacedExtrasIntent, result.intent);
    }

    @Test
    public void resolveActivity() {
        PackageManager packageManager = mock(PackageManager.class);
        ComponentName componentName = mock(ComponentName.class);
        when(intent.resolveActivity(packageManager)).thenReturn(componentName);
        ComponentName result = subject.resolveActivity(packageManager);
        assertEquals(componentName, result);
    }

    @Test
    public void resolveActivityInfo() {
        PackageManager packageManager = mock(PackageManager.class);
        int flags = 123;
        ActivityInfo activityInfo = mock(ActivityInfo.class);
        when(intent.resolveActivityInfo(packageManager, flags)).thenReturn(activityInfo);
        ActivityInfo result = subject.resolveActivityInfo(packageManager, flags);
        assertEquals(activityInfo, result);
    }

    @Test
    public void resolveType() {
        Context context = mock(Context.class);
        String type = "type";
        when(intent.resolveType(context)).thenReturn(type);
        assertEquals(type, subject.resolveType(context));
    }

    @Test
    public void resolveType_contentResolver() {
        ContentResolver contentResolver = mock(ContentResolver.class);
        String type = "type";
        when(intent.resolveType(contentResolver)).thenReturn(type);
        assertEquals(type, subject.resolveType(contentResolver));
    }

    @Test
    public void resolveTypeIfNeeded() {
        ContentResolver contentResolver = mock(ContentResolver.class);
        String type = "type";
        when(intent.resolveTypeIfNeeded(contentResolver)).thenReturn(type);
        assertEquals(type, subject.resolveTypeIfNeeded(contentResolver));
    }

    @Test
    public void setAction() {
        String action = "action";
        TAIntent result = subject.setAction(action);
        verify(intent).setAction(action);
        assertEquals(subject, result);
    }

    @Test
    public void setClass() {
        Context context = mock(Context.class);
        Class<?> testClass = getClass();
        TAIntent result = subject.setClass(context, testClass);
        verify(intent).setClass(context, testClass);
        assertEquals(subject, result);
    }

    @Test
    public void setClassName() {
        Context context = mock(Context.class);
        String className = "className";
        TAIntent result = subject.setClassName(context, className);
        verify(intent).setClassName(context, className);
        assertEquals(subject, result);
    }

    @Test
    public void setClassName_withPackage() {
        String pack = "package";
        String className = "className";
        TAIntent result = subject.setClassName(pack, className);
        verify(intent).setClassName(pack, className);
        assertEquals(subject, result);
    }

    @Test
    public void setClipData() {
        ClipData clipData = mock(ClipData.class);
        TAIntent result = subject.setClipData(clipData);
        verify(intent).setClipData(clipData);
        assertEquals(subject, result);
    }

    @Test
    public void setComponent() {
        ComponentName componentName = mock(ComponentName.class);
        TAIntent result = subject.setComponent(componentName);
        verify(intent).setComponent(componentName);
        assertEquals(subject, result);
    }

    @Test
    public void setData() {
        TAUri taUri = new TAUri(mock(Uri.class));
        TAIntent result = subject.setData(taUri);
        verify(intent).setData(taUri.uri);
        assertEquals(subject, result);
    }

    @Test
    public void setDataAndNormalize() {
        TAUri taUri = new TAUri(mock(Uri.class));
        TAIntent result = subject.setDataAndNormalize(taUri);
        verify(intent).setDataAndNormalize(taUri.uri);
        assertEquals(subject, result);
    }

    @Test
    public void setDataAndType() {
        TAUri taUri = new TAUri(mock(Uri.class));
        String type = "type";
        TAIntent result = subject.setDataAndType(taUri, type);
        verify(intent).setDataAndType(taUri.uri, type);
        assertEquals(subject, result);
    }

    @Test
    public void setDataAndTypeAndNormalize() {
        TAUri taUri = new TAUri(mock(Uri.class));
        String type = "type";
        TAIntent result = subject.setDataAndTypeAndNormalize(taUri, type);
        verify(intent).setDataAndTypeAndNormalize(taUri.uri, type);
        assertEquals(subject, result);
    }

    @Test
    public void setExtrasClassLoader() {
        ClassLoader classLoader = getClass().getClassLoader();
        subject.setExtrasClassLoader(classLoader);
        verify(intent).setExtrasClassLoader(classLoader);
    }

    @Test
    public void setFlags() {
        int flags = 123;
        TAIntent result = subject.setFlags(flags);
        verify(intent).setFlags(flags);
        assertEquals(subject, result);
    }

    @Test
    public void setPackage() {
        String pack = "package";
        TAIntent result = subject.setPackage(pack);
        verify(intent).setPackage(pack);
        assertEquals(subject, result);
    }

    @Test
    public void setSelector() {
        TAIntent taIntent = new TAIntent(mock(Intent.class));
        subject.setSelector(taIntent);
        verify(intent).setSelector(taIntent.intent);
    }

    @Test
    public void setSourceBounds() {
        Rect rect = mock(Rect.class);
        subject.setSourceBounds(rect);
        verify(intent).setSourceBounds(rect);
    }

    @Test
    public void setType() {
        String type = "type";
        TAIntent result = subject.setType(type);
        verify(intent).setType(type);
        assertEquals(subject, result);
    }

    @Test
    public void setTypeAndNormalize() {
        String type = "type";
        TAIntent result = subject.setTypeAndNormalize(type);
        verify(intent).setTypeAndNormalize(type);
        assertEquals(subject, result);
    }

    @Test
    public void testToString() {
        String string = "string";
        when(intent.toString()).thenReturn(string);
        assertEquals(string, subject.toString());
    }

    @Test
    public void toUri() {
        String uri = "uri";
        int flags = 123;
        when(intent.toUri(flags)).thenReturn(uri);
        assertEquals(uri, subject.toUri(flags));
    }

    @Test
    public void describeContents() {
        int contents = 123;
        when(intent.describeContents()).thenReturn(contents);
        assertEquals(contents, subject.describeContents());
    }

    @Test
    public void writeToParcel() {
        Parcel parcel = mock(Parcel.class);
        int flags = 123;
        subject.writeToParcel(parcel, flags);
        verify(parcel).writeParcelable(intent, flags);
    }

    @Test
    public void testClone() {
        Intent clone = mock(Intent.class);
        when(intent.clone()).thenReturn(clone);
        TAIntent result = (TAIntent) subject.clone();
        assertEquals(clone, result.intent);
    }
}