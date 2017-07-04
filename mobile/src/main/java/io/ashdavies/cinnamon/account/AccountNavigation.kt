package io.ashdavies.cinnamon.account

import io.ashdavies.cinnamon.common.Navigator
import io.ashdavies.cinnamon.google.GoogleSignInClient
import javax.inject.Inject

internal class AccountNavigation @Inject constructor(val navigator: Navigator, val client: GoogleSignInClient) {

  fun navigateToSignIn() {
    navigator.navigate { activity -> activity.startActivityForResult(client.signInIntent, RC_SIGN_IN) }
  }

  companion object {

    private val RC_SIGN_IN = 0x91
  }
}
