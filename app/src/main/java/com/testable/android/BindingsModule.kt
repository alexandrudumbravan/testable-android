package com.testable.android

import com.testable.android.fragment.MvpFragment
import com.testable.android.fragment.MvpFragmentModule
import com.testable.android.mvp.MvpActivity
import com.testable.android.mvp.MvpModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BindingsModule {

    @ContributesAndroidInjector(modules = [MvpModule::class])
    @ActivityScope
    abstract fun bindMvpActivity(): MvpActivity

    @ContributesAndroidInjector(modules = [MvpFragmentModule::class])
    @FragmentScope
    abstract fun bindMvpFragment(): MvpFragment
}