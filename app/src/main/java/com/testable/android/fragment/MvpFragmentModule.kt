package com.testable.android.fragment

import com.android.testable.lib.app.FragmentComponentStarter
import com.android.testable.lib.app.TAIntentHelper
import com.android.testable.lib.res.TAResources
import com.testable.android.FragmentScope
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
    fun providesMvpFragmentPresenter(
        mvpFragmentView: MvpFragmentView,
        fragmentComponentStarter: FragmentComponentStarter,
        taResources: TAResources,
        taIntentHelper: TAIntentHelper
    ) = MvpFragmentPresenter(mvpFragmentView, fragmentComponentStarter, taResources, taIntentHelper)
}