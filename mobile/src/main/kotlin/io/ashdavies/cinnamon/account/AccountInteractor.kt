package io.ashdavies.cinnamon.account

import io.ashdavies.rx.rxfirebase.RxFirebaseAuth
import javax.inject.Inject

internal class AccountInteractor @Inject constructor(val auth: RxFirebaseAuth)
