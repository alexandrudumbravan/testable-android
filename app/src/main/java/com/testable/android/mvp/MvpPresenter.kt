package com.testable.android.mvp

import com.android.testable.lib.app.ActivityComponentStarter
import com.android.testable.lib.app.TAIntent
import com.android.testable.lib.app.TAUriHelper
import com.android.testable.lib.res.TAResources
import com.testable.android.R

class MvpPresenter(
    private val mvpView: MvpView,
    private val componentStarter: ActivityComponentStarter,
    private val taReources: TAResources,
    private val taUriHelper: TAUriHelper
) {

    fun load() {
        mvpView.showText(taReources.getString(R.string.app_name))
    }

    fun startActivity() {
        val intent = componentStarter.createIntent(TAIntent.ACTION_VIEW)
        intent.data = taUriHelper.parse("https://www.google.com")
        componentStarter.startActivity(intent)
    }
}