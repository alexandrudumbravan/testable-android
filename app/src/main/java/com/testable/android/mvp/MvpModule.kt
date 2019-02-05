package com.testable.android.mvp

import com.android.testable.lib.app.ActivityComponentStarter
import com.android.testable.lib.app.TAIntentHelper
import com.android.testable.lib.res.TAResources
import com.testable.android.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class MvpModule {

    @ActivityScope
    @Provides
    fun providesMvpView(mvpActivity: MvpActivity): MvpView = mvpActivity

    @ActivityScope
    @Provides
    fun providesActivityComponentStarter(mvpActivity: MvpActivity) = ActivityComponentStarter.create(mvpActivity)

    @ActivityScope
    @Provides
    fun providesMvpPresenter(
        mvpView: MvpView,
        activityComponentStarter: ActivityComponentStarter,
        taResources: TAResources,
        taIntentHelper: TAIntentHelper
    ) = MvpPresenter(mvpView, activityComponentStarter, taResources, taIntentHelper)
}