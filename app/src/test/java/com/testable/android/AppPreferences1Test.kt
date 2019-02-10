package com.testable.android

import com.android.testable.lib.preferences.EncryptableSharedPreferences
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class AppPreferences1Test {

    private lateinit var subject: AppPreferences1
    private val encryptableSharedPreferences = mock<EncryptableSharedPreferences>()

    @Before
    fun setUp() {
        subject = AppPreferences1(encryptableSharedPreferences)
    }

    @Test
    fun putData1() {
        val data = "data"
        subject.putData1(data)
        verify(encryptableSharedPreferences).putString(AppPreferences1.KEY_DATA_1, data)
    }

    @Test
    fun putData2() {
        val data = "data"
        subject.putData2(data)
        verify(encryptableSharedPreferences).putEncryptedString(AppPreferences1.KEY_DATA_2, data)
    }

    @Test
    fun getData1() {
        val data = "data"
        whenever(encryptableSharedPreferences.getString(AppPreferences1.KEY_DATA_1,"")).thenReturn(data)
        assertEquals(data, subject.getData1())
    }

    @Test
    fun getData2() {
        val data = "data"
        whenever(encryptableSharedPreferences.getEncryptedString(AppPreferences1.KEY_DATA_2)).thenReturn(data)
        assertEquals(data, subject.getData2())
    }
}