package com.testable.android

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.testable.lib.preferences.EncryptableSharedPreferences
import com.testable.android.mvp.MvpActivity

class TestActivity : AppCompatActivity() {

    private lateinit var prefs: EncryptableSharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        startActivity(Intent(this, MvpActivity::class.java))
    }
}