package com.testable.android

import com.android.testable.lib.crypto.InvalidEncryptionException
import com.android.testable.lib.preferences.EncryptableSharedPreferences

class AppPreferences1(private val encryptableSharedPrefs: EncryptableSharedPreferences) {

    companion object {
        private const val KEY_DATA_1 = "data1"
        private const val KEY_DATA_2 = "data2"
    }


    fun putData1(data1: String) {
        encryptableSharedPrefs.putString(KEY_DATA_1, data1)
    }

    fun putData2(data2: String) {
        encryptableSharedPrefs.putEncryptedString(KEY_DATA_2, data2)
    }

    fun getData1(): String {
        return encryptableSharedPrefs.getString(KEY_DATA_1, "").orEmpty()
    }

    fun getData2(): String {
        return try {
            encryptableSharedPrefs.getEncryptedString(KEY_DATA_2).orEmpty()
        } catch (e: InvalidEncryptionException) {
            ""
        }
    }
}