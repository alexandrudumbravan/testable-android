package com.android.testable.lib.preferences;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.Gson;

import java.util.Set;

public class TASharedPreferencesEditor {

    SharedPreferences.Editor editor;
    @Nullable
    Gson gson;

    public TASharedPreferencesEditor(@NonNull SharedPreferences.Editor editor) {
        this(editor, null);
    }

    public TASharedPreferencesEditor(@NonNull SharedPreferences.Editor editor, @Nullable Gson gson) {
        this.editor = editor;
        this.gson = gson;
    }

    /**
     * Invokes {@link SharedPreferences.Editor#apply()}
     */
    public void apply() {
        editor.apply();
    }

    /**
     * Invokes {@link SharedPreferences.Editor#clear()}
     */
    public void clear() {
        editor.clear();
    }

    /**
     * Invokes {@link SharedPreferences.Editor#commit()}
     */
    public void commit() {
        editor.commit();
    }

    /**
     * Invokes {@link SharedPreferences.Editor#putBoolean(String, boolean)}
     *
     * @param key   The name of the preference to modify
     * @param value The value for the preference
     */
    public void putBoolean(@NonNull String key, boolean value) {
        editor.putBoolean(key, value);
    }

    /**
     * Invokes {@link SharedPreferences.Editor#putFloat(String, float)}
     *
     * @param key   The name of the preference to modify
     * @param value The value for the preference
     */
    public void putFloat(@NonNull String key, float value) {
        editor.putFloat(key, value);
    }

    /**
     * Invokes {@link SharedPreferences.Editor#putInt(String, int)}
     *
     * @param key   The name of the preference to modify
     * @param value The value for the preference
     */
    public void putInt(@NonNull String key, int value) {
        editor.putInt(key, value);
    }

    /**
     * Invokes {@link SharedPreferences.Editor#putLong(String, long)}
     *
     * @param key   The name of the preference to modify
     * @param value The value for the preference
     */
    public void putLong(@NonNull String key, long value) {
        editor.putLong(key, value);
    }

    /**
     * Invokes {@link SharedPreferences.Editor#putString(String, String)}
     *
     * @param key   The name of the preference to modify
     * @param value The value for the preference
     */
    public void putString(@NonNull String key, @Nullable String value) {
        editor.putString(key, value);
    }

    /**
     * Invokes {@link SharedPreferences.Editor#putStringSet(String, Set)}
     *
     * @param key    The name of the preference to modify
     * @param values The value for the preference
     */
    public void putStringSet(@NonNull String key, @Nullable Set<String> values) {
        editor.putStringSet(key, values);
    }

    /**
     * Invokes {@link SharedPreferences.Editor#remove(String)}
     *
     * @param key The name of the preference to remove
     */
    public void remove(@NonNull String key) {
        editor.remove(key);
    }

    /**
     * Saves an object as a JSON String using {@link Gson}. Make sure to use
     * {@link com.google.gson.annotations.SerializedName} when saving objects as JSON when combined with Proguard or
     * other obfuscation tools
     *
     * @param key   The name of the preference to modify
     * @param value The value of the preference
     */
    public <T> void putObject(@NonNull String key, @NonNull T value) {
        if (gson != null) {
            putString(key, gson.toJson(value));
        }
    }
}
