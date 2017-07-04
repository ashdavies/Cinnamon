package io.ashdavies.cinnamon.account

import android.app.Activity
import android.content.Intent
import com.google.android.gms.vision.barcode.Barcode
import io.ashdavies.cinnamon.barcode.BarcodeCaptureActivity
import io.ashdavies.cinnamon.barcode.BarcodePreferenceStorage
import io.ashdavies.cinnamon.presenter.AbstractViewPresenter
import timber.log.Timber
import javax.inject.Inject

internal class AccountPresenter @Inject internal constructor(view: AccountView, val navigation: AccountNavigation, val storage: BarcodePreferenceStorage) : AbstractViewPresenter<AccountView>(view) {

  internal fun onBarcodeResult(resultCode: Int, data: Intent) {
    if (resultCode != Activity.RESULT_OK) {
      return
    }

    onBarcodeResult(BarcodeCaptureActivity.fromResult(data))
  }

  private fun onBarcodeResult(barcode: Barcode) {
    try {
      storage.put(barcode)
    } catch (exception: Exception) {
      Timber.e(exception)
    }
  }

  internal fun onGoogleLogin() {
    navigation.navigateToSignIn()
  }
}
