package com.testable.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.testable.android.mvp.MvpActivity

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        startActivity(MvpActivity.newIntent(this, "this is an extra param"))
    }
}