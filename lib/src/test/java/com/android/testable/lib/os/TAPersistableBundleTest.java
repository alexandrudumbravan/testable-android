package com.android.testable.lib.os;

import android.os.Parcel;
import android.os.PersistableBundle;
import com.android.testable.lib.os.TAPersistableBundle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TAPersistableBundleTest {

    private static final String KEY = "key";

    private TAPersistableBundle subject;
    @Mock
    private PersistableBundle persistableBundle;

    @Before
    public void setUp() {
        subject = new TAPersistableBundle(persistableBundle);
        assertEquals(persistableBundle, subject.bundle);
    }

    @Test
    public void init() {
        Parcel parcel = mock(Parcel.class);
        when(parcel.readPersistableBundle(TAPersistableBundle.class.getClassLoader())).thenReturn(persistableBundle);
        subject = new TAPersistableBundle(parcel);
        assertEquals(persistableBundle, subject.bundle);

        int size = 5;
        TAPersistableBundle taPersistableBundle = TAPersistableBundle.CREATOR.createFromParcel(parcel);
        TAPersistableBundle[] taPersistableBundles = TAPersistableBundle.CREATOR.newArray(size);
        assertEquals(persistableBundle, taPersistableBundle.bundle);
        assertEquals(taPersistableBundles.length, size);
    }

    @Test
    public void clear() {
        subject.clear();
        verify(persistableBundle).clear();
    }

    @Test
    public void isEmpty() {
        when(persistableBundle.isEmpty()).thenReturn(true);
        assertTrue(subject.isEmpty());
    }

    @Test
    public void keySet() {
        Set<String> keySet = new HashSet<>();
        keySet.add("1");
        keySet.add("2");
        keySet.add("3");
        when(persistableBundle.keySet()).thenReturn(keySet);
        assertEquals(keySet, subject.keySet());
    }

    @Test
    public void remove() {
        subject.remove(KEY);
        verify(persistableBundle).remove(KEY);
    }

    @Test
    public void size() {
        int size = 10;
        when(persistableBundle.size()).thenReturn(size);
        assertEquals(size, subject.size());
    }

    @Test
    public void get() {
        Object object = mock(Object.class);
        when(persistableBundle.get(KEY)).thenReturn(object);
        assertEquals(object, subject.get(KEY));
    }

    @Test
    public void getBoolean() {
        when(persistableBundle.getBoolean(KEY)).thenReturn(true);
        assertTrue(subject.getBoolean(KEY));
    }

    @Test
    public void getBoolean_withDefault() {
        when(persistableBundle.getBoolean(KEY, true)).thenReturn(true);
        assertTrue(subject.getBoolean(KEY, true));
    }

    @Test
    public void getBooleanArray() {
        boolean[] array = new boolean[]{true, false, true, false};
        when(persistableBundle.getBooleanArray(KEY)).thenReturn(array);
        assertArrayEquals(array, subject.getBooleanArray(KEY));
    }

    @Test
    public void getDouble() {
        double value = 20.0;
        when(persistableBundle.getDouble(KEY)).thenReturn(value);
        assertEquals(value, subject.getDouble(KEY), 0);
    }

    @Test
    public void getDouble_withDefault() {
        double value = 20.0;
        double defaultValue = 10.0;
        when(persistableBundle.getDouble(KEY, defaultValue)).thenReturn(value);
        assertEquals(value, subject.getDouble(KEY, defaultValue), 0);
    }

    @Test
    public void getDoubleArray() {
        double[] value = new double[]{1.0, 2.0, 3.0};
        when(persistableBundle.getDoubleArray(KEY)).thenReturn(value);
        assertEquals(value, subject.getDoubleArray(KEY));
    }

    @Test
    public void getInt() {
        int value = 10;
        when(persistableBundle.getInt(KEY)).thenReturn(value);
        assertEquals(value, subject.getInt(KEY));
    }

    @Test
    public void getInt_withDefault() {
        int value = 10;
        int defaultValue = 5;
        when(persistableBundle.getInt(KEY, defaultValue)).thenReturn(value);
        assertEquals(value, subject.getInt(KEY, defaultValue));
    }

    @Test
    public void getIntArray() {
        int[] value = new int[]{1, 2, 3};
        when(persistableBundle.getIntArray(KEY)).thenReturn(value);
        assertEquals(value, subject.getIntArray(KEY));
    }

    @Test
    public void getLong() {
        long value = 10L;
        when(persistableBundle.getLong(KEY)).thenReturn(value);
        assertEquals(value, subject.getLong(KEY));
    }

    @Test
    public void getLong_withDefault() {
        long value = 10L;
        long defaultValue = 5L;
        when(persistableBundle.getLong(KEY, defaultValue)).thenReturn(value);
        assertEquals(value, subject.getLong(KEY, defaultValue));
    }

    @Test
    public void getLongArray() {
        long[] value = new long[]{1L, 2L, 3L};
        when(persistableBundle.getLongArray(KEY)).thenReturn(value);
        assertArrayEquals(value, subject.getLongArray(KEY));
    }

    @Test
    public void getString() {
        String value = "value";
        when(persistableBundle.getString(KEY)).thenReturn(value);
        assertEquals(value, subject.getString(KEY));
    }

    @Test
    public void getString_withDefault() {
        String value = "value";
        String defaultValue = "defaultValue";
        when(persistableBundle.getString(KEY, defaultValue)).thenReturn(value);
        assertEquals(value, subject.getString(KEY, defaultValue));
    }

    @Test
    public void getStringArray() {
        String[] value = new String[]{"1", "2", "3"};
        when(persistableBundle.getStringArray(KEY)).thenReturn(value);
        assertArrayEquals(value, subject.getStringArray(KEY));
    }

    @Test
    public void getPersistableBundle() {
        PersistableBundle value = mock(PersistableBundle.class);
        when(persistableBundle.getPersistableBundle(KEY)).thenReturn(value);
        assertEquals(value, subject.getPersistableBundle(KEY));
    }

    @Test
    public void getTAPersistableBundle() {
        PersistableBundle value = mock(PersistableBundle.class);
        when(persistableBundle.getPersistableBundle(KEY)).thenReturn(value);
        TAPersistableBundle result = subject.getTAPersistableBundle(KEY);
        assertEquals(value, result.bundle);
    }

    @Test
    public void putBoolean() {
        subject.putBoolean(KEY, true);
        verify(persistableBundle).putBoolean(KEY, true);
    }

    @Test
    public void putBooleanArray() {
        boolean[] value = new boolean[]{true, true};
        subject.putBooleanArray(KEY, value);
        verify(persistableBundle).putBooleanArray(KEY, value);
    }

    @Test
    public void putDouble() {
        double value = 20.0;
        subject.putDouble(KEY, value);
        verify(persistableBundle).putDouble(KEY, value);
    }

    @Test
    public void putDoubleArray() {
        double[] value = new double[]{1, 2, 3};
        subject.putDoubleArray(KEY, value);
        verify(persistableBundle).putDoubleArray(KEY, value);
    }

    @Test
    public void putInt() {
        int value = 20;
        subject.putInt(KEY, value);
        verify(persistableBundle).putInt(KEY, value);
    }

    @Test
    public void putIntArray() {
        int[] value = new int[]{1, 2, 3};
        subject.putIntArray(KEY, value);
        verify(persistableBundle).putIntArray(KEY, value);
    }

    @Test
    public void putLong() {
        long value = 20L;
        subject.putLong(KEY, value);
        verify(persistableBundle).putLong(KEY, value);
    }

    @Test
    public void putLongArray() {
        long[] value = new long[]{1L, 2L, 3L};
        subject.putLongArray(KEY, value);
        verify(persistableBundle).putLongArray(KEY, value);
    }

    @Test
    public void putString() {
        String value = "value";
        subject.putString(KEY, value);
        verify(persistableBundle).putString(KEY, value);
    }

    @Test
    public void putStringArray() {
        String[] value = new String[]{"1", "2", "3"};
        subject.putStringArray(KEY, value);
        verify(persistableBundle).putStringArray(KEY, value);
    }

    @Test
    public void putPersistableBundle() {
        PersistableBundle value = mock(PersistableBundle.class);
        subject.putPersistableBundle(KEY, value);
        verify(persistableBundle).putPersistableBundle(KEY, value);
    }

    @Test
    public void putTAPersistableBundle() {
        TAPersistableBundle value = new TAPersistableBundle(mock(PersistableBundle.class));
        TAPersistableBundle spy = spy(subject);
        spy.putTAPersistableBundle(KEY, value);
        verify(spy).putPersistableBundle(KEY, value.bundle);
    }

    @Test
    public void describeContents() {
        assertEquals(subject.hashCode(), subject.describeContents());
    }

    @Test
    public void writeToParcel() {
        Parcel parcel = mock(Parcel.class);
        subject.writeToParcel(parcel, 0);
        verify(parcel).writePersistableBundle(subject.bundle);
    }
}