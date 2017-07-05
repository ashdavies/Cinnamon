package io.ashdavies.cinnamon.account

import android.app.Activity
import android.content.Intent
import io.ashdavies.cinnamon.barcode.BarcodeCaptureActivity
import io.ashdavies.cinnamon.barcode.BarcodePreferenceStorage
import io.ashdavies.cinnamon.presenter.AbstractViewPresenter
import javax.inject.Inject

internal class AccountPresenter @Inject internal constructor(view: AccountView, val navigation: AccountNavigation, val storage: BarcodePreferenceStorage) : AbstractViewPresenter<AccountView>(view) {

  internal fun onGoogleSignIn() {
    navigation.navigateToGoogleSignIn()
  }

  internal fun onKrakenSignIn() {
    navigation.navigateToBarcodeCapture()
  }

  internal fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
    if (navigation.isFromGoogleSignIn(requestCode)) {
      onGoogleSignInResult(resultCode, data)
      return
    }

    if (navigation.isFromBarcodeCapture(requestCode)) {
      onBarcodeCaptureResult(resultCode, data)
    }
  }

  private fun onGoogleSignInResult(resultCode: Int, data: Intent) {
    if (resultCode != Activity.RESULT_OK) {
      return
    }

    throw NotImplementedError()
  }

  private fun onBarcodeCaptureResult(resultCode: Int, data: Intent) {
    if (resultCode != Activity.RESULT_OK) {
      return
    }

    storage.put(BarcodeCaptureActivity.fromResult(data))
  }
}
