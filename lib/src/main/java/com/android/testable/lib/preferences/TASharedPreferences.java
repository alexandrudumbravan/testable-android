package com.android.testable.lib.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.Gson;

import java.util.Map;
import java.util.Set;

public class TASharedPreferences {

    public static final int MODE_PRIVATE = 1;
    @Deprecated
    public static final int MODE_WORLD_READABLE = 2;
    @Deprecated
    public static final int MODE_WORLD_WRITEABLE = 3;
    public static final int MODE_MULTI_PROCESS = 4;

    @NonNull
    SharedPreferences sharedPreferences;
    @NonNull
    Gson gson;


    public TASharedPreferences(Context context, String name, @SharedPrefsMode int mode, @NonNull Gson gson) {
        sharedPreferences = context.getSharedPreferences(name, extractMode(mode));
        this.gson = gson;
    }

    /**
     * Invokes {@link SharedPreferences#contains(String)}
     *
     * @param key the shared preferences key
     * @return true if it contains the key of false otherwise
     */
    public boolean contains(@NonNull String key) {
        return sharedPreferences.contains(key);
    }

    /**
     * Invokes {@link SharedPreferences#edit()}
     */
    public TASharedPreferencesEditor edit() {
        return new TASharedPreferencesEditor(sharedPreferences.edit());
    }

    /**
     * Invokes {@link SharedPreferences#getAll()}
     *
     * @return all the values in the shared preferences
     */
    public Map<String, ?> getAll() {
        return sharedPreferences.getAll();
    }

    /**
     * Invokes {@link SharedPreferences#getBoolean(String, boolean)}
     *
     * @param key      the key of the preference to retrieve
     * @param defValue the default value to return in case the preference does not exist
     * @return the preference if it exists or the default value otherwise
     */
    public boolean getBoolean(@NonNull String key, boolean defValue) {
        return sharedPreferences.getBoolean(key, defValue);
    }

    /**
     * Invokes {@link SharedPreferences#getFloat(String, float)}
     *
     * @param key      the key of the preference to retrieve
     * @param defValue the default value to return in case the preference does not exist
     * @return the preference if it exists or the default value otherwise
     */
    public float getFloat(@NonNull String key, float defValue) {
        return sharedPreferences.getFloat(key, defValue);
    }

    /**
     * Invokes {@link SharedPreferences#getInt(String, int)}
     *
     * @param key      the key of the preference to retrieve
     * @param defValue the default value to return in case the preference does not exist
     * @return the preference if it exists or the default value otherwise
     */
    public int getInt(@NonNull String key, int defValue) {
        return sharedPreferences.getInt(key, defValue);
    }

    /**
     * Invokes {@link SharedPreferences#getLong(String, long)}
     *
     * @param key      the key of the preference to retrieve
     * @param defValue the default value to return in case the preference does not exist
     * @return the preference if it exists or the default value otherwise
     */
    public long getLong(@NonNull String key, long defValue) {
        return sharedPreferences.getLong(key, defValue);
    }

    /**
     * Invokes {@link SharedPreferences#getString(String, String)}
     *
     * @param key      the key of the preference to retrieve
     * @param defValue the default value to return in case the preference does not exist
     * @return the preference if it exists or the default value otherwise
     */
    public String getString(@NonNull String key, @Nullable String defValue) {
        return sharedPreferences.getString(key, defValue);
    }

    /**
     * Invokes {@link SharedPreferences#getStringSet(String, Set)}
     *
     * @param key       the key of the preference to retrieve
     * @param defValues the default values to return in case the preference does not exist
     * @return the preference if it exists or the default value otherwise
     */
    public Set<String> getStringSet(@NonNull String key, @Nullable Set<String> defValues) {
        return sharedPreferences.getStringSet(key, defValues);
    }

    /**
     * Retrieves an object from a JSON String representation using {@link Gson}. Make sure to use
     * {@link com.google.gson.annotations.SerializedName} when saving objects as JSON when combined with Proguard or
     * other obfuscation tools
     *
     * @param key       the key of the preference to retrieve
     * @param typeClass the class of the object you wish to extract
     * @return the object associated with the key or null if it cannot be retrieved
     */
    @Nullable
    public <T> T getObject(@NonNull String key, Class<T> typeClass) {
        String json = getString(key, null);
        if (json != null) {
            return gson.fromJson(json, typeClass);
        }
        return null;
    }

    /**
     * Invokes {@link SharedPreferences#registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener)}
     *
     * @param onTASharedPreferencesChangeListener the listener to be registered on the changes
     */
    public void registerOnSharedPreferenceChangeListener(OnTASharedPreferencesChangeListener onTASharedPreferencesChangeListener) {
        sharedPreferences.registerOnSharedPreferenceChangeListener(onTASharedPreferencesChangeListener);
    }

    /**
     * Invokes {@link SharedPreferences#registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener)}
     *
     * @param onTASharedPreferencesChangeListener the listener to be registered on the changes
     */
    public void unregisterOnSharedPreferenceChangeListener(OnTASharedPreferencesChangeListener onTASharedPreferencesChangeListener) {
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(onTASharedPreferencesChangeListener);
    }

    /**
     * Opens the editor and saves the value asynchronously by invoking {@link TASharedPreferencesEditor#putBoolean(String, boolean)}
     *
     * @param key   The name of the preference to modify
     * @param value The value for the preference
     */
    public void putBoolean(@NonNull String key, boolean value) {
        TASharedPreferencesEditor editor = edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    /**
     * Opens the editor and saves the value asynchronously by invoking {@link TASharedPreferencesEditor#putFloat(String, float)}
     *
     * @param key   The name of the preference to modify
     * @param value The value for the preference
     */
    public void putFloat(@NonNull String key, float value) {
        TASharedPreferencesEditor editor = edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    /**
     * Opens the editor and saves the value asynchronously by invoking {@link TASharedPreferencesEditor#putInt(String, int)}
     *
     * @param key   The name of the preference to modify
     * @param value The value for the preference
     */
    public void putInt(@NonNull String key, int value) {
        TASharedPreferencesEditor editor = edit();
        editor.putInt(key, value);
        editor.apply();
    }

    /**
     * Opens the editor and saves the value asynchronously by invoking {@link TASharedPreferencesEditor#putLong(String, long)}
     *
     * @param key   The name of the preference to modify
     * @param value The value for the preference
     */
    public void putLong(@NonNull String key, long value) {
        TASharedPreferencesEditor editor = edit();
        editor.putLong(key, value);
        editor.apply();
    }

    /**
     * Opens the editor and saves the value asynchronously by invoking {@link TASharedPreferencesEditor#putString(String, String)}
     *
     * @param key   The name of the preference to modify
     * @param value The value for the preference
     */
    public void putString(@NonNull String key, @Nullable String value) {
        TASharedPreferencesEditor editor = edit();
        editor.putString(key, value);
        editor.apply();
    }

    /**
     * Opens the editor and saves the value asynchronously by invoking {@link TASharedPreferencesEditor#putStringSet(String, Set)}
     *
     * @param key    The name of the preference to modify
     * @param values The value for the preference
     */
    public void putStringSet(@NonNull String key, @Nullable Set<String> values) {
        TASharedPreferencesEditor editor = edit();
        editor.putStringSet(key, values);
        editor.apply();
    }

    /**
     * Opens the editor and removes the value asynchronously by invoking {@link TASharedPreferencesEditor#remove(String)}
     *
     * @param key The name of the preference to remove
     */
    public void remove(@NonNull String key) {
        TASharedPreferencesEditor editor = edit();
        editor.remove(key);
        editor.apply();
    }

    /**
     * Opens the editor and saves the value asynchronously by invoking {@link TASharedPreferencesEditor#putObject(String, Object)}
     *
     * @param key   The name of the preference to modify
     * @param value The value of the preference
     */
    public <T> void putObject(@NonNull String key, @NonNull T value) {
        TASharedPreferencesEditor editor = edit();
        editor.putObject(key, value);
        editor.apply();
    }


    private static int extractMode(@SharedPrefsMode int mode) {
        switch (mode) {
            case MODE_PRIVATE:
                return Context.MODE_PRIVATE;
            case MODE_WORLD_READABLE:
                return Context.MODE_WORLD_READABLE;
            case MODE_WORLD_WRITEABLE:
                return Context.MODE_WORLD_WRITEABLE;
            case MODE_MULTI_PROCESS:
                return Context.MODE_MULTI_PROCESS;
            default:
                throw new IllegalArgumentException("Invalid mode");
        }
    }
}
