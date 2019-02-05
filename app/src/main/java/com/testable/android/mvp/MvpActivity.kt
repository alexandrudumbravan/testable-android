package com.testable.android.mvp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.testable.android.R
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_mvp.*
import javax.inject.Inject

class MvpActivity : AppCompatActivity(), MvpView {

    @Inject
    lateinit var presenter: MvpPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp)
        presenter.load()
        presenter.startActivity()
    }

    override fun showText(text: String) {
        activity_mvp_text_view.text = text
    }
}