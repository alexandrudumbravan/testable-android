package com.testable.android

import com.android.testable.lib.app.ComponentStarter
import com.android.testable.lib.app.TAIntent
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class NavigatorTest {

    private lateinit var subject: Navigator
    private val componentStarter = mock<ComponentStarter<*>>()

    @Before
    fun setUp() {
        subject = Navigator(componentStarter)
    }

    @Test
    fun createPickPhotoIntent() {
        val intent = mock<TAIntent>()
        whenever(componentStarter.createIntent()).thenReturn(intent)
        val result = subject.createPickPhotoIntent()
        assertEquals(intent, result)
        verify(intent).type = "image/*"
        verify(intent).setAction(TAIntent.ACTION_GET_CONTENT)
    }
}