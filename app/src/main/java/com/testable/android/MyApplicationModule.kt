package com.testable.android

import android.content.Context
import com.android.testable.lib.app.TAIntentHelper
import com.android.testable.lib.app.TAUriHelper
import com.android.testable.lib.res.TAResources
import dagger.Module
import dagger.Provides

@Module
class MyApplicationModule(private val context: Context) {

    @Provides
    fun providesContext() = context

    @Provides
    fun providesTAResources(context: Context) = TAResources(context)

    @Provides
    fun providesTAIntentHelper() = TAIntentHelper()

    @Provides
    fun providesTAUriHelper() = TAUriHelper()

}