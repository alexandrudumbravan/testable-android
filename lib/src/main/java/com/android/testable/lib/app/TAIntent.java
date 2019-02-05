package com.android.testable.lib.app;

import android.content.*;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.android.testable.lib.os.TABundle;

import java.util.Set;

public class TAIntent implements TAIntentActions, TAIntentCategories, TAIntentExtras, TAIntentFlags,
        Parcelable, Cloneable {

    @NonNull
    public final Intent intent;

    public TAIntent() {
        this(new Intent());
    }

    public TAIntent(@NonNull TAIntent taIntent) {
        this(new Intent(taIntent.intent));
    }

    public TAIntent(@NonNull String action) {
        this(new Intent(action));
    }

    public TAIntent(@NonNull String action, @NonNull TAUri taUri) {
        this(new Intent(action, taUri.uri));
    }

    public TAIntent(@NonNull Context context, @NonNull Class<?> activityClass) {
        this(new Intent(context, activityClass));
    }

    public TAIntent(@NonNull String action, @NonNull TAUri taUri, @NonNull Context context, @NonNull Class<?> activityClass) {
        this(new Intent(action, taUri.uri, context, activityClass));
    }

    public TAIntent(@Nullable Intent intent) {
        this.intent = intent == null ? new Intent() : intent;
    }

    protected TAIntent(Parcel in) {
        intent = in.readParcelable(Intent.class.getClassLoader());
    }

    /**
     * Invokes {@link Intent#addCategory(String)}
     *
     * @param category The desired category. This can be either one of the predefined Intent categories,
     *                 or a custom category in your own namespace.
     * @return the current intent
     */
    @NonNull
    public TAIntent addCategory(@NonNull String category) {
        this.intent.addCategory(category);
        return this;
    }

    /**
     * Invokes {@link Intent#addFlags(int)}
     *
     * @param flags one of constants in {@link TAIntentFlags}
     * @return the current intent
     */
    @NonNull
    public TAIntent addFlags(int flags) {
        this.intent.addFlags(flags);
        return this;
    }

    /**
     * Invokes {@link Intent#fillIn(Intent, int)}
     *
     * @param other Another Intent whose values are to be used to fill in the current one.
     * @param flags one of the fill in values in {@link TAIntentFlags}
     * @return a flag or combination of flags of the changed fields from {@link TAIntentFlags}
     */
    public int fillIn(@NonNull TAIntent other, int flags) {
        return this.intent.fillIn(other.intent, flags);
    }

    /**
     * Invokes {@link Intent#filterEquals(Intent)}
     *
     * @param other The other Intent to compare against.
     * @return true if action, data, type, class, and categories are the same.
     */
    public boolean filterEquals(@NonNull TAIntent other) {
        return this.intent.filterEquals(other.intent);
    }

    /**
     * Invokes {@link Intent#filterHashCode()}
     *
     * @return the hash value of the action, data, type, class, and categories.
     */
    public int filterHashCode() {
        return this.intent.filterHashCode();
    }

    /**
     * Invokes {@link Intent#getAction()}
     *
     * @return the action of this intent or null if none is specified.
     */
    @Nullable
    public String getAction() {
        return this.intent.getAction();
    }

    /**
     * Invokes {@link Intent#getCategories()}
     *
     * @return the set of all categories in the intent
     */
    @Nullable
    public Set<String> getCategories() {
        return this.intent.getCategories();
    }

    /**
     * Invokes {@link Intent#getClipData()}
     *
     * @return the clip data associated with the intent
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Nullable
    public ClipData getClipData() {
        return this.intent.getClipData();
    }

    /**
     * Invokes {@link Intent#getComponent()}
     *
     * @return the name of the application component to handle the intent.
     */
    @Nullable
    public ComponentName getComponent() {
        return this.intent.getComponent();
    }

    /**
     * Invokes {@link Intent#getData()}
     *
     * @return the URI of the data this intent is targeting or null.
     */
    @Nullable
    public TAUri getData() {
        Uri uri = this.intent.getData();
        if (uri != null) {
            return new TAUri(uri);
        }
        return null;
    }

    /**
     * Invokes {@link Intent#getDataString()}
     *
     * @return the string representation of the URI of the data this intent is targeting or null.
     */
    @Nullable
    public String getDataString() {
        return this.intent.getDataString();
    }

    /**
     * Invokes {@link Intent#getExtras()}
     *
     * @return the map of all extras previously added with putExtra(), or null if none have been added.
     */
    @Nullable
    public TABundle getExtras() {
        Bundle bundle = this.intent.getExtras();
        if (bundle != null) {
            return new TABundle(bundle);
        }
        return null;
    }

    /**
     * Invokes {@link Intent#getFlags()}
     *
     * @return the currently set flags.
     */
    public int getFlags() {
        return this.intent.getFlags();
    }

    /**
     * Invokes {@link Intent#getPackage()}
     *
     * @return the name of the application package for the Intent.
     */
    @Nullable
    public String getPackage() {
        return this.intent.getPackage();
    }

    /**
     * Invokes {@link Intent#getScheme()}
     *
     * @return the scheme of this intent.
     */
    @Nullable
    public String getScheme() {
        return this.intent.getScheme();
    }

    /**
     * Invokes {@link Intent#getSelector()}
     *
     * @return the specific selector associated with this ontent.
     */
    @Nullable
    public TAIntent getSelector() {
        Intent intent = this.intent.getSelector();
        if (intent != null) {
            return new TAIntent(intent);
        }
        return null;
    }

    /**
     * Invokes {@link Intent#getSourceBounds()}
     *
     * @return the bounds of the sender of this intent, in screen coordinates.
     */
    @Nullable
    public Rect getSourceBounds() {
        return this.intent.getSourceBounds();
    }

    /**
     * Invokes {@link Intent#getType()}
     *
     * @return If a type was manually set, it is returned; else null is returned.
     */
    @Nullable
    public String getType() {
        return this.intent.getType();
    }

    /**
     * Invokes {@link Intent#hasCategory(String)}
     *
     * @param category The category to check.
     * @return True if the intent contains the category, else false.
     */
    public boolean hasCategory(@NonNull String category) {
        return this.intent.hasCategory(category);
    }

    /**
     * Invokes {@link Intent#hasExtra(String)}
     *
     * @param name the extra's name
     * @return true if the given extra is present.
     */
    public boolean hasExtra(@NonNull String name) {
        return this.intent.hasExtra(name);
    }

    /**
     * Invokes {@link Intent#hasFileDescriptors()}
     *
     * @return true if the Intent contains a parcelled file descriptor.
     */
    public boolean hasFileDescriptors() {
        return this.intent.hasFileDescriptors();
    }

    /**
     * Invokes {@link Intent#putExtras(Intent)}
     *
     * @param src Contains the extras to copy.
     * @return the current intent
     */
    @NonNull
    public TAIntent putExtras(@NonNull TAIntent src) {
        this.intent.putExtras(src.intent);
        return this;
    }

    /**
     * Invokes {@link Intent#putExtras(Bundle)}
     *
     * @param taBundle The Bundle of extras to add to this intent.
     * @return the current intent
     */
    @NonNull
    public TAIntent putExtras(@NonNull TABundle taBundle) {
        this.intent.putExtras(taBundle.bundle);
        return this;
    }

    /**
     * Invokes {@link Intent#removeCategory(String)}
     *
     * @param category The category to remove.
     */
    public void removeCategory(@NonNull String category) {
        this.intent.removeCategory(category);
    }

    /**
     * Invokes {@link Intent#removeExtra(String)}
     *
     * @param extra The extra to remove.
     */
    public void removeExtra(@NonNull String extra) {
        this.intent.removeExtra(extra);
    }

    /**
     * Invokes {@link Intent#removeFlags(int)}
     *
     * @param flags The flags to remove.
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void removeFlags(int flags) {
        this.intent.removeFlags(flags);
    }

    /**
     * Invokes {@link Intent#replaceExtras(Intent)}
     *
     * @param src The intent from which the extras should be copied from
     */
    @NonNull
    public TAIntent replaceExtras(@NonNull TAIntent src) {
        return new TAIntent(this.intent.replaceExtras(src.intent));
    }

    /**
     * Invokes {@link Intent#replaceExtras(Bundle)}
     *
     * @param taBundle The new set of extras in the Intent
     */
    @NonNull
    public TAIntent replaceExtras(@NonNull TABundle taBundle) {
        return new TAIntent(this.intent.replaceExtras(taBundle.bundle));
    }

    /**
     * Invokes {@link Intent#resolveActivity(PackageManager)}
     *
     * @param pm The package manager with which to resolve the Intent.
     * @return Name of the component implementing an activity that can display the intent.
     */
    @Nullable
    public ComponentName resolveActivity(@NonNull PackageManager pm) {
        return this.intent.resolveActivity(pm);
    }

    /**
     * Invokes {@link Intent#resolveActivity(PackageManager)}
     *
     * @param pm    The package manager with which to resolve the Intent.
     * @param flags Addition information to retrieve
     * @return the activity info
     */
    @Nullable
    public ActivityInfo resolveActivityInfo(@NonNull PackageManager pm, int flags) {
        return this.intent.resolveActivityInfo(pm, flags);
    }

    /**
     * Invokes {@link Intent#resolveType(Context)}
     *
     * @param context
     * @return the MIME of the intent
     */
    @Nullable
    public String resolveType(@NonNull Context context) {
        return this.intent.resolveType(context);
    }

    /**
     * Invokes {@link Intent#resolveType(ContentResolver)}
     *
     * @param contentResolver
     * @return the MIME of the intent
     */
    @Nullable
    public String resolveType(@NonNull ContentResolver contentResolver) {
        return this.intent.resolveType(contentResolver);
    }

    /**
     * Invokes {@link Intent#resolveTypeIfNeeded(ContentResolver)}
     *
     * @param contentResolver
     * @return the MIME of the intent
     */
    @Nullable
    public String resolveTypeIfNeeded(@NonNull ContentResolver contentResolver) {
        return this.intent.resolveTypeIfNeeded(contentResolver);
    }

    /**
     * Invokes {@link Intent#resolveTypeIfNeeded(ContentResolver)}
     *
     * @param action An action name, such as ACTION_VIEW. Application-specific actions should be prefixed with the
     *               vendor's package name.
     * @return the current intent
     */
    @NonNull
    public TAIntent setAction(@NonNull String action) {
        this.intent.setAction(action);
        return this;
    }

    /**
     * Invokes {@link Intent#setClass(Context, Class)}
     *
     * @param packageContext A Context of the application package implementing this class
     * @param cls            The class name to set
     * @return the current intent
     */
    @NonNull
    public TAIntent setClass(@NonNull Context packageContext, @NonNull Class<?> cls) {
        this.intent.setClass(packageContext, cls);
        return this;
    }

    /**
     * Invokes {@link Intent#setClassName(String, String)}
     *
     * @param packageName The name of the package implementing the desired component
     * @param className   The name of a class inside of the application package that will be used as
     *                    the component for this Intent
     * @return the current intent
     */
    @NonNull
    public TAIntent setClassName(@NonNull String packageName, @NonNull String className) {
        this.intent.setClassName(packageName, className);
        return this;
    }

    /**
     * Invokes {@link Intent#setClassName(Context, String)}
     *
     * @param packageContext A Context of the application package implementing this class
     * @param className      The name of a class inside of the application package that will be used as
     *                       the component for this Intent
     * @return the current intent
     */
    @NonNull
    public TAIntent setClassName(@NonNull Context packageContext, @NonNull String className) {
        this.intent.setClassName(packageContext, className);
        return this;
    }

    /**
     * Invokes {@link Intent#setClipData(ClipData)}
     *
     * @param clip The new clip to set. May be null to clear the current clip.
     * @return the current intent
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @NonNull
    public TAIntent setClipData(@Nullable ClipData clip) {
        this.intent.setClipData(clip);
        return this;
    }

    /**
     * Invokes {@link Intent#setComponent(ComponentName)}
     *
     * @param component The name of the application component to handle the intent, or null to let the system find
     *                  one for you.
     * @return the current intent
     */
    @NonNull
    public TAIntent setComponent(@Nullable ComponentName component) {
        this.intent.setComponent(component);
        return this;
    }

    /**
     * Invokes {@link Intent#setData(Uri)}
     *
     * @param data The Uri of the data this intent is now targeting
     * @return the current intent
     */
    @NonNull
    public TAIntent setData(@Nullable TAUri data) {
        this.intent.setData(data == null ? null : data.uri);
        return this;
    }

    /**
     * Invokes {@link Intent#setDataAndNormalize (Uri)}
     *
     * @param data The Uri of the data this intent is now targeting
     * @return the current intent
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @NonNull
    public TAIntent setDataAndNormalize(@NonNull TAUri data) {
        this.intent.setDataAndNormalize(data.uri);
        return this;
    }

    /**
     * Invokes {@link Intent#setDataAndType(Uri, String)}
     *
     * @param data The Uri of the data this intent is now targeting
     * @param type The MIME type of the data being handled by this intent
     * @return the current intent
     */
    @NonNull
    public TAIntent setDataAndType(@Nullable TAUri data, @Nullable String type) {
        this.intent.setDataAndType(data == null ? null : data.uri, type);
        return this;
    }

    /**
     * Invokes {@link Intent#setDataAndTypeAndNormalize(Uri, String)}
     *
     * @param data The Uri of the data this intent is now targeting
     * @param type The MIME type of the data being handled by this intent
     * @return the current intent
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @NonNull
    public TAIntent setDataAndTypeAndNormalize(@NonNull TAUri data, @Nullable String type) {
        this.intent.setDataAndTypeAndNormalize(data.uri, type);
        return this;
    }

    /**
     * Invokes {@link Intent#setDataAndType(Uri, String)}
     *
     * @param loader a ClassLoader, or null to use the default loader at the time of unmarshalling
     */
    public void setExtrasClassLoader(ClassLoader loader) {
        this.intent.setExtrasClassLoader(loader);
    }

    /**
     * Invokes {@link Intent#setFlags(int)}
     *
     * @param flags The desired flags
     * @return the current intent
     */
    @NonNull
    public TAIntent setFlags(int flags) {
        this.intent.setFlags(flags);
        return this;
    }

    /**
     * Invokes {@link Intent#setPackage(String)}
     *
     * @param packageName The name of the application package to handle the intent, or null to allow any application package.
     * @return the current intent
     */
    @NonNull
    public TAIntent setPackage(@Nullable String packageName) {
        this.intent.setPackage(packageName);
        return this;
    }

    /**
     * Invokes {@link Intent#setSelector(Intent)}
     *
     * @param selector The desired selector Intent; set to null to not use a special selector.
     */
    public void setSelector(@Nullable TAIntent selector) {
        this.intent.setSelector(selector.intent);
    }

    /**
     * Invokes {@link Intent#setSourceBounds (Rect)}
     *
     * @param rect the bounds of the source
     */
    public void setSourceBounds(@Nullable Rect rect) {
        this.intent.setSourceBounds(rect);
    }

    /**
     * Invokes {@link Intent#setType(String)}
     *
     * @param type The MIME type of the data being handled by this intent.
     * @return the current intent
     */
    @NonNull
    public TAIntent setType(@Nullable String type) {
        this.intent.setType(type);
        return this;
    }

    /**
     * Invokes {@link Intent#setTypeAndNormalize(String)}
     *
     * @param type The MIME type of the data being handled by this intent.
     * @return the current intent
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @NonNull
    public TAIntent setTypeAndNormalize(@Nullable String type) {
        this.intent.setTypeAndNormalize(type);
        return this;
    }

    /**
     * Invokes {@link Intent#toString()}
     *
     * @return the string representation
     */
    @NonNull
    @Override
    public String toString() {
        return intent.toString();
    }

    /**
     * Invokes {@link Intent#toUri(int)}
     *
     * @param flags Additional operating flags.
     * @return Returns a URI encoding URI string describing the entire contents of the Intent.
     */
    @NonNull
    public String toUri(int flags) {
        return this.intent.toUri(flags);
    }

    @Override
    public int describeContents() {
        return intent.describeContents();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(intent, flags);
    }

    @Override
    protected Object clone() {
        return new TAIntent((Intent) this.intent.clone());
    }

    public static final Creator<TAIntent> CREATOR = new Creator<TAIntent>() {
        @Override
        public TAIntent createFromParcel(Parcel in) {
            return new TAIntent(in);
        }

        @Override
        public TAIntent[] newArray(int size) {
            return new TAIntent[size];
        }
    };
}
