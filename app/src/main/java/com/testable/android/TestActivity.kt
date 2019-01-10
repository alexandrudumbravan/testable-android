package com.testable.android

import android.os.Bundle
import android.text.format.DateUtils
import androidx.appcompat.app.AppCompatActivity
import com.android.testable.lib.crypto.CertProperties
import com.android.testable.lib.preferences.EncryptableSharedPreferences
import kotlinx.android.synthetic.main.activity_test.*
import java.math.BigInteger
import java.util.*

class TestActivity : AppCompatActivity() {

    private lateinit var prefs: EncryptableSharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        val currentTime = System.currentTimeMillis()
        var text = "123"
        prefs = EncryptableSharedPreferences.createDefaultSharedPrefs(
            applicationContext, "bla", CertProperties(
                "alias",
                Date(currentTime),
                Date(currentTime + DateUtils.YEAR_IN_MILLIS * 2),
                BigInteger("12347")
            )
        )
       // prefs.putEncryptedString("key", "Great success")
        text = prefs.getEncryptedString("key", "default").orEmpty()

        activity_test_text_view.text = text
    }
}