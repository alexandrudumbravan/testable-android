package com.testable.android.mvp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.testable.lib.app.TAIntent
import com.android.testable.lib.os.TABundle
import com.testable.android.R
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_mvp.*
import javax.inject.Inject

class MvpActivity : AppCompatActivity(), MvpView {

    companion object {
        private const val EXTRA_TEXT = MvpPresenter.EXTRA_TEXT

        fun newIntent(context: Context, text: String): Intent {
            return Intent(context, MvpActivity::class.java).putExtra(EXTRA_TEXT, text)
        }
    }

    @Inject
    lateinit var presenter: MvpPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp)
        presenter.onIntentReady(TAIntent(intent))
        activity_mvp_button.setOnClickListener {
            presenter.handleButtonClick()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        presenter.onActivityResult(requestCode, resultCode, TAIntent(data))
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        presenter.onSaveInstanceState(TABundle(outState))
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        presenter.onRestoreInstanceState(TABundle(savedInstanceState))
    }

    override fun showText(text: String) {
        activity_mvp_text_view.text = text
    }
}