package com.testable.android

import com.android.testable.lib.app.ComponentStarter
import com.android.testable.lib.app.TAIntent

class Navigator(private val componentStarter: ComponentStarter<*>) {


    fun createPickPhotoIntent(): TAIntent {
        val intent = componentStarter.createIntent()
        intent.type = "image/*"
        intent.setAction(TAIntent.ACTION_GET_CONTENT)
        return intent
    }
}