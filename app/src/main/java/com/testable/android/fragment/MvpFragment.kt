package com.testable.android.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.testable.lib.app.TAIntent
import com.android.testable.lib.os.TABundle
import com.testable.android.R
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_mvp.*
import javax.inject.Inject

class MvpFragment : Fragment(), MvpFragmentView {

    companion object {
        private const val ARG_TEXT = MvpFragmentPresenter.ARG_TEXT

        fun newInstance(text: String): MvpFragment {
            val fragment = MvpFragment()
            val arguments = Bundle()
            arguments.putString(ARG_TEXT, text)
            fragment.arguments = arguments
            return fragment
        }
    }

    @Inject
    lateinit var mvpFragmentPresenter: MvpFragmentPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_mvp, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mvpFragmentPresenter.onArgumentsReady(TABundle(arguments))
        mvpFragmentPresenter.onRestoreInstanceState(TABundle(savedInstanceState))
        fragment_mvp_button.setOnClickListener {
            mvpFragmentPresenter.handleButtonClick()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mvpFragmentPresenter.onSaveInstanceState(TABundle(outState))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        mvpFragmentPresenter.onActivityResult(requestCode, resultCode, TAIntent(data))
    }

    override fun showText(text: String) {
        fragment_mvp_text_view.text = text
    }
}