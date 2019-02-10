package com.testable.android

import android.content.Context
import android.text.format.DateUtils
import com.android.testable.lib.app.TAIntentHelper
import com.android.testable.lib.app.TAUriHelper
import com.android.testable.lib.crypto.CertProperties
import com.android.testable.lib.preferences.EncryptableSharedPreferences
import com.android.testable.lib.preferences.TASharedPreferences
import com.android.testable.lib.res.TAResources
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import java.math.BigInteger
import java.util.*

@Module
class MyApplicationModule(private val context: Context) {

    @Provides
    fun providesContext() = context

    @Provides
    fun providesTAResources(context: Context) = TAResources(context)

    @Provides
    fun providesTAIntentHelper() = TAIntentHelper()

    @Provides
    fun providesTAUriHelper() = TAUriHelper()

    @Provides
    fun providesCertificateProperties(): CertProperties {
        val currentTime = System.currentTimeMillis()

        return CertProperties(
            "myAlias",
            Date(currentTime - DateUtils.YEAR_IN_MILLIS),
            Date(currentTime + DateUtils.YEAR_IN_MILLIS),
            BigInteger("12345")
        )
    }

    @AppPrefs1
    @Provides
    fun providesTaSharedPrefs1(context: Context, certProperties: CertProperties) =
        EncryptableSharedPreferences.createDefaultSharedPrefs(context, "app_prefs1", certProperties)

    @AppPrefs2
    @Provides
    fun providesTaSharedPrefs2(context: Context) =
        TASharedPreferences(context, "app_prefs2", TASharedPreferences.MODE_PRIVATE, Gson())

    @Provides
    fun providesAppPrefs1(@AppPrefs1 encryptableSharedPreferences: EncryptableSharedPreferences) =
        AppPreferences1(encryptableSharedPreferences)

    @Provides
    fun providesAppPrefs2(@AppPrefs2 taSharedPreferences: TASharedPreferences) =
        AppPreferences2(taSharedPreferences)

}