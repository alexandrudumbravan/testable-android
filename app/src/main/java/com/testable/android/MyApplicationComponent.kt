package com.testable.android

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector


@Component(modules = [AndroidInjectionModule::class, MyApplicationModule::class, BindingsModule::class])
interface MyApplicationComponent : AndroidInjector<MyApplication>