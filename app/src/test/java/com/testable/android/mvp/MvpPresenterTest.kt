package com.testable.android.mvp

import com.android.testable.lib.app.*
import com.android.testable.lib.os.TABundle
import com.android.testable.lib.res.TAResources
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.testable.android.AppPreferences2
import com.testable.android.Navigator
import com.testable.android.R
import org.junit.Before
import org.junit.Test

class MvpPresenterTest {

    private lateinit var subject: MvpPresenter
    private val mvpView = mock<MvpView>()
    private val componentStarter = mock<ActivityComponentStarter>()
    private val taResources = mock<TAResources>()
    private val taIntentHelper = mock<TAIntentHelper>()
    private val navigator = mock<Navigator>()
    private val appPreferences2 = mock<AppPreferences2>()


    @Before
    fun setUp() {
        subject = MvpPresenter(mvpView, componentStarter, taResources, taIntentHelper, navigator, appPreferences2)
    }

    @Test
    fun onIntentReady() {
        val taIntent = mock<TAIntent>()
        val extras = mock<TABundle>()
        val text = "text"
        val formattedText = "formattedText"
        whenever(taIntent.extras).thenReturn(extras)
        whenever(extras.getString(MvpPresenter.EXTRA_TEXT, "")).thenReturn(text)
        whenever(taResources.getString(R.string.test_format_string, text)).thenReturn(formattedText)
        subject.onIntentReady(taIntent)
        verify(mvpView).showText(formattedText)
    }

    @Test
    fun handleButtonClick() {
        val pickPhotoIntent = mock<TAIntent>()
        val chooserIntent = mock<TAIntent>()
        val pickPhotoTitle = "pickPhotoTitle"
        whenever(taResources.getString(R.string.select_picture)).thenReturn(pickPhotoTitle)
        whenever(navigator.createPickPhotoIntent()).thenReturn(pickPhotoIntent)
        whenever(taIntentHelper.createChooser(pickPhotoIntent, pickPhotoTitle)).thenReturn(chooserIntent)
        subject.handleButtonClick()
        verify(componentStarter).startActivityForResult(chooserIntent, MvpPresenter.REQUEST_CODE_PICK_IMAGE)
    }

    @Test
    fun onActivityResult() {
        val data = mock<TAIntent>()
        val uri = mock<TAUri>()
        val text = "text"
        val formattedText = "formattedText"
        whenever(data.data).thenReturn(uri)
        whenever(uri.toString()).thenReturn(text)
        whenever(taResources.getString(R.string.test_format_string, text)).thenReturn(formattedText)
        subject.onActivityResult(MvpPresenter.REQUEST_CODE_PICK_IMAGE, ComponentStarter.ACTIVITY_RESULT_OK, data)
        verify(mvpView).showText(formattedText)

    }

    @Test
    fun onRestoreInstanceState() {
        val state = mock<TABundle>()
        val uri = mock<TAUri>()
        val text = "text"
        val formattedText = "formattedText"
        whenever(state.getParcelable<TAUri>(MvpPresenter.STATE_URI)).thenReturn(uri)
        whenever(uri.toString()).thenReturn(text)
        whenever(taResources.getString(R.string.test_format_string, text)).thenReturn(formattedText)
        subject.onRestoreInstanceState(state)
        verify(mvpView).showText(formattedText)
    }

    @Test
    fun onSaveInstanceState() {
        val outState = mock<TABundle>()
        val inState = mock<TABundle>()
        val uri = mock<TAUri>()
        val text = "text"
        val formattedText = "formattedText"
        whenever(uri.toString()).thenReturn(text)
        whenever(taResources.getString(R.string.test_format_string, text)).thenReturn(formattedText)
        whenever(inState.getParcelable<TAUri>(MvpPresenter.STATE_URI)).thenReturn(uri)

        subject.onRestoreInstanceState(inState)
        subject.onSaveInstanceState(outState)
        verify(outState).putParcelable(MvpPresenter.STATE_URI, uri)
    }

    @Test
    fun requestPermission_granted() {
        val permission = TAAndroidPermissions.READ_EXTERNAL_STORAGE
        val text = "text"
        whenever(componentStarter.isGrantedPermission(permission)).thenReturn(true)
        whenever(taResources.getString(R.string.permission_already_granted)).thenReturn(text)
        subject.requestPermission()
        verify(mvpView).showToast(text)
    }

    @Test
    fun requestPermission_denied() {
        val permission = TAAndroidPermissions.READ_EXTERNAL_STORAGE
        whenever(componentStarter.isGrantedPermission(permission)).thenReturn(false)
        subject.requestPermission()
        verify(componentStarter).requestPermissions(arrayOf(permission), MvpPresenter.REQUEST_CODE_PERMISSION)
    }

    @Test
    fun onPermissionGranted_granted() {
        val text = "text"
        whenever(taResources.getString(R.string.permission_granted)).thenReturn(text)
        subject.onPermissionGranted(
            MvpPresenter.REQUEST_CODE_PERMISSION,
            arrayOf(TAAndroidPermissions.READ_EXTERNAL_STORAGE),
            intArrayOf(TAAndroidPermissions.PERMISSION_GRANTED)
        )
        verify(mvpView).showToast(text)
    }

    @Test
    fun onPermissionGranted_rejected() {
        val text = "text"
        whenever(taResources.getString(R.string.permission_denied)).thenReturn(text)
        subject.onPermissionGranted(
            MvpPresenter.REQUEST_CODE_PERMISSION,
            arrayOf(TAAndroidPermissions.READ_EXTERNAL_STORAGE),
            intArrayOf(TAAndroidPermissions.PERMISSION_DENIED)
        )
        verify(mvpView).showToast(text)
    }
}