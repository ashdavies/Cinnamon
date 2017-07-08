package io.ashdavies.cinnamon.account

import android.app.Activity
import android.content.Intent
import io.ashdavies.cinnamon.barcode.BarcodeOnboardingActivity
import io.ashdavies.cinnamon.common.Navigator
import io.ashdavies.cinnamon.google.GoogleSignInClient
import io.ashdavies.cinnamon.home.HomeActivity
import javax.inject.Inject

internal class AccountNavigation @Inject constructor(val navigator: Navigator, val client: GoogleSignInClient) {

  internal fun navigateToGoogleSignIn() {
    navigator.navigate { activity -> activity.startActivityForResult(client.getSignInIntent(), REQUEST_CODE_GOOGLE_SIGN_IN) }
  }

  internal fun isFromGoogleSignIn(requestCode: Int): Boolean {
    return requestCode == REQUEST_CODE_GOOGLE_SIGN_IN
  }

  internal fun navigateToBarcodeCapture() {
    navigator.navigate { activity -> activity.startActivityForResult(BarcodeOnboardingActivity::class.java, REQUEST_CODE_BARCODE_CAPTURE) }
  }

  internal fun isFromBarcodeCapture(requestCode: Int): Boolean {
    return requestCode == REQUEST_CODE_BARCODE_CAPTURE
  }

  internal fun navigateToHome() {
    navigator.navigate { activity -> activity.startActivity(HomeActivity::class.java) }
  }

  private fun Activity.startActivity(kls: Class<out Activity>) {
    startActivity(Intent(this, kls))
  }

  private fun Activity.startActivityForResult(kls: Class<out Activity>, requestCode: Int) {
    startActivityForResult(Intent(this, kls), requestCode)
  }

  companion object {
    private val REQUEST_CODE_GOOGLE_SIGN_IN = 0x91
    private val REQUEST_CODE_BARCODE_CAPTURE = 0x92

  }
}
