package com.testable.android.mvp

import com.android.testable.lib.app.ActivityComponentStarter
import com.android.testable.lib.app.TAUriHelper
import com.android.testable.lib.res.TAResources
import dagger.Module
import dagger.Provides

@Module
class MvpModule {

    @Provides
    fun providesMvpView(mvpActivity: MvpActivity): MvpView = mvpActivity

    @Provides
    fun providesActivityComponentStarter(mvpActivity: MvpActivity) = ActivityComponentStarter.create(mvpActivity)

    @Provides
    fun providesMvpPresenter(
        mvpView: MvpView,
        activityComponentStarter: ActivityComponentStarter,
        taResources: TAResources,
        taUriHelper: TAUriHelper
    ) = MvpPresenter(mvpView, activityComponentStarter, taResources, taUriHelper)
}