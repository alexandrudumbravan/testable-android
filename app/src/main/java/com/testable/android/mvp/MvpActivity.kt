package com.testable.android.mvp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.android.testable.lib.app.TAIntent
import com.android.testable.lib.os.TABundle
import com.testable.android.R
import com.testable.android.fragment.MvpFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_mvp.*
import javax.inject.Inject

class MvpActivity : AppCompatActivity(), MvpView, HasSupportFragmentInjector {

    companion object {
        private const val EXTRA_TEXT = MvpPresenter.EXTRA_TEXT

        fun newIntent(context: Context, text: String): Intent {
            return Intent(context, MvpActivity::class.java).putExtra(EXTRA_TEXT, text)
        }
    }

    @Inject
    lateinit var presenter: MvpPresenter
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.activity_mvp_content_frame, MvpFragment.newInstance("fragment text"))
                .commit()
        }

        presenter.onIntentReady(TAIntent(intent))
        activity_mvp_button.setOnClickListener {
            presenter.handleButtonClick()
        }
        activity_mvp_permission_button.setOnClickListener {
            presenter.requestPermission()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        presenter.onActivityResult(requestCode, resultCode, TAIntent(data))
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        presenter.onPermissionGranted(requestCode, permissions, grantResults)
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

    override fun showToast(text: String) {
        Toast.makeText(applicationContext, text, Toast.LENGTH_LONG).show()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjector
}