package io.ashdavies.cinnamon.account

import android.app.Activity
import android.content.Intent
import com.google.android.gms.auth.api.Auth
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import io.ashdavies.cinnamon.barcode.BarcodeCaptureActivity
import io.ashdavies.cinnamon.barcode.BarcodePreferenceStorage
import io.ashdavies.cinnamon.google.GoogleSignInException
import io.ashdavies.cinnamon.presenter.AbstractViewPresenter
import javax.inject.Inject

internal class AccountPresenter @Inject internal constructor(
    val view: AccountView,
    val navigation: AccountNavigation,
    val accounts: AccountRepository,
    val credentials: BarcodePreferenceStorage
) : AbstractViewPresenter<AccountView>(view) {

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
      view.onError(SignInFailedException())
      return
    }

    val result = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
    if (result.isSuccess) {
      view.onError(GoogleSignInException(result))
      return
    }

    FirebaseAuth.getInstance()
        .signInWithCredential(GoogleAuthProvider.getCredential(result.signInAccount?.idToken, null))
        .addOnSuccessListener { result ->
          accounts.store(result.user)
          navigation.navigateToHome()
        }
        .addOnFailureListener { throwable -> view.onError(throwable) }
  }

  private fun onBarcodeCaptureResult(resultCode: Int, data: Intent) {
    if (resultCode != Activity.RESULT_OK) {
      return
    }

    credentials.put(BarcodeCaptureActivity.fromResult(data))
  }
}
