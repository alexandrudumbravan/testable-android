package com.android.testable.lib.os;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.core.app.BundleCompat;
import com.android.testable.lib.os.TABundle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({BundleCompat.class})
public class TABundleTest {

    private static final String KEY = "key";

    private TABundle subject;
    @Mock
    private Bundle bundle;


    @Before
    public void setUp() {
        subject = new TABundle(bundle);
        assertEquals(bundle, subject.bundle);
    }

    @Test
    public void init() {
        Parcel parcel = mock(Parcel.class);
        when(parcel.readBundle(TABundle.class.getClassLoader())).thenReturn(bundle);
        subject = new TABundle(parcel);
        assertEquals(bundle, subject.bundle);

        int size = 5;
        TABundle taBundle = TABundle.CREATOR.createFromParcel(parcel);
        TABundle[] taBundles = TABundle.CREATOR.newArray(size);
        assertEquals(bundle, taBundle.bundle);
        assertEquals(taBundles.length, size);
    }

    @Test
    public void clear() {
        subject.clear();
        verify(bundle).clear();
    }

    @Test
    public void isEmpty() {
        when(bundle.isEmpty()).thenReturn(true);
        assertTrue(subject.isEmpty());
    }

    @Test
    public void keySet() {
        Set<String> keySet = new HashSet<>();
        keySet.add("1");
        keySet.add("2");
        keySet.add("3");
        when(bundle.keySet()).thenReturn(keySet);
        assertEquals(keySet, subject.keySet());
    }

    @Test
    public void remove() {
        subject.remove(KEY);
        verify(bundle).remove(KEY);
    }

    @Test
    public void size() {
        int size = 10;
        when(bundle.size()).thenReturn(size);
        assertEquals(size, subject.size());
    }

    @Test
    public void get() {
        Object object = mock(Object.class);
        when(bundle.get(KEY)).thenReturn(object);
        assertEquals(object, subject.get(KEY));
    }

    @Test
    public void getBoolean() {
        when(bundle.getBoolean(KEY)).thenReturn(true);
        assertTrue(subject.getBoolean(KEY));
    }

    @Test
    public void getBoolean_withDefault() {
        when(bundle.getBoolean(KEY, true)).thenReturn(true);
        assertTrue(subject.getBoolean(KEY, true));
    }

    @Test
    public void getBooleanArray() {
        boolean[] array = new boolean[]{true, false, true, false};
        when(bundle.getBooleanArray(KEY)).thenReturn(array);
        assertArrayEquals(array, subject.getBooleanArray(KEY));
    }

    @Test
    public void getDouble() {
        double value = 20.0;
        when(bundle.getDouble(KEY)).thenReturn(value);
        assertEquals(value, subject.getDouble(KEY), 0);
    }

    @Test
    public void getDouble_withDefault() {
        double value = 20.0;
        double defaultValue = 10.0;
        when(bundle.getDouble(KEY, defaultValue)).thenReturn(value);
        assertEquals(value, subject.getDouble(KEY, defaultValue), 0);
    }

    @Test
    public void getDoubleArray() {
        double[] value = new double[]{1.0, 2.0, 3.0};
        when(bundle.getDoubleArray(KEY)).thenReturn(value);
        assertEquals(value, subject.getDoubleArray(KEY));
    }

    @Test
    public void getInt() {
        int value = 10;
        when(bundle.getInt(KEY)).thenReturn(value);
        assertEquals(value, subject.getInt(KEY));
    }

    @Test
    public void getInt_withDefault() {
        int value = 10;
        int defaultValue = 5;
        when(bundle.getInt(KEY, defaultValue)).thenReturn(value);
        assertEquals(value, subject.getInt(KEY, defaultValue));
    }

    @Test
    public void getIntArray() {
        int[] value = new int[]{1, 2, 3};
        when(bundle.getIntArray(KEY)).thenReturn(value);
        assertEquals(value, subject.getIntArray(KEY));
    }

    @Test
    public void getLong() {
        long value = 10L;
        when(bundle.getLong(KEY)).thenReturn(value);
        assertEquals(value, subject.getLong(KEY));
    }

    @Test
    public void getLong_withDefault() {
        long value = 10L;
        long defaultValue = 5L;
        when(bundle.getLong(KEY, defaultValue)).thenReturn(value);
        assertEquals(value, subject.getLong(KEY, defaultValue));
    }

    @Test
    public void getLongArray() {
        long[] value = new long[]{1L, 2L, 3L};
        when(bundle.getLongArray(KEY)).thenReturn(value);
        assertArrayEquals(value, subject.getLongArray(KEY));
    }

    @Test
    public void getString() {
        String value = "value";
        when(bundle.getString(KEY)).thenReturn(value);
        assertEquals(value, subject.getString(KEY));
    }

    @Test
    public void getString_withDefault() {
        String value = "value";
        String defaultValue = "defaultValue";
        when(bundle.getString(KEY, defaultValue)).thenReturn(value);
        assertEquals(value, subject.getString(KEY, defaultValue));
    }

    @Test
    public void getStringArray() {
        String[] value = new String[]{"1", "2", "3"};
        when(bundle.getStringArray(KEY)).thenReturn(value);
        assertArrayEquals(value, subject.getStringArray(KEY));
    }

    @Test
    public void getBinder() {
        IBinder value = mock(IBinder.class);
        when(bundle.getBinder(KEY)).thenReturn(value);
        assertEquals(value, subject.getBinder(KEY));
    }

    @Test
    public void getBinderCompat() {
        IBinder value = mock(IBinder.class);
        PowerMockito.mockStatic(BundleCompat.class);
        when(BundleCompat.getBinder(bundle, KEY)).thenReturn(value);
        assertEquals(value, subject.getBinderCompat(KEY));
    }

    @Test
    public void getTABundle() {
        Bundle value = mock(Bundle.class);
        when(bundle.getBundle(KEY)).thenReturn(value);
        assertEquals(value, subject.getTABundle(KEY).bundle);
    }

    @Test
    public void getBundle() {
        Bundle value = mock(Bundle.class);
        when(bundle.getBundle(KEY)).thenReturn(value);
        assertEquals(value, subject.getBundle(KEY));
    }

    @Test
    public void getByte() {
        byte value = 10;
        when(bundle.getByte(KEY)).thenReturn(value);
        assertEquals(value, subject.getByte(KEY));
    }

    @Test
    public void getByte_withDefault() {
        byte value = 10;
        byte defaultValue = 5;
        when(bundle.getByte(KEY, defaultValue)).thenReturn(value);
        assertEquals(value, subject.getByte(KEY, defaultValue));
    }

    @Test
    public void getByteArray() {
        byte[] value = new byte[]{1, 2, 3};
        when(bundle.getByteArray(KEY)).thenReturn(value);
        assertEquals(value, subject.getByteArray(KEY));
    }

    @Test
    public void getChar() {
        char value = '1';
        when(bundle.getChar(KEY)).thenReturn(value);
        assertEquals(value, subject.getChar(KEY));
    }

    @Test
    public void getChar_withDefault() {
        char value = '1';
        char defaultValue = '0';
        when(bundle.getChar(KEY, defaultValue)).thenReturn(value);
        assertEquals(value, subject.getChar(KEY, defaultValue));
    }

    @Test
    public void getCharArray() {
        char[] value = new char[]{'1', '2', '3'};
        when(bundle.getCharArray(KEY)).thenReturn(value);
        assertEquals(value, subject.getCharArray(KEY));
    }

    @Test
    public void getCharSequence() {
        CharSequence value = "value";
        when(bundle.getCharSequence(KEY)).thenReturn(value);
        assertEquals(value, subject.getCharSequence(KEY));
    }

    @Test
    public void getCharSequence_withDefault() {
        CharSequence value = "value";
        CharSequence defaultValue = "defaultValue";
        when(bundle.getCharSequence(KEY, defaultValue)).thenReturn(value);
        assertEquals(value, subject.getCharSequence(KEY, defaultValue));
    }

    @Test
    public void getCharSequenceArray() {
        CharSequence[] value = new CharSequence[]{"1", "2", "3"};
        when(bundle.getCharSequenceArray(KEY)).thenReturn(value);
        assertArrayEquals(value, subject.getCharSequenceArray(KEY));
    }

    @Test
    public void getCharSequenceArrayList() {
        ArrayList<CharSequence> value = mock(ArrayList.class);
        when(bundle.getCharSequenceArrayList(KEY)).thenReturn(value);
        assertEquals(value, subject.getCharSequenceArrayList(KEY));
    }

    @Test
    public void getFloat() {
        float value = 1f;
        when(bundle.getFloat(KEY)).thenReturn(value);
        assertEquals(value, subject.getFloat(KEY), 0);
    }

    @Test
    public void getFloat_withDefault() {
        float value = 1f;
        float defaultValue = 2f;
        when(bundle.getFloat(KEY, defaultValue)).thenReturn(value);
        assertEquals(value, subject.getFloat(KEY, defaultValue), 0);
    }

    @Test
    public void getFloatArray() {
        float[] value = new float[]{1f, 2f, 3f};
        when(bundle.getFloatArray(KEY)).thenReturn(value);
        assertEquals(value, subject.getFloatArray(KEY));
    }

    @Test
    public void getIntegerArrayList() {
        ArrayList<Integer> value = mock(ArrayList.class);
        when(bundle.getIntegerArrayList(KEY)).thenReturn(value);
        assertEquals(value, subject.getIntegerArrayList(KEY));
    }

    @Test
    public void getParcelable() {
        Parcelable value = mock(Parcelable.class);
        when(bundle.getParcelable(KEY)).thenReturn(value);
        assertEquals(value, subject.getParcelable(KEY));
    }

    @Test
    public void getParcelableArray() {
        Parcelable[] value = new Parcelable[]{mock(Parcelable.class), mock(Parcelable.class)};
        when(bundle.getParcelableArray(KEY)).thenReturn(value);
        assertArrayEquals(value, subject.getParcelableArray(KEY));
    }

    @Test
    public void getParcelableArrayList() {
        ArrayList<Parcelable> value = mock(ArrayList.class);
        when(bundle.getParcelableArrayList(KEY)).thenReturn(value);
        assertEquals(value, subject.getParcelableArrayList(KEY));
    }

    @Test
    public void getSerializable() {
        Serializable value = mock(Serializable.class);
        when(bundle.getSerializable(KEY)).thenReturn(value);
        assertEquals(value, subject.getSerializable(KEY));
    }

    @Test
    public void getShort() {
        short value = 1;
        when(bundle.getShort(KEY)).thenReturn(value);
        assertEquals(value, subject.getShort(KEY));
    }

    @Test
    public void getShort_withDefault() {
        short value = 1;
        short defaultValue = 2;
        when(bundle.getShort(KEY, defaultValue)).thenReturn(value);
        assertEquals(value, subject.getShort(KEY, defaultValue));
    }

    @Test
    public void getShortArray() {
        short[] value = new short[]{1, 2, 3};
        when(bundle.getShortArray(KEY)).thenReturn(value);
        assertEquals(value, subject.getShortArray(KEY));
    }

    @Test
    public void getSize() {
        Size value = mock(Size.class);
        when(bundle.getSize(KEY)).thenReturn(value);
        assertEquals(value, subject.getSize(KEY));
    }

    @Test
    public void getSizeF() {
        SizeF value = mock(SizeF.class);
        when(bundle.getSizeF(KEY)).thenReturn(value);
        assertEquals(value, subject.getSizeF(KEY));
    }

    @Test
    public void getSparseParcelableArray() {
        SparseArray<Parcelable> value = mock(SparseArray.class);
        when(bundle.getSparseParcelableArray(KEY)).thenReturn(value);
        assertEquals(value, subject.getSparseParcelableArray(KEY));
    }

    @Test
    public void getStringArrayList() {
        ArrayList<String> value = mock(ArrayList.class);
        when(bundle.getStringArrayList(KEY)).thenReturn(value);
        assertEquals(value, subject.getStringArrayList(KEY));
    }

    @Test
    public void putBoolean() {
        subject.putBoolean(KEY, true);
        verify(bundle).putBoolean(KEY, true);
    }

    @Test
    public void putBooleanArray() {
        boolean[] value = new boolean[]{true, true};
        subject.putBooleanArray(KEY, value);
        verify(bundle).putBooleanArray(KEY, value);
    }

    @Test
    public void putDouble() {
        double value = 20.0;
        subject.putDouble(KEY, value);
        verify(bundle).putDouble(KEY, value);
    }

    @Test
    public void putDoubleArray() {
        double[] value = new double[]{1, 2, 3};
        subject.putDoubleArray(KEY, value);
        verify(bundle).putDoubleArray(KEY, value);
    }

    @Test
    public void putInt() {
        int value = 20;
        subject.putInt(KEY, value);
        verify(bundle).putInt(KEY, value);
    }

    @Test
    public void putIntArray() {
        int[] value = new int[]{1, 2, 3};
        subject.putIntArray(KEY, value);
        verify(bundle).putIntArray(KEY, value);
    }

    @Test
    public void putLong() {
        long value = 20L;
        subject.putLong(KEY, value);
        verify(bundle).putLong(KEY, value);
    }

    @Test
    public void putLongArray() {
        long[] value = new long[]{1L, 2L, 3L};
        subject.putLongArray(KEY, value);
        verify(bundle).putLongArray(KEY, value);
    }

    @Test
    public void putString() {
        String value = "value";
        subject.putString(KEY, value);
        verify(bundle).putString(KEY, value);
    }

    @Test
    public void putStringArray() {
        String[] value = new String[]{"1", "2", "3"};
        subject.putStringArray(KEY, value);
        verify(bundle).putStringArray(KEY, value);
    }

    @Test
    public void putAll() {
        Bundle value = mock(Bundle.class);
        subject.putAll(value);
        verify(bundle).putAll(value);
    }

    @Test
    public void putAllTA() {
        TABundle value = new TABundle(mock(Bundle.class));
        TABundle spy = spy(subject);
        spy.putAllTA(value);
        verify(spy).putAll(value.bundle);
    }

    @Test
    public void putBinder() {
        IBinder value = mock(IBinder.class);
        subject.putBinder(KEY, value);
        verify(bundle).putBinder(KEY, value);
    }

    @Test
    public void putBinderCompat() {
        mockStatic(BundleCompat.class);
        IBinder value = mock(IBinder.class);
        subject.putBinderCompat(KEY, value);
        verifyStatic();
        BundleCompat.putBinder(bundle, KEY, value);
    }

    @Test
    public void putBundle() {
        Bundle value = mock(Bundle.class);
        subject.putBundle(KEY, value);
        verify(bundle).putBundle(KEY, value);
    }

    @Test
    public void putTABundle() {
        TABundle value = new TABundle(mock(Bundle.class));
        subject.putTABundle(KEY, value);
        verify(bundle).putBundle(KEY, value.bundle);
    }

    @Test
    public void putByte() {
        byte value = 10;
        subject.putByte(KEY, value);
        verify(bundle).putByte(KEY, value);
    }

    @Test
    public void putByteArray() {
        byte[] value = new byte[]{1, 2, 3};
        subject.putByteArray(KEY, value);
        verify(bundle).putByteArray(KEY, value);
    }

    @Test
    public void putChar() {
        char value = '1';
        subject.putChar(KEY, value);
        verify(bundle).putChar(KEY, value);
    }

    @Test
    public void putCharArray() {
        char[] value = new char[]{'1', '2', '3'};
        subject.putCharArray(KEY, value);
        verify(bundle).putCharArray(KEY, value);
    }

    @Test
    public void putCharSequence() {
        CharSequence value = "value";
        subject.putCharSequence(KEY, value);
        verify(bundle).putCharSequence(KEY, value);
    }

    @Test
    public void putCharSequenceArray() {
        CharSequence[] value = new CharSequence[]{"1", "2", "3"};
        subject.putCharSequenceArray(KEY, value);
        verify(bundle).putCharSequenceArray(KEY, value);
    }

    @Test
    public void putCharSequenceArrayList() {
        ArrayList<CharSequence> value = mock(ArrayList.class);
        subject.putCharSequenceArrayList(KEY, value);
        verify(bundle).putCharSequenceArrayList(KEY, value);
    }

    @Test
    public void putFloat() {
        float value = 1f;
        subject.putFloat(KEY, value);
        verify(bundle).putFloat(KEY, value);
    }

    @Test
    public void putFloatArray() {
        float[] value = new float[]{1f, 2f, 3f};
        subject.putFloatArray(KEY, value);
        verify(bundle).putFloatArray(KEY, value);
    }

    @Test
    public void putIntegerArrayList() {
        ArrayList<Integer> value = mock(ArrayList.class);
        subject.putIntegerArrayList(KEY, value);
        verify(bundle).putIntegerArrayList(KEY, value);
    }

    @Test
    public void putParcelable() {
        Parcelable value = mock(Parcelable.class);
        subject.putParcelable(KEY, value);
        verify(bundle).putParcelable(KEY, value);
    }

    @Test
    public void putParcelableArray() {
        Parcelable[] value = new Parcelable[]{mock(Parcelable.class), mock(Parcelable.class)};
        subject.putParcelableArray(KEY, value);
        verify(bundle).putParcelableArray(KEY, value);
    }

    @Test
    public void putParcelableArrayList() {
        ArrayList<Parcelable> value = mock(ArrayList.class);
        subject.putParcelableArrayList(KEY, value);
        verify(bundle).putParcelableArrayList(KEY, value);
    }

    @Test
    public void putSerializable() {
        Serializable value = mock(Serializable.class);
        subject.putSerializable(KEY, value);
        verify(bundle).putSerializable(KEY, value);
    }

    @Test
    public void putShort() {
        short value = 1;
        subject.putShort(KEY, value);
        verify(bundle).putShort(KEY, value);
    }

    @Test
    public void putShortArray() {
        short[] value = new short[]{1, 2, 3};
        subject.putShortArray(KEY, value);
        verify(bundle).putShortArray(KEY, value);
    }

    @Test
    public void putSize() {
        Size value = mock(Size.class);
        subject.putSize(KEY, value);
        verify(bundle).putSize(KEY, value);
    }

    @Test
    public void putSizeF() {
        SizeF value = mock(SizeF.class);
        subject.putSizeF(KEY, value);
        verify(bundle).putSizeF(KEY, value);
    }

    @Test
    public void putSparseParcelableArray() {
        SparseArray<Parcelable> value = mock(SparseArray.class);
        subject.putSparseParcelableArray(KEY, value);
        verify(bundle).putSparseParcelableArray(KEY, value);
    }

    @Test
    public void putStringArrayList() {
        ArrayList<String> value = mock(ArrayList.class);
        subject.putStringArrayList(KEY, value);
        verify(bundle).putStringArrayList(KEY, value);
    }

    @Test
    public void describeContents() {
        assertEquals(subject.hashCode(), subject.describeContents());
    }

    @Test
    public void writeToParcel() {
        Parcel parcel = mock(Parcel.class);
        subject.writeToParcel(parcel, 0);
        verify(parcel).writeBundle(subject.bundle);
    }
}