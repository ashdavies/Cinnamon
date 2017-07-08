package io.ashdavies.cinnamon.google

import android.app.Application
import android.content.Intent
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.GoogleApiClient
import io.ashdavies.cinnamon.R
import io.ashdavies.cinnamon.android.StringResolver
import javax.inject.Inject

class GoogleSignInClient @Inject internal constructor(application: Application, resolver: StringResolver) : GoogleApiProcessor() {

  private val client: GoogleApiClient

  init {
    client = GoogleApiClient.Builder(application)
        .addConnectionCallbacks(this)
        .addOnConnectionFailedListener(this)
        .addApi(Auth.GOOGLE_SIGN_IN_API, createGoogleSignInOptions(resolver))
        .build()
  }

  private fun createGoogleSignInOptions(resolver: StringResolver): GoogleSignInOptions {
    return GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken(resolver.get(R.string.default_web_client_id))
        .requestEmail()
        .build()
  }

  fun getSignInIntent(): Intent {
    return Auth.GoogleSignInApi.getSignInIntent(client)
  }

  internal fun signOut() {
    Auth.GoogleSignInApi.signOut(client)
  }

  public override fun connect() {
    client.connect()
  }

  public override fun disconnect() {
    client.disconnect()
  }
}
