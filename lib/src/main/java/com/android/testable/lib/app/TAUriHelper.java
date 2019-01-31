package com.android.testable.lib.app;

import android.net.Uri;
import androidx.annotation.NonNull;

import java.io.File;

public class TAUriHelper {

    /**
     * Invokes {@link Uri#decode(String)}
     */
    @NonNull
    public String decode(@NonNull String s) {
        return Uri.decode(s);
    }

    /**
     * Invokes {@link Uri#encode(String, String)}
     */
    @NonNull
    public String encode(String s, String allow) {
        return Uri.encode(s, allow);
    }

    /**
     * Invokes {@link Uri#encode(String)}
     */
    @NonNull
    public String encode(String s) {
        return Uri.encode(s);
    }

    /**
     * Invokes {@link Uri#fromFile(File)}
     */
    @NonNull
    public TAUri fromFile(@NonNull File file) {
        return new TAUri(Uri.fromFile(file));
    }

    /**
     * Invokes {@link Uri#fromParts(String, String, String)}
     */
    @NonNull
    public TAUri fromParts(@NonNull String scheme, @NonNull String ssp, @NonNull String fragment) {
        return new TAUri(Uri.fromParts(scheme, ssp, fragment));
    }

    /**
     * Invokes {@link Uri#parse(String)}
     */
    @NonNull
    public TAUri parse(@NonNull String uriString) {
        return new TAUri(Uri.parse(uriString));
    }

    /**
     * Invokes {@link Uri#withAppendedPath(Uri, String)}
     */
    @NonNull
    public TAUri withAppendedPath(@NonNull Uri baseUri, @NonNull String pathSegment) {
        return new TAUri(Uri.withAppendedPath(baseUri, pathSegment));
    }
}
