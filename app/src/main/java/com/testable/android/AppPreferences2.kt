package com.testable.android

import com.android.testable.lib.preferences.TASharedPreferences

class AppPreferences2(private val taSharedPreferences: TASharedPreferences) {

    companion object {
        internal const val KEY_OBJECT = "object"
    }

    fun putData(myObject: MyObject) {
        taSharedPreferences.putObject(KEY_OBJECT, myObject)
    }

    fun getData(): MyObject? {
        return taSharedPreferences.getObject(KEY_OBJECT, MyObject::class.java)
    }
}