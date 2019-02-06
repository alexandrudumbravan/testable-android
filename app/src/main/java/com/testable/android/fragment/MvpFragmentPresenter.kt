package com.testable.android.fragment

import com.android.testable.lib.app.*
import com.android.testable.lib.os.TABundle
import com.android.testable.lib.presentable.Argumentable
import com.android.testable.lib.presentable.Resultable
import com.android.testable.lib.presentable.StateSavable
import com.android.testable.lib.res.TAResources
import com.testable.android.BuildConfig
import com.testable.android.R

class MvpFragmentPresenter(
    private val mvpFragmentView: MvpFragmentView,
    private val fragmentComponentStarter: FragmentComponentStarter,
    private val taResources: TAResources,
    private val taIntentHelper: TAIntentHelper
) : Argumentable, StateSavable, Resultable {

    companion object {
        const val ARG_TEXT = BuildConfig.APPLICATION_ID + ".arg.Mvp.TEXT"

        private const val REQUEST_CODE_PICK_IMAGE = 100
        private const val STATE_URI = "state_uri"
    }

    private var uri: TAUri? = null

    override fun onArgumentsReady(arguments: TABundle) {
        mvpFragmentView.showText(arguments.getString(ARG_TEXT, "").orEmpty())
    }

    override fun onSaveInstanceState(outState: TABundle) {
        outState.putParcelable(STATE_URI, uri)
    }

    override fun onRestoreInstanceState(savedInstanceState: TABundle) {
        uri = savedInstanceState.getParcelable(STATE_URI)
        updateText()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: TAIntent) {
        when (requestCode) {
            REQUEST_CODE_PICK_IMAGE -> {
                if (resultCode == ComponentStarter.ACTIVITY_RESULT_OK) {
                    uri = data.data
                    updateText()
                }
            }
        }
    }

    fun handleButtonClick() {
        val intent = fragmentComponentStarter.createIntent()
        intent.type = "image/*"
        intent.setAction(TAIntent.ACTION_GET_CONTENT)
        fragmentComponentStarter.startActivityForResult(
            taIntentHelper.createChooser(
                intent,
                taResources.getString(R.string.select_picture)
            ), REQUEST_CODE_PICK_IMAGE
        )
    }

    private fun updateText() {
        uri?.let {
            mvpFragmentView.showText(taResources.getString(R.string.test_format_string, it.toString()))
        }
    }
}