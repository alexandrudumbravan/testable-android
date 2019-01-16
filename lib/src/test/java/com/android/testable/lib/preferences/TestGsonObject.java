package com.android.testable.lib.preferences;

import com.google.gson.annotations.SerializedName;

public class TestGsonObject {
    @SerializedName("name")
    private String name;
    @SerializedName("test")
    private String test;

    public TestGsonObject(String name, String test) {
        this.name = name;
        this.test = test;
    }

    public String getName() {
        return name;
    }

    public String getTest() {
        return test;
    }
}
