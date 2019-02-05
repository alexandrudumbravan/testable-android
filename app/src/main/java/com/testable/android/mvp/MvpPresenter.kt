package com.testable.android.mvp

import com.android.testable.lib.app.*
import com.android.testable.lib.os.TABundle
import com.android.testable.lib.presentable.Intentable
import com.android.testable.lib.presentable.Resultable
import com.android.testable.lib.presentable.StateSavable
import com.android.testable.lib.res.TAResources
import com.testable.android.BuildConfig
import com.testable.android.R


class MvpPresenter(
    private val mvpView: MvpView,
    private val componentStarter: ActivityComponentStarter,
    private val taResources: TAResources,
    private val taIntentHelper: TAIntentHelper
) : Intentable, StateSavable, Resultable {

    companion object {
        const val EXTRA_TEXT = BuildConfig.APPLICATION_ID + ".extras.Mvp.TEXT"

        private const val REQUEST_CODE_PICK_IMAGE = 100
        private const val STATE_URI = "state_uri"
    }

    private var uri: TAUri? = null

    override fun onIntentReady(taIntent: TAIntent) {
        val extras = taIntent.extras
        val text = extras?.getString(EXTRA_TEXT, "").orEmpty()
        mvpView.showText(taResources.getString(R.string.test_format_string, text))
    }

    fun handleButtonClick() {
        val intent = componentStarter.createIntent()
        intent.type = "image/*"
        intent.setAction(TAIntent.ACTION_GET_CONTENT)
        componentStarter.startActivityForResult(
            taIntentHelper.createChooser(
                intent,
                taResources.getString(R.string.select_picture)
            ), REQUEST_CODE_PICK_IMAGE
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, taIntent: TAIntent) {
        when (requestCode) {
            REQUEST_CODE_PICK_IMAGE -> {
                if (resultCode == ComponentStarter.ACTIVITY_RESULT_OK) {
                    uri = taIntent.data
                    updateText()
                }
            }
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: TABundle) {
        uri = savedInstanceState.getParcelable(STATE_URI)
        updateText()
    }

    override fun onSaveInstanceState(savedInstanceState: TABundle) {
        savedInstanceState.putParcelable(STATE_URI, uri)
    }

    private fun updateText() {
        uri?.let {
            mvpView.showText(taResources.getString(R.string.test_format_string, it.toString()))
        }
    }
}