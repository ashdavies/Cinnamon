package io.ashdavies.cinnamon.google

import com.google.android.gms.auth.api.signin.GoogleSignInResult

class GoogleSignInException(val result: GoogleSignInResult) : Throwable(result.status.statusMessage)
