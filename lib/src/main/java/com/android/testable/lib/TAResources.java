package com.android.testable.lib;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import androidx.annotation.AnyRes;
import androidx.annotation.ArrayRes;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FontRes;
import androidx.annotation.FractionRes;
import androidx.annotation.IntegerRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;
import androidx.annotation.Px;
import androidx.annotation.RawRes;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.annotation.StyleableRes;
import androidx.annotation.XmlRes;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;

public class TAResources {

    private final Resources resources;
    private final Context context;

    public TAResources(@NonNull Context context) {
        this.context = context.getApplicationContext();
        this.resources = this.context.getResources();
    }

    /**
     * Invokes {@link Resources#finishPreloading()}
     */
    public void finishPreloading() {
        resources.finishPreloading();
    }

    /**
     * Invokes {@link Resources#flushLayoutCache()}
     */
    public void flushLayoutCache() {
        resources.flushLayoutCache();
    }

    /**
     * Invokes {@link Resources#getAnimation(int)}
     *
     * @param resourceId the resource id of the desired animation
     * @return the xml resource parser
     */
    @NonNull
    public XmlResourceParser getAnimation(@AnimRes @AnimatorRes int resourceId) {
        return resources.getAnimation(resourceId);
    }

    /**
     * Invokes {@link Resources#getAssets()}
     *
     * @return the asset manager
     */
    @NonNull
    public AssetManager getAssets() {
        return resources.getAssets();
    }

    /**
     * Invokes {@link Resources#getBoolean(int)}
     *
     * @param resourceId the resource identifier pointing to a boolean
     * @return the boolean value of the resource
     */
    public boolean getBoolean(@BoolRes int resourceId) {
        return resources.getBoolean(resourceId);
    }

    /**
     * Invokes {@link Resources#getColor(int)}
     *
     * @param resourceId the resource identifier pointing to a color
     * @return the desired color
     */
    @Deprecated
    @ColorInt
    public int getColor(@ColorRes int resourceId) {
        return resources.getColor(resourceId);
    }

    /**
     * Invokes {@link Resources#getColor(int, Resources.Theme)}
     *
     * @param resourceId the resource identifier pointing to a color
     * @param theme      the theme used to style the color attribute
     * @return the desired color
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    @ColorInt
    public int getColor(@ColorRes int resourceId, Resources.Theme theme) {
        return resources.getColor(resourceId, theme);
    }

    /**
     * Invokes {@link ContextCompat#getColor(Context, int)}
     *
     * @param resourceId the resource identifier pointing to a color
     * @return the desired color
     */
    @ColorInt
    public int getColorCompat(@ColorRes int resourceId) {
        return ContextCompat.getColor(context, resourceId);
    }

    /**
     * Invokes {@link Resources#getColorStateList(int)}
     *
     * @param resourceId the resource identifier pointing to a color
     * @return the color state list
     */
    @Deprecated
    @NonNull
    public ColorStateList getColorStateList(@ColorRes int resourceId) {
        return resources.getColorStateList(resourceId);
    }

    /**
     * Invokes {@link Resources#getColorStateList(int, Resources.Theme)}
     *
     * @param resourceId the resource identifier pointing to a color
     * @return the color state list
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    @NonNull
    public ColorStateList getColorStateList(@ColorRes int resourceId, Resources.Theme theme) {
        return resources.getColorStateList(resourceId, theme);
    }

    /**
     * Invokes {@link ContextCompat#getColorStateList(Context, int)}
     *
     * @param resourceId the resource identifier pointing to a color
     * @return the color state list
     */
    @Nullable
    public ColorStateList getColorStateListCompat(@ColorRes int resourceId) {
        return ContextCompat.getColorStateList(context, resourceId);
    }

    /**
     * Invokes {@link Resources#getConfiguration()}
     *
     * @return the configuration of the device
     */
    @NonNull
    public Configuration getConfiguration() {
        return resources.getConfiguration();
    }

    /**
     * Invokes {@link Resources#getDimension(int)}
     *
     * @param resourceId the resource id of the dimension
     * @return the dimension in pixels
     */
    public float getDimension(@DimenRes int resourceId) {
        return resources.getDimension(resourceId);
    }

    /**
     * Invokes {@link Resources#getDimensionPixelOffset(int)}
     *
     * @param resourceId the resource id of the dimension
     * @return the dimension in pixels
     */
    @Px
    public int getDimensionPixelOffset(@DimenRes int resourceId) {
        return resources.getDimensionPixelOffset(resourceId);
    }

    /**
     * Invokes {@link Resources#getDimensionPixelSize(int)}
     *
     * @param resourceId the resource id of the dimension
     * @return the dimension in pixels
     */
    @Px
    public int getDimensionPixelSize(@DimenRes int resourceId) {
        return resources.getDimensionPixelSize(resourceId);
    }

    /**
     * Invokes {@link Resources#getDisplayMetrics()}
     *
     * @return the display metrics of the device
     */
    @NonNull
    public DisplayMetrics getDisplayMetrics() {
        return resources.getDisplayMetrics();
    }

    /**
     * Invokes {@link Resources#getDrawable(int)}
     *
     * @param resourceId the resource id of the drawable
     * @return the drawable resource
     */
    @Deprecated
    @NonNull
    public Drawable getDrawable(@DrawableRes int resourceId) {
        return resources.getDrawable(resourceId);
    }

    /**
     * Invokes {@link Resources#getDrawable(int, Resources.Theme)}
     *
     * @param resourceId the resource id of the drawable
     * @param theme      the theme used to style the drawable
     * @return the drawable resource
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @NonNull
    public Drawable getDrawable(@DrawableRes int resourceId, Resources.Theme theme) {
        return resources.getDrawable(resourceId, theme);
    }

    /**
     * Invokes {@link ContextCompat#getDrawable(Context, int)}
     *
     * @param resourceId the resource id of the drawable
     * @return the drawable resource
     */
    @Nullable
    public Drawable getDrawableCompat(@DrawableRes int resourceId) {
        return ContextCompat.getDrawable(context, resourceId);
    }

    /**
     * Invokes {@link Resources#getDrawableForDensity(int, int)}
     *
     * @param resourceId the resource id of the drawable
     * @param density    the desired density
     * @return the drawable resource
     */
    @Deprecated
    @Nullable
    public Drawable getDrawableForDensity(@DrawableRes int resourceId, int density) {
        return resources.getDrawableForDensity(resourceId, density);
    }

    /**
     * Invokes {@link Resources#getDrawableForDensity(int, int)}
     *
     * @param resourceId the resource id of the drawable
     * @param density    the desired density
     * @param theme      the theme used to style the drawable
     * @return the drawable resource
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    public Drawable getDrawableForDensity(@DrawableRes int resourceId, int density, Resources.Theme theme) {
        return resources.getDrawableForDensity(resourceId, density, theme);
    }

    /**
     * Invokes {@link ResourcesCompat#getDrawableForDensity(Resources, int, int, Resources.Theme)}
     *
     * @param resourceId the resource id of the drawable
     * @param density    the desired density
     * @param theme      the theme used to style the drawable
     * @return the drawable resource
     */
    @Nullable
    public Drawable getDrawableForDensityCompat(@DrawableRes int resourceId, int density, @Nullable Resources.Theme theme) {
        return ResourcesCompat.getDrawableForDensity(resources, resourceId, density, theme);
    }

    /**
     * Invokes {@link Resources#getFont(int)}
     *
     * @param resourceId the resource id of the font
     * @return the typeface associated with the font
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    @NonNull
    public Typeface getFont(@FontRes int resourceId) {
        return resources.getFont(resourceId);
    }

    /**
     * Invokes {@link ResourcesCompat#getFont(Context, int)}
     *
     * @param resourceId the resource id of the font
     * @return the typeface associated with the font
     */
    @Nullable
    public Typeface getFontCompat(@FontRes int resourceId) {
        return ResourcesCompat.getFont(context, resourceId);
    }

    /**
     * Invokes {@link Resources#getFraction(int, int, int)}
     *
     * @param resourceId the resource id of the fraction
     * @param base       the number to multiply the standard fraction
     * @param pBase      the number to multiply the parent fraction
     * @return the fraction value multiplied by the base values
     */
    public float getFraction(@FractionRes int resourceId, int base, int pBase) {
        return resources.getFraction(resourceId, base, pBase);
    }

    /**
     * Invokes {@link Resources#getIdentifier(String, String, String)}
     *
     * @param name       the name of the resource
     * @param type       the type of the resource
     * @param defPackage the package of the resource
     * @return the resource id or 0 if not found
     */
    @AnyRes
    public int getIdentifier(String name, String type, String defPackage) {
        return resources.getIdentifier(name, type, defPackage);
    }

    /**
     * Invokes {@link Resources#getIntArray(int)}
     *
     * @param resourceId the resource id of the integer array
     * @return the integer array
     */
    public int[] getIntArray(@ArrayRes int resourceId) {
        return resources.getIntArray(resourceId);
    }

    /**
     * Invokes {@link Resources#getInteger(int)}
     *
     * @param resourceId the resource id of the integer
     * @return the integer associated with the resource id
     */
    public int getInteger(@IntegerRes int resourceId) {
        return resources.getInteger(resourceId);
    }

    /**
     * Invokes {@link Resources#getLayout(int)}
     *
     * @param resourceId the resource id associated with the layout
     * @return the XML parser of the representing the layout
     */
    @NonNull
    public XmlResourceParser getLayout(@LayoutRes int resourceId) {
        return resources.getLayout(resourceId);
    }

    /**
     * Invokes {@link Resources#getMovie(int)}
     *
     * @param resourceId the resource id of the movie
     * @return the movie associated with the resource id
     */
    public Movie getMovie(@RawRes int resourceId) {
        return resources.getMovie(resourceId);
    }

    /**
     * Invokes {@link Resources#getQuantityString(int, int)}
     *
     * @param resourceId the resource id of the string
     * @param quantity   the desired quantity
     * @return the formatted string with the quantities
     */
    public String getQuantityString(@PluralsRes int resourceId, int quantity) {
        return resources.getQuantityString(resourceId, quantity);
    }

    /**
     * Invokes {@link Resources#getQuantityString(int, int, Object...)}
     *
     * @param resourceId the resource id of the string
     * @param quantity   the desired quantity
     * @param args       the string formatting arguments
     * @return the formatted string with the quantities
     */
    public String getQuantityString(@PluralsRes int resourceId, int quantity, Object... args) {
        return resources.getQuantityString(resourceId, quantity, (Object[]) args);
    }

    /**
     * Invokes {@link Resources#getQuantityText(int, int)}
     *
     * @param resourceId the resource id of the string
     * @param quantity   the desired quantity
     * @return the styled text with the quantities
     */
    public CharSequence getQuantityText(@PluralsRes int resourceId, int quantity) {
        return resources.getQuantityText(resourceId, quantity);
    }

    /**
     * Invokes {@link Resources#getResourceEntryName(int)}
     *
     * @param resourceId any resource id
     * @return the entry name of the resource
     */
    public String getResourceEntryName(@AnyRes int resourceId) {
        return resources.getResourceEntryName(resourceId);
    }

    /**
     * Invokes {@link Resources#getResourceName(int)}
     *
     * @param resourceId any resource id
     * @return the full name of the resource
     */
    public String getResourceName(@AnyRes int resourceId) {
        return resources.getResourceName(resourceId);
    }

    /**
     * Invokes {@link Resources#getResourcePackageName(int)}
     *
     * @param resourceId any resource id
     * @return the package name of the resource
     */
    public String getResourcePackageName(@AnyRes int resourceId) {
        return resources.getResourcePackageName(resourceId);
    }

    /**
     * Invokes {@link Resources#getResourceTypeName(int)}
     *
     * @param resourceId any resource id
     * @return the type of the resource
     */
    public String getResourceTypeName(@AnyRes int resourceId) {
        return resources.getResourceTypeName(resourceId);
    }

    /**
     * Invokes {@link Resources#getString(int)}
     *
     * @param resourceId the resource id of the string
     * @return the string associated with the resource id
     */
    @NonNull
    public String getString(@StringRes int resourceId) {
        return resources.getString(resourceId);
    }

    /**
     * Invokes {@link Resources#getString(int, Object...)}
     *
     * @param resourceId the resource id of the string
     * @param args       the arguments to be formatted in the string
     * @return the formatted string associated with the resource id
     */
    @NonNull
    public String getString(@StringRes int resourceId, Object... args) {
        return resources.getString(resourceId, args);
    }

    /**
     * Invokes {@link Resources#getStringArray(int)}
     *
     * @param resourceId the resource id of the string array
     * @return the string array associated with the resource id
     */
    @NonNull
    public String[] getStringArray(@ArrayRes int resourceId) {
        return resources.getStringArray(resourceId);
    }

    /**
     * Invokes {@link Resources#getText(int)}
     *
     * @param resourceId the resource id of the string
     * @return the styled text associated with the resource id
     */
    @NonNull
    public CharSequence getText(@StringRes int resourceId) {
        return resources.getText(resourceId);
    }

    /**
     * Invokes {@link Resources#getText(int, CharSequence)}
     *
     * @param resourceId the resource id of the string
     * @param def        the default value to be returned
     * @return the styled text associated with the resource id
     */
    @NonNull
    public CharSequence getText(@StringRes int resourceId, CharSequence def) {
        return resources.getText(resourceId, def);
    }

    /**
     * Invokes {@link Resources#getTextArray(int)}
     *
     * @param resourceId the resource id of the string array
     * @return the styled text array associated with the resource id
     */
    @NonNull
    public CharSequence[] getTextArray(@ArrayRes int resourceId) {
        return resources.getTextArray(resourceId);
    }

    /**
     * Invokes {@link Resources#getValue(int, TypedValue, boolean)}
     *
     * @param resourceId  the resource id to be obtained
     * @param outValue    the value in which the output will be set
     * @param resolveRefs if set to true it will follow the references of resources until it reaches the actual value
     *                    otherwise it will set the reference
     */
    public void getValue(@AnyRes int resourceId, @NonNull TypedValue outValue, boolean resolveRefs) {
        resources.getValue(resourceId, outValue, resolveRefs);
    }

    /**
     * Invokes {@link Resources#getValue(String, TypedValue, boolean)}
     *
     * @param name        the name of the resource
     * @param outValue    the value in which the output will be set
     * @param resolveRefs if set to true it will follow the references of resources until it reaches the actual value
     *                    otherwise it will set the reference
     */
    public void getValue(String name, @NonNull TypedValue outValue, boolean resolveRefs) {
        resources.getValue(name, outValue, resolveRefs);
    }

    /**
     * Invokes {@link Resources#getValueForDensity(int, int, TypedValue, boolean)}
     *
     * @param resourceId  the resource id to be obtained
     * @param density     the desired density
     * @param outValue    the value in which the output will be set
     * @param resolveRefs if set to true it will follow the references of resources until it reaches the actual value
     *                    otherwise it will set the reference
     */
    public void getValueForDensity(@AnyRes int resourceId, int density, @NonNull TypedValue outValue, boolean resolveRefs) {
        resources.getValueForDensity(resourceId, density, outValue, resolveRefs);
    }


    /**
     * Invokes {@link Resources#getXml(int)}
     *
     * @param resourceId the resource id of the desired XML file
     * @return the XML parser
     */
    @NonNull
    public XmlResourceParser getXml(@XmlRes int resourceId) {
        return resources.getXml(resourceId);
    }

    /**
     * Invokes {@link Resources#newTheme()}
     *
     * @return a new generated theme
     */
    @NonNull
    public Resources.Theme newTheme() {
        return resources.newTheme();
    }

    /**
     * Invokes {@link Resources#obtainAttributes(AttributeSet, int[])}
     *
     * @param attributeSet the current attributes to be retrieved
     * @param attrs        the specific attributes to be retrieved in ascending order
     * @return a typed array containing the values that must be recycled
     */
    @NonNull
    public TypedArray obtainAttributes(AttributeSet attributeSet, @StyleableRes int[] attrs) {
        return resources.obtainAttributes(attributeSet, attrs);
    }

    /**
     * Invokes {@link Resources#obtainTypedArray(int)}
     *
     * @param resourceId the resource id of the array to be retrieved
     * @return a typed array containing the values that must be recycled
     */
    @NonNull
    public TypedArray obtainTypedArray(@ArrayRes int resourceId) {
        return resources.obtainTypedArray(resourceId);
    }

    /**
     * Invokes {@link Resources#openRawResource(int)}
     *
     * @param resourceId the resource id of the raw data
     * @return the input stream associated with the raw data
     */
    @NonNull
    public InputStream openRawResource(@RawRes int resourceId) {
        return resources.openRawResource(resourceId);
    }

    /**
     * Invokes {@link Resources#openRawResource(int, TypedValue)}
     *
     * @param resourceId the resource id of the raw data
     * @param typedValue the value that holds the resource information
     * @return the input stream associated with the raw data
     */
    @NonNull
    public InputStream openRawResource(@RawRes int resourceId, TypedValue typedValue) {
        return resources.openRawResource(resourceId, typedValue);
    }

    /**
     * Invokes {@link Resources#openRawResourceFd(int)}
     *
     * @param resourceId the resource id of the raw data
     * @return the file descriptor associated with the raw data
     */
    @NonNull
    public AssetFileDescriptor openRawResourceFd(@RawRes int resourceId) {
        return resources.openRawResourceFd(resourceId);
    }

    /**
     * Invokes {@link Resources#parseBundleExtra(String, AttributeSet, Bundle)}
     *
     * @param tagName   the tag name used in error reporting
     * @param attrs     the attribute values to be extracted
     * @param outBundle the bundle in which the values should be saved
     */
    public void parseBundleExtra(String tagName, AttributeSet attrs, Bundle outBundle) throws XmlPullParserException {
        resources.parseBundleExtra(tagName, attrs, outBundle);
    }

    /**
     * Invokes {@link Resources#parseBundleExtras(XmlResourceParser, Bundle)}
     *
     * @param parser    the parser containing the XML to be extracted
     * @param outBundle the bundle in which the values should be saved
     */
    public void parseBundleExtras(XmlResourceParser parser, Bundle outBundle) throws IOException, XmlPullParserException {
        resources.parseBundleExtras(parser, outBundle);
    }

    /**
     * Invokes {@link Resources#updateConfiguration(Configuration, DisplayMetrics)}
     *
     * @param config  stores the updated configuration
     * @param metrics the display metrics of the device
     */
    @Deprecated
    public void updateConfiguration(Configuration config, DisplayMetrics metrics) {
        resources.updateConfiguration(config, metrics);
    }
}
