package com.testable.android.fragment

import com.android.testable.lib.app.FragmentComponentStarter
import com.android.testable.lib.app.TAIntentHelper
import com.android.testable.lib.res.TAResources
import com.testable.android.AppPreferences1
import com.testable.android.FragmentScope
import com.testable.android.Navigator
import dagger.Module
import dagger.Provides

@Module
class MvpFragmentModule {

    @FragmentScope
    @Provides
    fun providesMvpFragmentView(mvpFragment: MvpFragment): MvpFragmentView = mvpFragment

    @FragmentScope
    @Provides
    fun providesFragmentComponentStarter(mvpFragment: MvpFragment) = FragmentComponentStarter.create(mvpFragment)

    @FragmentScope
    @Provides
    fun providesNavigator(componentStarter: FragmentComponentStarter) = Navigator(componentStarter)

    @FragmentScope
    @Provides
    fun providesMvpFragmentPresenter(
        mvpFragmentView: MvpFragmentView,
        fragmentComponentStarter: FragmentComponentStarter,
        taResources: TAResources,
        taIntentHelper: TAIntentHelper,
        navigator: Navigator,
        appPreferences1: AppPreferences1
    ) = MvpFragmentPresenter(
        mvpFragmentView,
        fragmentComponentStarter,
        taResources,
        taIntentHelper,
        navigator,
        appPreferences1
    )
}