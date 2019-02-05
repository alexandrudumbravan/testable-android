package com.testable.android

import com.testable.android.mvp.MvpActivity
import com.testable.android.mvp.MvpModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BindingsModule {

    @ContributesAndroidInjector(modules = [MvpModule::class])
    abstract fun bindMvpActivity(): MvpActivity
}