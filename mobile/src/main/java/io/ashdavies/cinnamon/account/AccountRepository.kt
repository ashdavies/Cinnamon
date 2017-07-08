package io.ashdavies.cinnamon.account

import com.google.firebase.auth.FirebaseUser
import io.ashdavies.rx.rxfirebase.RxFirebaseDatabase
import io.reactivex.Completable
import javax.inject.Inject

class AccountRepository @Inject constructor() {

  internal fun store(user: FirebaseUser?): Completable {
    return RxFirebaseDatabase.getInstance()
        .child(REFERENCE_CHILD.format(user!!.uid))
        .setValue(user)
  }

  companion object {

    val REFERENCE_CHILD = "users/%s"
  }
}
