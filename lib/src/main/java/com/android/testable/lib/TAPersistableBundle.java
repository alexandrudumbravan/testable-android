package com.android.testable.lib;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PersistableBundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.Set;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class TAPersistableBundle implements Parcelable {

    @NonNull
    public final PersistableBundle bundle;

    public TAPersistableBundle(@Nullable PersistableBundle bundle) {
        this.bundle = bundle == null ? new PersistableBundle() : bundle;
    }

    protected TAPersistableBundle(Parcel in) {
        PersistableBundle bundle = in.readPersistableBundle(getClass().getClassLoader());
        this.bundle = bundle == null ? new PersistableBundle() : bundle;
    }

    /**
     * Invokes {@link PersistableBundle#clear()}
     */
    public void clear() {
        bundle.clear();
    }

    /**
     * Invokes {@link PersistableBundle#isEmpty()}
     *
     * @return true if the bundle is empty or false otherwise
     */
    public boolean isEmpty() {
        return bundle.isEmpty();
    }

    /**
     * Invokes {@link PersistableBundle#keySet()}
     *
     * @return the set of keys in the bundle
     */
    public Set<String> keySet() {
        return bundle.keySet();
    }

    /**
     * Invokes {@link PersistableBundle#remove(String)}
     *
     * @param key the key which will be used to store the string array list
     */
    public void remove(@Nullable String key) {
        bundle.remove(key);
    }

    /**
     * Invokes {@link PersistableBundle#size()}
     *
     * @return the size of the bundle
     */
    public int size() {
        return bundle.size();
    }

    /**
     * Invokes {@link PersistableBundle#get(String)}
     *
     * @param key the key used to store the object
     * @return the object associated with the key
     */
    @Nullable
    public Object get(@Nullable String key) {
        return bundle.get(key);
    }

    /**
     * Invokes {@link PersistableBundle#getBoolean(String)}
     *
     * @param key the key used to store the boolean
     * @return the boolean associated with the key or false otherwise
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    public boolean getBoolean(@Nullable String key) {
        return bundle.getBoolean(key);
    }

    /**
     * Invokes {@link PersistableBundle#getBoolean(String, boolean)}
     *
     * @param key          the key used to store the boolean
     * @param defaultValue the value to be returned in case the value cannot be retrieved
     * @return the boolean associated with the key or the default value otherwise
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    public boolean getBoolean(@Nullable String key, boolean defaultValue) {
        return bundle.getBoolean(key, defaultValue);
    }

    /**
     * Invokes {@link PersistableBundle#getBooleanArray(String)}
     *
     * @param key the key used to store the boolean array
     * @return the boolean array associated with the key or null otherwise
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    @Nullable
    public boolean[] getBooleanArray(@Nullable String key) {
        return bundle.getBooleanArray(key);
    }

    /**
     * Invokes {@link PersistableBundle#getDouble(String)}
     *
     * @param key the key used to store the double
     * @return the double associated with the key or 0.0
     */
    public double getDouble(@Nullable String key) {
        return bundle.getDouble(key);
    }

    /**
     * Invokes {@link PersistableBundle#getDouble(String, double)}
     *
     * @param key          the key used to store the double
     * @param defaultValue the default value to be used in case the value cannot be retrieved
     * @return the double associated with the key or the default value
     */
    public double getDouble(@Nullable String key, double defaultValue) {
        return bundle.getDouble(key, defaultValue);
    }

    /**
     * Invokes {@link PersistableBundle#getDoubleArray(String)}
     *
     * @param key the key used to store the double array
     * @return the double array associated with the key or null
     */
    @Nullable
    public double[] getDoubleArray(@Nullable String key) {
        return bundle.getDoubleArray(key);
    }

    /**
     * Invokes {@link PersistableBundle#getInt(String)}
     *
     * @param key the key used to store the int
     * @return the int associated with the key or 0
     */
    public int getInt(@Nullable String key) {
        return bundle.getInt(key);
    }

    /**
     * Invokes {@link PersistableBundle#getInt(String, int)}
     *
     * @param key          the key used to store the int
     * @param defaultValue the default value to be used in case the value cannot be retrieved
     * @return the int associated with the key or the default value
     */
    public int getInt(@Nullable String key, int defaultValue) {
        return bundle.getInt(key, defaultValue);
    }

    /**
     * Invokes {@link PersistableBundle#getIntArray(String)}
     *
     * @param key the key used to store the int array
     * @return the int associated with the key or null
     */
    @Nullable
    public int[] getIntArray(@Nullable String key) {
        return bundle.getIntArray(key);
    }

    /**
     * Invokes {@link PersistableBundle#getLong(String)}
     *
     * @param key the key used to store the long
     * @return the long associated with the key or 0
     */
    public long getLong(@Nullable String key) {
        return bundle.getLong(key);
    }

    /**
     * Invokes {@link PersistableBundle#getLong(String, long)}
     *
     * @param key          the key used to store the long
     * @param defaultValue the default value to be used in case the value cannot be retrieved
     * @return the long associated with the key or the default value
     */
    public long getLong(@Nullable String key, long defaultValue) {
        return bundle.getLong(key, defaultValue);
    }

    /**
     * Invokes {@link PersistableBundle#getLongArray(String)}
     *
     * @param key the key used to store the long array
     * @return the long array associated with the key or null
     */
    @Nullable
    public long[] getLongArray(@Nullable String key) {
        return bundle.getLongArray(key);
    }

    /**
     * Invokes {@link PersistableBundle#getString(String)}
     *
     * @param key the key used to store the String
     * @return the String associated with the key or null
     */
    @Nullable
    public String getString(@Nullable String key) {
        return bundle.getString(key);
    }

    /**
     * Invokes {@link PersistableBundle#getString(String, String)}
     *
     * @param key          the key used to store the String
     * @param defaultValue the default value to be used in case the value cannot be retrieved
     * @return the String associated with the key or the default value
     */
    @Nullable
    public String getString(@Nullable String key, @Nullable String defaultValue) {
        return bundle.getString(key, defaultValue);
    }

    /**
     * Invokes {@link PersistableBundle#getStringArray(String)}
     *
     * @param key the key used to store the String array
     * @return the String array associated with the key or null
     */
    @Nullable
    public String[] getStringArray(@Nullable String key) {
        return bundle.getStringArray(key);
    }

    /**
     * Invokes {@link PersistableBundle#getPersistableBundle(String)}
     *
     * @param key the key used to store the String array
     * @return the persistable bundle associated with the key or null
     */
    @Nullable
    public PersistableBundle getPersistableBundle(@Nullable String key) {
        return bundle.getPersistableBundle(key);
    }

    /**
     * Wraps the result of {@link PersistableBundle#getPersistableBundle(String)}
     *
     * @param key the key used for the persistable bundle
     * @return the wrapped persistable bundle or null otherwise
     */
    @Nullable
    public TAPersistableBundle getTAPersistableBundle(@Nullable String key) {
        PersistableBundle persistableBundle = bundle.getPersistableBundle(key);
        return persistableBundle != null ? new TAPersistableBundle(persistableBundle) : null;
    }

    /**
     * Invokes {@link PersistableBundle#putBoolean(String, boolean)}
     *
     * @param key   the key which will be used to store the boolean
     * @param value the value of the boolean
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    public void putBoolean(@Nullable String key, boolean value) {
        bundle.putBoolean(key, value);
    }

    /**
     * Invokes {@link PersistableBundle#putBooleanArray(String, boolean[])}
     *
     * @param key   the key which will be used to store the boolean array
     * @param value the value of the boolean array
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    public void putBooleanArray(@Nullable String key, @Nullable boolean[] value) {
        bundle.putBooleanArray(key, value);
    }

    /**
     * Invokes {@link PersistableBundle#putDouble(String, double)}
     *
     * @param key   the key which will be used to store the double
     * @param value the value of the double
     */
    public void putDouble(@Nullable String key, double value) {
        bundle.putDouble(key, value);
    }

    /**
     * Invokes {@link PersistableBundle#putDoubleArray(String, double[])}
     *
     * @param key   the key which will be used to store the double array
     * @param value the value of the double array
     */
    public void putDoubleArray(@Nullable String key, @Nullable double[] value) {
        bundle.putDoubleArray(key, value);
    }

    /**
     * Invokes {@link PersistableBundle#putInt(String, int)}
     *
     * @param key   the key which will be used to store the int
     * @param value the value of the int
     */
    public void putInt(@Nullable String key, int value) {
        bundle.putInt(key, value);
    }

    /**
     * Invokes {@link PersistableBundle#putIntArray(String, int[])}
     *
     * @param key   the key which will be used to store the int array
     * @param value the value of the int array
     */
    public void putIntArray(@Nullable String key, @Nullable int[] value) {
        bundle.putIntArray(key, value);
    }

    /**
     * Invokes {@link PersistableBundle#putLong(String, long)}
     *
     * @param key   the key which will be used to store the long
     * @param value the value of the long
     */
    public void putLong(@Nullable String key, long value) {
        bundle.putLong(key, value);
    }

    /**
     * Invokes {@link PersistableBundle#putLongArray(String, long[])}
     *
     * @param key   the key which will be used to store the long array
     * @param value the value of the long array
     */
    public void putLongArray(@Nullable String key, @Nullable long[] value) {
        bundle.putLongArray(key, value);
    }

    /**
     * Invokes {@link PersistableBundle#putString(String, String)}
     *
     * @param key   the key which will be used to store the string
     * @param value the value of the string
     */
    public void putString(@Nullable String key, @Nullable String value) {
        bundle.putString(key, value);
    }

    /**
     * Invokes {@link PersistableBundle#putStringArray(String, String[])}
     *
     * @param key   the key which will be used to store the string array
     * @param value the value of the string array
     */
    public void putStringArray(@Nullable String key, @Nullable String[] value) {
        bundle.putStringArray(key, value);
    }

    /**
     * Invokes {@link PersistableBundle#putPersistableBundle(String, PersistableBundle)}
     *
     * @param key   the key which will be used to store the persistable bundle
     * @param value the value of the persistable bundle
     */
    public void putPersistableBundle(@Nullable String key, @Nullable PersistableBundle value) {
        bundle.putPersistableBundle(key, value);
    }

    /**
     * Invokes {@link #putPersistableBundle(String, PersistableBundle)}
     *
     * @param key   the key which will be used to store the persistable bundle
     * @param value the value of the persistable bundle
     */
    public void putTAPersistableBundle(@Nullable String key, @Nullable TAPersistableBundle value) {
        if (value != null) {
            putPersistableBundle(key, value.bundle);
        }
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writePersistableBundle(bundle);
    }

    public static final Creator<TAPersistableBundle> CREATOR = new Creator<TAPersistableBundle>() {
        @Override
        public TAPersistableBundle createFromParcel(Parcel in) {
            return new TAPersistableBundle(in);
        }

        @Override
        public TAPersistableBundle[] newArray(int size) {
            return new TAPersistableBundle[size];
        }
    };
}
