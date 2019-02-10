package com.testable.android

import com.google.gson.annotations.SerializedName

data class MyObject(
    @SerializedName("test1") val test1: String,
    @SerializedName("test2") val test2: String
)