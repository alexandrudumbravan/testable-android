package com.android.testable.lib.util;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@IntDef({TABase64.DEFAULT, TABase64.NO_PADDING, TABase64.NO_WRAP, TABase64.CRLF, TABase64.URL_SAFE, TABase64.NO_CLOSE})
public @interface Base64Flag {
}
