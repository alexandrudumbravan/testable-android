package com.testable.android

import com.android.testable.lib.preferences.TASharedPreferences
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class AppPreferences2Test {

    private lateinit var subject: AppPreferences2
    private val taSharedPreferences = mock<TASharedPreferences>()

    @Before
    fun setUp() {
        subject = AppPreferences2(taSharedPreferences)
    }

    @Test
    fun putData() {
        val data = mock<MyObject>()
        subject.putData(data)
        verify(taSharedPreferences).putObject(AppPreferences2.KEY_OBJECT, data)
    }

    @Test
    fun getData() {
        val data = mock<MyObject>()
        whenever(taSharedPreferences.getObject(AppPreferences2.KEY_OBJECT, MyObject::class.java)).thenReturn(data)
        assertEquals(data, subject.getData())
    }
}