package com.android.testable.lib.app;

import android.net.Uri;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.io.File;
import java.util.List;
import java.util.Set;

public class TAUri implements Comparable<TAUri>, Parcelable {

    @NonNull
    public final Uri uri;

    public TAUri(@NonNull Uri uri) {
        this.uri = uri;
    }

    protected TAUri(Parcel in) {
        uri = in.readParcelable(Uri.class.getClassLoader());
    }

    public static final Creator<TAUri> CREATOR = new Creator<TAUri>() {
        @Override
        public TAUri createFromParcel(Parcel in) {
            return new TAUri(in);
        }

        @Override
        public TAUri[] newArray(int size) {
            return new TAUri[size];
        }
    };

    /**
     * Constructs a new {@link Builder} from the existing uri by invoking {@link Uri#buildUpon()}
     */
    @NonNull
    public Builder buildUpdon() {
        return new Builder(this.uri.buildUpon());
    }

    /**
     * Invokes {@link Uri#compareTo(Uri)}
     */
    @Override
    public int compareTo(@NonNull TAUri other) {
        return this.uri.compareTo(other.uri);
    }

    /**
     * Invokes {@link Uri#getAuthority()}
     */
    @Nullable
    public String getAuthority() {
        return this.uri.getAuthority();
    }

    /**
     * Invokes {@link Uri#getBooleanQueryParameter(String, boolean)}
     */
    public boolean getBooleanQueryParameter(@NonNull String key, boolean defaultValue) {
        return this.uri.getBooleanQueryParameter(key, defaultValue);
    }

    /**
     * Invokes {@link Uri#getBooleanQueryParameter(String, boolean)}
     */
    @Nullable
    public String getEncodedAuthority() {
        return this.uri.getEncodedAuthority();
    }

    /**
     * Invokes {@link Uri#getEncodedFragment()}
     */
    @Nullable
    public String getEncodedFragment() {
        return this.uri.getEncodedFragment();
    }

    /**
     * Invokes {@link Uri#getEncodedPath()}
     */
    @Nullable
    public String getEncodedPath() {
        return this.uri.getEncodedPath();
    }

    /**
     * Invokes {@link Uri#getEncodedQuery()}
     */
    @Nullable
    public String getEncodedQuery() {
        return this.uri.getEncodedQuery();
    }

    /**
     * Invokes {@link Uri#getEncodedSchemeSpecificPart()}
     */
    @Nullable
    public String getEncodedSchemeSpecificPart() {
        return this.uri.getEncodedSchemeSpecificPart();
    }

    /**
     * Invokes {@link Uri#getEncodedUserInfo()}
     */
    @Nullable
    public String getEncodedUserInfo() {
        return this.uri.getEncodedUserInfo();
    }

    /**
     * Invokes {@link Uri#getFragment()}
     */
    @Nullable
    public String getFragment() {
        return this.uri.getFragment();
    }

    /**
     * Invokes {@link Uri#getHost()}
     */
    @Nullable
    public String getHost() {
        return this.uri.getHost();
    }

    /**
     * Invokes {@link Uri#getLastPathSegment()}
     */
    @Nullable
    public String getLastPathSegment() {
        return this.uri.getLastPathSegment();
    }

    /**
     * Invokes {@link Uri#getPath()}
     */
    @Nullable
    public String getPath() {
        return this.uri.getPath();
    }

    /**
     * Invokes {@link Uri#getPathSegments()}
     */
    @Nullable
    public List<String> getPathSegments() {
        return this.uri.getPathSegments();
    }

    /**
     * Invokes {@link Uri#getPort()}
     */
    public int getPort() {
        return this.uri.getPort();
    }

    /**
     * Invokes {@link Uri#getQuery()}
     */
    @Nullable
    public String getQuery() {
        return this.uri.getQuery();
    }

    /**
     * Invokes {@link Uri#getQueryParameter(String)}
     */
    @Nullable
    public String getQueryParameter(@NonNull String key) {
        return this.uri.getQueryParameter(key);
    }

    /**
     * Invokes {@link Uri#getQueryParameterNames()}
     */
    @Nullable
    public Set<String> getQueryParameterNames() {
        return this.uri.getQueryParameterNames();
    }

    /**
     * Invokes {@link Uri#getQueryParameters(String)}
     */
    @Nullable
    public List<String> getQueryParameters(@NonNull String key) {
        return this.uri.getQueryParameters(key);
    }

    /**
     * Invokes {@link Uri#getScheme()}
     */
    @Nullable
    public String getScheme() {
        return this.uri.getScheme();
    }

    /**
     * Invokes {@link Uri#getSchemeSpecificPart()}
     */
    @Nullable
    public String getSchemeSpecificPart() {
        return this.uri.getSchemeSpecificPart();
    }

    /**
     * Invokes {@link Uri#getUserInfo()}
     */
    @Nullable
    public String getUserInfo() {
        return this.uri.getUserInfo();
    }

    /**
     * Invokes {@link Uri#isAbsolute()}
     */
    public boolean isAbsolute() {
        return this.uri.isAbsolute();
    }

    /**
     * Invokes {@link Uri#isHierarchical()}
     */
    public boolean isHierarchical() {
        return this.uri.isHierarchical();
    }

    /**
     * Invokes {@link Uri#isOpaque()}
     */
    public boolean isOpaque() {
        return this.uri.isOpaque();
    }

    /**
     * Invokes {@link Uri#isRelative()}
     */
    public boolean isRelative() {
        return this.uri.isRelative();
    }

    /**
     * Invokes {@link Uri#normalizeScheme()}
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @NonNull
    public Uri normalizeScheme() {
        return this.uri.normalizeScheme();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TAUri taUri = (TAUri) o;
        return uri.equals(taUri.uri);
    }

    @Override
    public int hashCode() {
        return uri.hashCode();
    }

    /**
     * Invokes {@link Uri#toString()}
     */
    @NonNull
    @Override
    public String toString() {
        return uri.toString();
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(uri, flags);
    }

    public static class Builder {

        @NonNull
        public final Uri.Builder uriBuilder;

        public Builder() {
            this(new Uri.Builder());
        }

        public Builder(@NonNull Uri.Builder uriBuilder) {
            this.uriBuilder = uriBuilder;
        }

        /**
         * Invokes {@link Uri.Builder#appendEncodedPath(String)}
         */
        @NonNull
        public Builder appendEncodedPath(@NonNull String newSegment) {
            this.uriBuilder.appendEncodedPath(newSegment);
            return this;
        }

        /**
         * Invokes {@link Uri.Builder#appendPath(String)}
         */
        @NonNull
        public Builder appendPath(@NonNull String newSegment) {
            this.uriBuilder.appendPath(newSegment);
            return this;
        }

        /**
         * Invokes {@link Uri.Builder#appendQueryParameter(String, String)}
         */
        @NonNull
        public Builder appendQueryParameter(@NonNull String key, @NonNull String value) {
            this.uriBuilder.appendQueryParameter(key, value);
            return this;
        }

        /**
         * Invokes {@link Uri.Builder#authority(String)}
         */
        @NonNull
        public Builder authority(@NonNull String authority) {
            this.uriBuilder.authority(authority);
            return this;
        }

        /**
         * Invokes {@link Uri.Builder#build()}
         */
        @NonNull
        public TAUri build() {
            return new TAUri(this.uriBuilder.build());
        }

        /**
         * Invokes {@link Uri.Builder#clearQuery()}
         */
        @NonNull
        public Builder clearQuery() {
            this.uriBuilder.clearQuery();
            return this;
        }

        /**
         * Invokes {@link Uri.Builder#encodedAuthority(String)}
         */
        @NonNull
        public Builder encodedAuthority(@NonNull String authority) {
            this.uriBuilder.encodedAuthority(authority);
            return this;
        }

        /**
         * Invokes {@link Uri.Builder#encodedFragment(String)}
         */
        @NonNull
        public Builder encodedFragment(@NonNull String fragment) {
            this.uriBuilder.encodedFragment(fragment);
            return this;
        }

        /**
         * Invokes {@link Uri.Builder#encodedOpaquePart(String)}
         */
        @NonNull
        public Builder encodedOpaquePart(@NonNull String opaquePart) {
            this.uriBuilder.encodedOpaquePart(opaquePart);
            return this;
        }

        /**
         * Invokes {@link Uri.Builder#encodedPath(String)}
         */
        @NonNull
        public Builder encodedPath(@NonNull String path) {
            this.uriBuilder.encodedPath(path);
            return this;
        }

        /**
         * Invokes {@link Uri.Builder#encodedQuery(String)}
         */
        @NonNull
        public Builder encodedQuery(@NonNull String encodedQuery) {
            this.uriBuilder.encodedQuery(encodedQuery);
            return this;
        }

        /**
         * Invokes {@link Uri.Builder#fragment(String)}
         */
        @NonNull
        public Builder fragment(@NonNull String fragment) {
            this.uriBuilder.fragment(fragment);
            return this;
        }

        /**
         * Invokes {@link Uri.Builder#opaquePart(String)}
         */
        @NonNull
        public Builder opaquePart(@NonNull String opaquePart) {
            this.uriBuilder.opaquePart(opaquePart);
            return this;
        }

        /**
         * Invokes {@link Uri.Builder#path(String)}
         */
        @NonNull
        public Builder path(@NonNull String path) {
            this.uriBuilder.path(path);
            return this;
        }

        /**
         * Invokes {@link Uri.Builder#query(String)}
         */
        @NonNull
        public Builder query(@NonNull String query) {
            this.uriBuilder.query(query);
            return this;
        }

        /**
         * Invokes {@link Uri.Builder#scheme(String)}
         */
        @NonNull
        public Builder scheme(@NonNull String scheme) {
            this.uriBuilder.scheme(scheme);
            return this;
        }

        /**
         * Invokes {@link Uri.Builder#toString()}
         */
        @NonNull
        @Override
        public String toString() {
            return uriBuilder.toString();
        }
    }
}
