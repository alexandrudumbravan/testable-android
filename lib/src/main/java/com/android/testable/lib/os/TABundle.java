package com.android.testable.lib.os;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.BundleCompat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

public class TABundle implements Parcelable {

    @NonNull
    public final Bundle bundle;

    public TABundle(@Nullable Bundle bundle) {
        this.bundle = bundle == null ? new Bundle() : bundle;
    }

    protected TABundle(Parcel in) {
        Bundle bundle = in.readBundle(getClass().getClassLoader());
        this.bundle = bundle == null ? new Bundle() : bundle;
    }

    /**
     * Invokes {@link Bundle#clear()}
     */
    public void clear() {
        bundle.clear();
    }

    /**
     * Invokes {@link Bundle#isEmpty()}
     *
     * @return true if the bundle is empty or false otherwise
     */
    public boolean isEmpty() {
        return bundle.isEmpty();
    }

    /**
     * Invokes {@link Bundle#keySet()}
     *
     * @return the set of keys in the bundle
     */
    public Set<String> keySet() {
        return bundle.keySet();
    }

    /**
     * Invokes {@link Bundle#remove(String)}
     *
     * @param key the key which will be used to store the string array list
     */
    public void remove(@Nullable String key) {
        bundle.remove(key);
    }

    /**
     * Invokes {@link Bundle#size()}
     *
     * @return the size of the bundle
     */
    public int size() {
        return bundle.size();
    }

    /**
     * Invokes {@link Bundle#get(String)}
     *
     * @param key the key used to store the object
     * @return the object associated with the key
     */
    @Nullable
    public Object get(@Nullable String key) {
        return bundle.get(key);
    }

    /**
     * Invokes {@link Bundle#getBoolean(String)}
     *
     * @param key the key used to store the boolean
     * @return the boolean associated with the key or false otherwise
     */
    public boolean getBoolean(@Nullable String key) {
        return bundle.getBoolean(key);
    }

    /**
     * Invokes {@link Bundle#getBoolean(String, boolean)}
     *
     * @param key          the key used to store the boolean
     * @param defaultValue the value to be returned in case the value cannot be retrieved
     * @return the boolean associated with the key or the default value otherwise
     */
    public boolean getBoolean(@Nullable String key, boolean defaultValue) {
        return bundle.getBoolean(key, defaultValue);
    }

    /**
     * Invokes {@link Bundle#getBooleanArray(String)}
     *
     * @param key the key used to store the boolean array
     * @return the boolean array associated with the key or null otherwise
     */
    @Nullable
    public boolean[] getBooleanArray(@Nullable String key) {
        return bundle.getBooleanArray(key);
    }

    /**
     * Invokes {@link Bundle#getDouble(String)}
     *
     * @param key the key used to store the double
     * @return the double associated with the key or 0.0
     */
    public double getDouble(@Nullable String key) {
        return bundle.getDouble(key);
    }

    /**
     * Invokes {@link Bundle#getDouble(String, double)}
     *
     * @param key          the key used to store the double
     * @param defaultValue the default value to be used in case the value cannot be retrieved
     * @return the double associated with the key or the default value
     */
    public double getDouble(@Nullable String key, double defaultValue) {
        return bundle.getDouble(key, defaultValue);
    }

    /**
     * Invokes {@link Bundle#getDoubleArray(String)}
     *
     * @param key the key used to store the double array
     * @return the double array associated with the key or null
     */
    @Nullable
    public double[] getDoubleArray(@Nullable String key) {
        return bundle.getDoubleArray(key);
    }

    /**
     * Invokes {@link Bundle#getInt(String)}
     *
     * @param key the key used to store the int
     * @return the int associated with the key or 0
     */
    public int getInt(@Nullable String key) {
        return bundle.getInt(key);
    }

    /**
     * Invokes {@link Bundle#getInt(String, int)}
     *
     * @param key          the key used to store the int
     * @param defaultValue the default value to be used in case the value cannot be retrieved
     * @return the int associated with the key or the default value
     */
    public int getInt(@Nullable String key, int defaultValue) {
        return bundle.getInt(key, defaultValue);
    }

    /**
     * Invokes {@link Bundle#getIntArray(String)}
     *
     * @param key the key used to store the int array
     * @return the int associated with the key or null
     */
    @Nullable
    public int[] getIntArray(@Nullable String key) {
        return bundle.getIntArray(key);
    }

    /**
     * Invokes {@link Bundle#getLong(String)}
     *
     * @param key the key used to store the long
     * @return the long associated with the key or 0
     */
    public long getLong(@Nullable String key) {
        return bundle.getLong(key);
    }

    /**
     * Invokes {@link Bundle#getLong(String, long)}
     *
     * @param key          the key used to store the long
     * @param defaultValue the default value to be used in case the value cannot be retrieved
     * @return the long associated with the key or the default value
     */
    public long getLong(@Nullable String key, long defaultValue) {
        return bundle.getLong(key, defaultValue);
    }

    /**
     * Invokes {@link Bundle#getLongArray(String)}
     *
     * @param key the key used to store the long array
     * @return the long array associated with the key or null
     */
    @Nullable
    public long[] getLongArray(@Nullable String key) {
        return bundle.getLongArray(key);
    }

    /**
     * Invokes {@link Bundle#getString(String)}
     *
     * @param key the key used to store the String
     * @return the String associated with the key or null
     */
    @Nullable
    public String getString(@Nullable String key) {
        return bundle.getString(key);
    }

    /**
     * Invokes {@link Bundle#getString(String, String)}
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
     * Invokes {@link Bundle#getStringArray(String)}
     *
     * @param key the key used to store the String array
     * @return the String array associated with the key or null
     */
    @Nullable
    public String[] getStringArray(@Nullable String key) {
        return bundle.getStringArray(key);
    }

    /**
     * Invokes {@link Bundle#getBinder(String)}
     *
     * @param key the key used to store the binder
     * @return the binder or null if it doesn't exist
     */
    @Nullable
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    public IBinder getBinder(@Nullable String key) {
        return bundle.getBinder(key);
    }

    /**
     * Invokes {@link BundleCompat#getBinder(Bundle, String)}
     *
     * @param key the key used to store the binder
     * @return the binder or null if it doesn't exist
     */
    @Nullable
    public IBinder getBinderCompat(@Nullable String key) {
        return BundleCompat.getBinder(bundle, key);
    }

    /**
     * Creates a new bundle based on a invocation to {@link Bundle#getBundle(String)}
     *
     * @param key the key used to store the bundle
     * @return the bundle or null if the bundle doesn't exist
     */
    @Nullable
    public TABundle getTABundle(@Nullable String key) {
        Bundle result = bundle.getBundle(key);
        return result != null ? new TABundle(result) : null;
    }

    /**
     * Invokes {@link Bundle#getBundle(String)}
     *
     * @param key the key used to store the bundle
     * @return the associated bundle or null otherwise
     */
    @Nullable
    public Bundle getBundle(@Nullable String key) {
        return bundle.getBundle(key);
    }

    /**
     * Invokes {@link Bundle#getByte(String)}
     *
     * @param key the key used to store the byte
     * @return the byte or 0 if it doesn't exist
     */
    public byte getByte(String key) {
        return bundle.getByte(key);
    }

    /**
     * Invokes {@link Bundle#getByte(String, byte)}
     *
     * @param key          the key used to store the byte
     * @param defaultValue the value to be returned in case the value cannot be retrieveds
     * @return the byte or the default value
     */
    public byte getByte(String key, byte defaultValue) {
        return bundle.getByte(key, defaultValue);
    }

    /**
     * Invokes {@link Bundle#getByteArray(String)}
     *
     * @param key the key used to store the byte array
     * @return the associated byte array or null
     */
    @Nullable
    public byte[] getByteArray(String key) {
        return bundle.getByteArray(key);
    }

    /**
     * Invokes {@link Bundle#getChar(String)}
     *
     * @param key the key used to char
     * @return the associated char or char 0
     */
    public char getChar(String key) {
        return bundle.getChar(key);
    }

    /**
     * Invokes {@link Bundle#getChar(String, char)}
     *
     * @param key          the key used to char
     * @param defaultValue the default value to be returned in case the value cannot be retrieved
     * @return the associated char or the default value
     */
    public char getChar(String key, char defaultValue) {
        return bundle.getChar(key, defaultValue);
    }

    /**
     * Invokes {@link Bundle#getCharArray(String)}
     *
     * @param key the key used to char array
     * @return the associated char array or null
     */
    @Nullable
    public char[] getCharArray(String key) {
        return bundle.getCharArray(key);
    }

    /**
     * Invoked {@link Bundle#getCharSequence(String)}
     *
     * @param key the key used to store the char sequence
     * @return the associated char sequence or null
     */
    @Nullable
    public CharSequence getCharSequence(String key) {
        return bundle.getCharSequence(key);
    }

    /**
     * Invoked {@link Bundle#getCharSequence(String, CharSequence)}
     *
     * @param key          the key used to store the char sequence
     * @param defaultValue the default value in case the value cannot be retrieved
     * @return the associated char sequence or the default value
     */
    @NonNull
    public CharSequence getCharSequence(String key, @NonNull CharSequence defaultValue) {
        return bundle.getCharSequence(key, defaultValue);
    }

    /**
     * Invokes {@link Bundle#getCharSequenceArray(String)}
     *
     * @param key the key used to char sequence array
     * @return the associated char sequence array or null
     */
    @Nullable
    public CharSequence[] getCharSequenceArray(String key) {
        return bundle.getCharSequenceArray(key);
    }

    /**
     * Invokes {@link Bundle#getCharSequenceArrayList(String)}
     *
     * @param key the key used to store the char sequence list
     * @return the associated list or null
     */
    @Nullable
    public ArrayList<CharSequence> getCharSequenceArrayList(String key) {
        return bundle.getCharSequenceArrayList(key);
    }

    /**
     * Invokes {@link Bundle#getFloat(String)}
     *
     * @param key the key used to store the float
     * @return the associated float or 0
     */
    public float getFloat(@Nullable String key) {
        return bundle.getFloat(key);
    }

    /**
     * Invokes {@link Bundle#getFloat(String, float)}
     *
     * @param key          the key used to store the float
     * @param defaultValue the default value in case the value cannot be retrieved
     * @return the associated float or the default value
     */
    public float getFloat(@Nullable String key, float defaultValue) {
        return bundle.getFloat(key, defaultValue);
    }

    /**
     * Invokes {@link Bundle#getFloatArray(String)}
     *
     * @param key the key used to store the float array
     * @return the associated float array or null
     */
    @Nullable
    public float[] getFloatArray(@Nullable String key) {
        return bundle.getFloatArray(key);
    }

    /**
     * Invokes {@link Bundle#getIntegerArrayList(String)}
     *
     * @param key the key used to store the integer array list
     * @return the integer array list or null
     */
    @Nullable
    public ArrayList<Integer> getIntegerArrayList(@Nullable String key) {
        return bundle.getIntegerArrayList(key);
    }

    /**
     * Invokes {@link Bundle#getParcelable(String)}
     *
     * @param key the key used to store the parcelable
     * @return the associated parcelable or null
     */
    @Nullable
    public <T extends Parcelable> T getParcelable(@Nullable String key) {
        return bundle.getParcelable(key);
    }

    /**
     * Invokes {@link Bundle#getParcelableArray(String)}
     *
     * @param key the key used to store the parcelable array
     * @return the parcelable array or null
     */
    @Nullable
    public Parcelable[] getParcelableArray(@Nullable String key) {
        return bundle.getParcelableArray(key);
    }

    /**
     * Invokes {@link Bundle#getParcelableArrayList(String)}
     *
     * @param key the key used to store the parcelable list
     * @return the parcelable array list or null
     */
    @Nullable
    public <T extends Parcelable> ArrayList<T> getParcelableArrayList(@Nullable String key) {
        return bundle.getParcelableArrayList(key);
    }

    /**
     * Invokes {@link Bundle#getSerializable(String)}
     *
     * @param key the key used to store the serializable
     * @return the serializable or null
     */
    @Nullable
    public Serializable getSerializable(@Nullable String key) {
        return bundle.getSerializable(key);
    }

    /**
     * Invokes {@link Bundle#getShort(String)}
     *
     * @param key the key used to store the short
     * @return the associated short or 0
     */
    public short getShort(@Nullable String key) {
        return bundle.getShort(key);
    }

    /**
     * Invokes {@link Bundle#getShort(String, short)}
     *
     * @param key          the key used to store the short
     * @param defaultValue the default value in case the value cannot be retrieved
     * @return the associated short or the default value
     */
    public short getShort(@Nullable String key, short defaultValue) {
        return bundle.getShort(key, defaultValue);
    }

    /**
     * Invokes {@link Bundle#getShortArray(String)}
     *
     * @param key the key used to store the short array
     * @return the associated short or null
     */
    @Nullable
    public short[] getShortArray(@Nullable String key) {
        return bundle.getShortArray(key);
    }

    /**
     * Invokes {@link Bundle#getSize(String)}
     *
     * @param key the key used to store the size
     * @return the associated size or null
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    public Size getSize(@Nullable String key) {
        return bundle.getSize(key);
    }

    /**
     * Invokes {@link Bundle#getSizeF(String)}
     *
     * @param key the key used to store the size
     * @return the associated size or null
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    public SizeF getSizeF(@Nullable String key) {
        return bundle.getSizeF(key);
    }

    /**
     * Invokes {@link Bundle#getSparseParcelableArray(String)}
     *
     * @param key the key used to store the sparse array
     * @return the associated sparse array or null
     */
    @Nullable
    public <T extends Parcelable> SparseArray<T> getSparseParcelableArray(@Nullable String key) {
        return bundle.getSparseParcelableArray(key);
    }

    /**
     * Invokes {@link Bundle#getStringArrayList(String)}
     *
     * @param key the key used to store the string list
     * @return the associated associated list or null
     */
    @Nullable
    public ArrayList<String> getStringArrayList(@Nullable String key) {
        return bundle.getStringArrayList(key);
    }

    /**
     * Invokes {@link Bundle#putBoolean(String, boolean)}
     *
     * @param key   the key which will be used to store the boolean
     * @param value the value of the boolean
     */
    public void putBoolean(@Nullable String key, boolean value) {
        bundle.putBoolean(key, value);
    }

    /**
     * Invokes {@link Bundle#putBooleanArray(String, boolean[])}
     *
     * @param key   the key which will be used to store the boolean array
     * @param value the value of the boolean array
     */
    public void putBooleanArray(@Nullable String key, @Nullable boolean[] value) {
        bundle.putBooleanArray(key, value);
    }

    /**
     * Invokes {@link Bundle#putDouble(String, double)}
     *
     * @param key   the key which will be used to store the double
     * @param value the value of the double
     */
    public void putDouble(@Nullable String key, double value) {
        bundle.putDouble(key, value);
    }

    /**
     * Invokes {@link Bundle#putDoubleArray(String, double[])}
     *
     * @param key   the key which will be used to store the double array
     * @param value the value of the double array
     */
    public void putDoubleArray(@Nullable String key, @Nullable double[] value) {
        bundle.putDoubleArray(key, value);
    }

    /**
     * Invokes {@link Bundle#putInt(String, int)}
     *
     * @param key   the key which will be used to store the int
     * @param value the value of the int
     */
    public void putInt(@Nullable String key, int value) {
        bundle.putInt(key, value);
    }

    /**
     * Invokes {@link Bundle#putIntArray(String, int[])}
     *
     * @param key   the key which will be used to store the int array
     * @param value the value of the int array
     */
    public void putIntArray(@Nullable String key, @Nullable int[] value) {
        bundle.putIntArray(key, value);
    }

    /**
     * Invokes {@link Bundle#putLong(String, long)}
     *
     * @param key   the key which will be used to store the long
     * @param value the value of the long
     */
    public void putLong(@Nullable String key, long value) {
        bundle.putLong(key, value);
    }

    /**
     * Invokes {@link Bundle#putLongArray(String, long[])}
     *
     * @param key   the key which will be used to store the long array
     * @param value the value of the long array
     */
    public void putLongArray(@Nullable String key, @Nullable long[] value) {
        bundle.putLongArray(key, value);
    }

    /**
     * Invokes {@link Bundle#putString(String, String)}
     *
     * @param key   the key which will be used to store the string
     * @param value the value of the string
     */
    public void putString(@Nullable String key, @Nullable String value) {
        bundle.putString(key, value);
    }

    /**
     * Invokes {@link Bundle#putStringArray(String, String[])}
     *
     * @param key   the key which will be used to store the string array
     * @param value the value of the string array
     */
    public void putStringArray(@Nullable String key, @Nullable String[] value) {
        bundle.putStringArray(key, value);
    }

    /**
     * Invokes {@link Bundle#putAll(Bundle)}
     *
     * @param bundle the bundle from which all the mappings should be set
     */
    public void putAll(@Nullable Bundle bundle) {
        if (bundle != null) {
            this.bundle.putAll(bundle);
        }
    }

    /**
     * Invokes {@link #putAll(Bundle)} with the wrapped {@link Bundle}
     *
     * @param taBundle the bundle wrapper from which all the mappings should be set
     */
    public void putAllTA(@Nullable TABundle taBundle) {
        if (taBundle != null) {
            putAll(taBundle.bundle);
        }
    }

    /**
     * Invokes {@link Bundle#putBinder(String, IBinder)}
     *
     * @param key   the key which will be used to store the binder
     * @param value the value of the binder
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    public void putBinder(@Nullable String key, @Nullable IBinder value) {
        bundle.putBinder(key, value);
    }

    /**
     * Invokes {@link BundleCompat#putBinder(Bundle, String, IBinder)}
     *
     * @param key   the key which will be used to store the binder
     * @param value the value of the binder
     */
    public void putBinderCompat(@Nullable String key, @Nullable IBinder value) {
        BundleCompat.putBinder(bundle, key, value);
    }

    /**
     * Invokes {@link Bundle#putBundle(String, Bundle)}
     *
     * @param key   the key which will be used to store the bundle
     * @param value the value of the bundle
     */
    public void putBundle(@Nullable String key, @Nullable Bundle value) {
        bundle.putBundle(key, value);
    }

    /**
     * Invokes {@link Bundle#putBundle(String, Bundle)} with the bundle inside the wrapper
     *
     * @param key   the key which will be used to store the bundle
     * @param value the value of the bundle
     */
    public void putTABundle(@Nullable String key, @Nullable TABundle value) {
        if (value != null) {
            bundle.putBundle(key, value.bundle);
        }
    }

    /**
     * Invokes {@link Bundle#putByte(String, byte)}
     *
     * @param key   the key which will be used to store the byte
     * @param value the value of the byte
     */
    public void putByte(@Nullable String key, byte value) {
        bundle.putByte(key, value);
    }

    /**
     * Invokes {@link Bundle#putByteArray(String, byte[])}
     *
     * @param key   the key which will be used to store the byte array
     * @param value the value of the byte array
     */
    public void putByteArray(@Nullable String key, @Nullable byte[] value) {
        bundle.putByteArray(key, value);
    }

    /**
     * Invokes {@link Bundle#putChar(String, char)}
     *
     * @param key   the key which will be used to store the char
     * @param value the value of the char
     */
    public void putChar(@Nullable String key, char value) {
        bundle.putChar(key, value);
    }

    /**
     * Invokes {@link Bundle#putCharArray(String, char[])}
     *
     * @param key   the key which will be used to store the char array
     * @param value the value of the char array
     */
    public void putCharArray(@Nullable String key, @Nullable char[] value) {
        bundle.putCharArray(key, value);
    }

    /**
     * Invokes {@link Bundle#putCharSequence(String, CharSequence)}
     *
     * @param key   the key which will be used to store the char sequence
     * @param value the value of the char sequence
     */
    public void putCharSequence(@Nullable String key, @Nullable CharSequence value) {
        bundle.putCharSequence(key, value);
    }

    /**
     * Invokes {@link Bundle#putCharSequenceArray(String, CharSequence[])}
     *
     * @param key   the key which will be used to store the char sequence array
     * @param value the value of the char sequence array
     */
    public void putCharSequenceArray(@Nullable String key, @Nullable CharSequence[] value) {
        bundle.putCharSequenceArray(key, value);
    }

    /**
     * Invokes {@link Bundle#putCharSequenceArrayList(String, ArrayList)}
     *
     * @param key   the key which will be used to store the char sequence array list
     * @param value the value of the char sequence array list
     */
    public void putCharSequenceArrayList(@Nullable String key, @Nullable ArrayList<CharSequence> value) {
        bundle.putCharSequenceArrayList(key, value);
    }

    /**
     * Invokes {@link Bundle#putFloat(String, float)}
     *
     * @param key   the key which will be used to store the float
     * @param value the value of the float
     */
    public void putFloat(@Nullable String key, float value) {
        bundle.putFloat(key, value);
    }

    /**
     * Invokes {@link Bundle#putFloatArray(String, float[])}
     *
     * @param key   the key which will be used to store the float array
     * @param value the value of the float array
     */
    public void putFloatArray(@Nullable String key, @Nullable float[] value) {
        bundle.putFloatArray(key, value);
    }

    /**
     * Invokes {@link Bundle#putIntegerArrayList(String, ArrayList)}
     *
     * @param key   the key which will be used to store the integer array list
     * @param value the value of the integer array list
     */
    public void putIntegerArrayList(@Nullable String key, @Nullable ArrayList<Integer> value) {
        bundle.putIntegerArrayList(key, value);
    }

    /**
     * Invokes {@link Bundle#putParcelable(String, Parcelable)}
     *
     * @param key   the key which will be used to store the parcelable
     * @param value the value of the parcelable
     */
    public void putParcelable(@Nullable String key, @Nullable Parcelable value) {
        bundle.putParcelable(key, value);
    }

    /**
     * Invokes {@link Bundle#putParcelableArray(String, Parcelable[])}
     *
     * @param key   the key which will be used to store the parcelable array
     * @param value the value of the parcelable array
     */
    public void putParcelableArray(@Nullable String key, @Nullable Parcelable[] value) {
        bundle.putParcelableArray(key, value);
    }

    /**
     * Invokes {@link Bundle#putParcelableArrayList(String, ArrayList)}
     *
     * @param key   the key which will be used to store the parcelable array list
     * @param value the value of the parcelable array list
     */
    public void putParcelableArrayList(@Nullable String key, @Nullable ArrayList<Parcelable> value) {
        bundle.putParcelableArrayList(key, value);
    }

    /**
     * Invokes {@link Bundle#putSerializable(String, Serializable)}
     *
     * @param key   the key which will be used to store the serializable
     * @param value the value of the serializable
     */
    public void putSerializable(@Nullable String key, @Nullable Serializable value) {
        bundle.putSerializable(key, value);
    }

    /**
     * Invokes {@link Bundle#putShort(String, short)}
     *
     * @param key   the key which will be used to store the short
     * @param value the value of the short
     */
    public void putShort(@Nullable String key, short value) {
        bundle.putShort(key, value);
    }

    /**
     * Invokes {@link Bundle#putShortArray(String, short[])}
     *
     * @param key   the key which will be used to store the short array
     * @param value the value of the short array
     */
    public void putShortArray(@Nullable String key, @Nullable short[] value) {
        bundle.putShortArray(key, value);
    }

    /**
     * Invokes {@link Bundle#putSize(String, Size)}
     *
     * @param key   the key which will be used to store the size
     * @param value the value of the size
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void putSize(@Nullable String key, @Nullable Size value) {
        bundle.putSize(key, value);
    }

    /**
     * Invokes {@link Bundle#putSizeF(String, SizeF)}
     *
     * @param key   the key which will be used to store the size
     * @param value the value of the size
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void putSizeF(@Nullable String key, @Nullable SizeF value) {
        bundle.putSizeF(key, value);
    }

    /**
     * Invokes {@link Bundle#putSparseParcelableArray(String, SparseArray)}
     *
     * @param key   the key which will be used to store the sparse parcelable array
     * @param value the value of the sparse parcelable array
     */
    public void putSparseParcelableArray(@Nullable String key, @Nullable SparseArray<? extends Parcelable> value) {
        bundle.putSparseParcelableArray(key, value);
    }

    /**
     * Invokes {@link Bundle#putStringArrayList(String, ArrayList)}
     *
     * @param key   the key which will be used to store the string array list
     * @param value the value of the string array list
     */
    public void putStringArrayList(@Nullable String key, @Nullable ArrayList<String> value) {
        bundle.putStringArrayList(key, value);
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeBundle(bundle);
    }

    public static final Creator<TABundle> CREATOR = new Creator<TABundle>() {
        @Override
        public TABundle createFromParcel(Parcel in) {
            return new TABundle(in);
        }

        @Override
        public TABundle[] newArray(int size) {
            return new TABundle[size];
        }
    };
}
