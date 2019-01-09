package com.android.testable.lib;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ContextCompat.class, ResourcesCompat.class})
public class TAResourcesTest {

    private static final int RESOURCE_ID = 100;

    private TAResources subject;
    @Mock
    private Resources resources;
    @Mock
    private Context context;

    @Before
    public void setUp() {
        when(context.getApplicationContext()).thenReturn(context);
        when(context.getResources()).thenReturn(resources);

        subject = new TAResources(context);
    }

    @Test
    public void finishPreloading() {
        subject.finishPreloading();
        verify(resources).finishPreloading();
    }

    @Test
    public void flushLayoutCache() {
        subject.flushLayoutCache();
        verify(resources).flushLayoutCache();
    }

    @Test
    public void getAnimation() {
        XmlResourceParser xmlResourceParser = mock(XmlResourceParser.class);
        when(resources.getAnimation(RESOURCE_ID)).thenReturn(xmlResourceParser);
        assertEquals(xmlResourceParser, subject.getAnimation(RESOURCE_ID));
    }

    @Test
    public void getAssets() {
        AssetManager assetManager = mock(AssetManager.class);
        when(resources.getAssets()).thenReturn(assetManager);
        assertEquals(assetManager, subject.getAssets());
    }

    @Test
    public void getBoolean() {
        when(resources.getBoolean(RESOURCE_ID)).thenReturn(true);
        boolean result = subject.getBoolean(RESOURCE_ID);
        assertTrue(result);
    }

    @Test
    public void getColor_old() {
        int color = Color.RED;
        when(resources.getColor(RESOURCE_ID)).thenReturn(color);
        assertEquals(color, subject.getColor(RESOURCE_ID));
    }

    @Test
    public void getColor_withTheme() {
        int color = Color.RED;
        Resources.Theme theme = mock(Resources.Theme.class);
        when(resources.getColor(RESOURCE_ID, theme)).thenReturn(color);
        assertEquals(color, subject.getColor(RESOURCE_ID, theme));
    }

    @Test
    public void getColorCompat() {
        int color = Color.RED;
        PowerMockito.mockStatic(ContextCompat.class);
        when(ContextCompat.getColor(context, RESOURCE_ID)).thenReturn(color);
        assertEquals(color, subject.getColorCompat(RESOURCE_ID));
    }

    @Test
    public void getColorStateList_old() {
        ColorStateList colorStateList = mock(ColorStateList.class);
        when(resources.getColorStateList(RESOURCE_ID)).thenReturn(colorStateList);
        assertEquals(colorStateList, subject.getColorStateList(RESOURCE_ID));
    }

    @Test
    public void getColorStateList_withTheme() {
        ColorStateList colorStateList = mock(ColorStateList.class);
        Resources.Theme theme = mock(Resources.Theme.class);
        when(resources.getColorStateList(RESOURCE_ID, theme)).thenReturn(colorStateList);
        assertEquals(colorStateList, subject.getColorStateList(RESOURCE_ID, theme));
    }

    @Test
    public void getColorStateListCompat() {
        ColorStateList colorStateList = mock(ColorStateList.class);
        PowerMockito.mockStatic(ContextCompat.class);
        when(ContextCompat.getColorStateList(context, RESOURCE_ID)).thenReturn(colorStateList);
        assertEquals(colorStateList, subject.getColorStateListCompat(RESOURCE_ID));
    }

    @Test
    public void getConfiguration() {
        Configuration configuration = mock(Configuration.class);
        when(resources.getConfiguration()).thenReturn(configuration);
        assertEquals(configuration, subject.getConfiguration());
    }

    @Test
    public void getDimension() {
        float dimension = 10f;
        when(resources.getDimension(RESOURCE_ID)).thenReturn(dimension);
        assertEquals(dimension, subject.getDimension(RESOURCE_ID), 0);
    }

    @Test
    public void getDimensionPixelOffset() {
        int dimension = 10;
        when(resources.getDimensionPixelOffset(RESOURCE_ID)).thenReturn(dimension);
        assertEquals(dimension, subject.getDimensionPixelOffset(RESOURCE_ID));
    }

    @Test
    public void getDimensionPixelSize() {
        int dimension = 10;
        when(resources.getDimensionPixelSize(RESOURCE_ID)).thenReturn(dimension);
        assertEquals(dimension, subject.getDimensionPixelSize(RESOURCE_ID));
    }

    @Test
    public void getDisplayMetrics() {
        DisplayMetrics displayMetrics = mock(DisplayMetrics.class);
        when(resources.getDisplayMetrics()).thenReturn(displayMetrics);
        assertEquals(displayMetrics, subject.getDisplayMetrics());
    }

    @Test
    public void getDrawable_old() {
        Drawable drawable = mock(Drawable.class);
        when(resources.getDrawable(RESOURCE_ID)).thenReturn(drawable);
        assertEquals(drawable, subject.getDrawable(RESOURCE_ID));
    }

    @Test
    public void getDrawable_withTheme() {
        Drawable drawable = mock(Drawable.class);
        Resources.Theme theme = mock(Resources.Theme.class);
        when(resources.getDrawable(RESOURCE_ID, theme)).thenReturn(drawable);
        assertEquals(drawable, subject.getDrawable(RESOURCE_ID, theme));
    }

    @Test
    public void getDrawableCompat() {
        Drawable drawable = mock(Drawable.class);
        PowerMockito.mockStatic(ContextCompat.class);
        when(ContextCompat.getDrawable(context, RESOURCE_ID)).thenReturn(drawable);
        assertEquals(drawable, subject.getDrawableCompat(RESOURCE_ID));
    }

    @Test
    public void getDrawableForDensity_old() {
        Drawable drawable = mock(Drawable.class);
        int density = 5;
        when(resources.getDrawableForDensity(RESOURCE_ID, 5)).thenReturn(drawable);
        assertEquals(drawable, subject.getDrawableForDensity(RESOURCE_ID, density));
    }

    @Test
    public void getDrawableForDensity_withTheme() {
        Drawable drawable = mock(Drawable.class);
        int density = 5;
        Resources.Theme theme = mock(Resources.Theme.class);
        when(resources.getDrawableForDensity(RESOURCE_ID, 5, theme)).thenReturn(drawable);
        assertEquals(drawable, subject.getDrawableForDensity(RESOURCE_ID, density, theme));
    }

    @Test
    public void getDrawableForDensityCompat() {
        Drawable drawable = mock(Drawable.class);
        int density = 5;
        Resources.Theme theme = mock(Resources.Theme.class);
        PowerMockito.mockStatic(ResourcesCompat.class);
        when(ResourcesCompat.getDrawableForDensity(resources, RESOURCE_ID, density, theme)).thenReturn(drawable);
        assertEquals(drawable, subject.getDrawableForDensityCompat(RESOURCE_ID, density, theme));
    }

    @Test
    public void getFont() {
        Typeface typeface = mock(Typeface.class);
        when(resources.getFont(RESOURCE_ID)).thenReturn(typeface);
        assertEquals(typeface, subject.getFont(RESOURCE_ID));
    }

    @Test
    public void getFontCompat() {
        Typeface typeface = mock(Typeface.class);
        PowerMockito.mockStatic(ResourcesCompat.class);
        when(ResourcesCompat.getFont(context, RESOURCE_ID)).thenReturn(typeface);
        assertEquals(typeface, subject.getFontCompat(RESOURCE_ID));
    }

    @Test
    public void getFraction() {
        int base = 20;
        int pBase = 10;
        float fraction = 5f;
        when(resources.getFraction(RESOURCE_ID, base, pBase)).thenReturn(fraction);
        assertEquals(fraction, subject.getFraction(RESOURCE_ID, base, pBase), 0);
    }

    @Test
    public void getIdentifier() {
        String name = "name";
        String type = "type";
        String pack = "pack";
        when(resources.getIdentifier(name, type, pack)).thenReturn(RESOURCE_ID);
        assertEquals(RESOURCE_ID, subject.getIdentifier(name, type, pack));
    }

    @Test
    public void getIntArray() {
        int[] array = new int[]{1, 2, 3};
        when(resources.getIntArray(RESOURCE_ID)).thenReturn(array);
        assertEquals(array, subject.getIntArray(RESOURCE_ID));
    }

    @Test
    public void getInteger() {
        int value = 20;
        when(resources.getInteger(RESOURCE_ID)).thenReturn(value);
        assertEquals(value, subject.getInteger(RESOURCE_ID));
    }

    @Test
    public void getLayout() {
        XmlResourceParser xmlResourceParser = mock(XmlResourceParser.class);
        when(resources.getLayout(RESOURCE_ID)).thenReturn(xmlResourceParser);
        assertEquals(xmlResourceParser, subject.getLayout(RESOURCE_ID));
    }

    @Test
    public void getMovie() {
        Movie movie = mock(Movie.class);
        when(resources.getMovie(RESOURCE_ID)).thenReturn(movie);
        assertEquals(movie, subject.getMovie(RESOURCE_ID));
    }

    @Test
    public void getQuantityString() {
        String string = "string";
        int quantity = 10;
        when(resources.getQuantityString(RESOURCE_ID, quantity)).thenReturn(string);
        assertEquals(string, subject.getQuantityString(RESOURCE_ID, quantity));
    }

    @Test
    public void getQuantityString_withArgs() {
        String string = "string";
        int quantity = 10;
        when(resources.getQuantityString(RESOURCE_ID, quantity, "1", "2", "3")).thenReturn(string);
        assertEquals(string, subject.getQuantityString(RESOURCE_ID, quantity, "1", "2", "3"));
    }

    @Test
    public void getQuantityText() {
        CharSequence text = "text";
        int quantity = 5;
        when(resources.getQuantityText(RESOURCE_ID, quantity)).thenReturn(text);
        assertEquals(text, subject.getQuantityText(RESOURCE_ID, quantity));
    }

    @Test
    public void getResourceEntryName() {
        String name = "name";
        when(resources.getResourceEntryName(RESOURCE_ID)).thenReturn(name);
        assertEquals(name, subject.getResourceEntryName(RESOURCE_ID));
    }

    @Test
    public void getResourceName() {
        String name = "name";
        when(resources.getResourceName(RESOURCE_ID)).thenReturn(name);
        assertEquals(name, subject.getResourceName(RESOURCE_ID));
    }

    @Test
    public void getResourcePackageName() {
        String packageName = "packageName";
        when(resources.getResourcePackageName(RESOURCE_ID)).thenReturn(packageName);
        assertEquals(packageName, subject.getResourcePackageName(RESOURCE_ID));
    }

    @Test
    public void getResourceTypeName() {
        String type = "type";
        when(resources.getResourceTypeName(RESOURCE_ID)).thenReturn(type);
        assertEquals(type, subject.getResourceTypeName(RESOURCE_ID));
    }

    @Test
    public void getString() {
        String string = "string";
        when(resources.getString(RESOURCE_ID)).thenReturn(string);
        assertEquals(string, subject.getString(RESOURCE_ID));
    }

    @Test
    public void getString_withArgs() {
        String string = "string";
        when(resources.getString(RESOURCE_ID, "1", "2")).thenReturn(string);
        assertEquals(string, subject.getString(RESOURCE_ID, "1", "2"));
    }

    @Test
    public void getStringArray() {
        String[] array = new String[]{"1", "2", "3"};
        when(resources.getStringArray(RESOURCE_ID)).thenReturn(array);
        assertArrayEquals(array, subject.getStringArray(RESOURCE_ID));
    }

    @Test
    public void getText() {
        CharSequence text = "text";
        when(resources.getText(RESOURCE_ID)).thenReturn(text);
        assertEquals(text, subject.getText(RESOURCE_ID));
    }

    @Test
    public void getText_withDefaults() {
        CharSequence text = "text";
        CharSequence defaultValue = "defaultValue";
        when(resources.getText(RESOURCE_ID, defaultValue)).thenReturn(text);
        assertEquals(text, subject.getText(RESOURCE_ID, defaultValue));
    }

    @Test
    public void getTextArray() {
        CharSequence[] textArray = new CharSequence[]{"1", "2", "3"};
        when(resources.getTextArray(RESOURCE_ID)).thenReturn(textArray);
        assertArrayEquals(textArray, subject.getTextArray(RESOURCE_ID));
    }

    @Test
    public void getValue_resourceId() {
        TypedValue typedValue = mock(TypedValue.class);
        subject.getValue(RESOURCE_ID, typedValue, true);
        verify(resources).getValue(RESOURCE_ID, typedValue, true);
    }

    @Test
    public void getValue_name() {
        String name = "name";
        TypedValue typedValue = mock(TypedValue.class);
        subject.getValue(name, typedValue, true);
        verify(resources).getValue(name, typedValue, true);
    }

    @Test
    public void getValueForDensity() {
        int density = 5;
        TypedValue typedValue = mock(TypedValue.class);
        subject.getValueForDensity(RESOURCE_ID, density, typedValue, true);
        verify(resources).getValueForDensity(RESOURCE_ID, density, typedValue, true);
    }

    @Test
    public void getXml() {
        XmlResourceParser xmlResourceParser = mock(XmlResourceParser.class);
        when(resources.getXml(RESOURCE_ID)).thenReturn(xmlResourceParser);
        assertEquals(xmlResourceParser, subject.getXml(RESOURCE_ID));
    }

    @Test
    public void newTheme() {
        Resources.Theme theme = mock(Resources.Theme.class);
        when(resources.newTheme()).thenReturn(theme);
        assertEquals(theme, subject.newTheme());
    }

    @Test
    public void obtainAttributes() {
        TypedArray typedArray = mock(TypedArray.class);
        AttributeSet attributeSet = mock(AttributeSet.class);
        int[] styleRes = new int[]{1, 2, 3};
        when(resources.obtainAttributes(attributeSet, styleRes)).thenReturn(typedArray);
        assertEquals(typedArray, subject.obtainAttributes(attributeSet, styleRes));
    }

    @Test
    public void obtainTypedArray() {
        TypedArray typedArray = mock(TypedArray.class);
        when(resources.obtainTypedArray(RESOURCE_ID)).thenReturn(typedArray);
        assertEquals(typedArray, subject.obtainTypedArray(RESOURCE_ID));
    }

    @Test
    public void openRawResource() {
        InputStream inputStream = mock(InputStream.class);
        when(resources.openRawResource(RESOURCE_ID)).thenReturn(inputStream);
        assertEquals(inputStream, subject.openRawResource(RESOURCE_ID));
    }

    @Test
    public void openRawResource_withTypedValue() {
        InputStream inputStream = mock(InputStream.class);
        TypedValue typedValue = mock(TypedValue.class);
        when(resources.openRawResource(RESOURCE_ID, typedValue)).thenReturn(inputStream);
        assertEquals(inputStream, subject.openRawResource(RESOURCE_ID, typedValue));
    }

    @Test
    public void openRawResourceFd() {
        AssetFileDescriptor assetFileDescriptor = mock(AssetFileDescriptor.class);
        when(resources.openRawResourceFd(RESOURCE_ID)).thenReturn(assetFileDescriptor);
        assertEquals(assetFileDescriptor, subject.openRawResourceFd(RESOURCE_ID));
    }

    @Test
    public void parseBundleExtras() throws IOException, XmlPullParserException {
        XmlResourceParser xmlResourceParser = mock(XmlResourceParser.class);
        Bundle bundle = mock(Bundle.class);
        subject.parseBundleExtras(xmlResourceParser, bundle);
        verify(resources).parseBundleExtras(xmlResourceParser, bundle);
    }

    @Test
    public void parseBundleExtra() throws XmlPullParserException {
        String tag = "tag";
        AttributeSet attributeSet = mock(AttributeSet.class);
        Bundle bundle = mock(Bundle.class);
        subject.parseBundleExtra(tag, attributeSet, bundle);
        verify(resources).parseBundleExtra(tag, attributeSet, bundle);
    }

    @Test
    public void updateConfiguration() {
        Configuration configuration = mock(Configuration.class);
        DisplayMetrics displayMetrics = mock(DisplayMetrics.class);
        subject.updateConfiguration(configuration, displayMetrics);
        verify(resources).updateConfiguration(configuration, displayMetrics);
    }
}