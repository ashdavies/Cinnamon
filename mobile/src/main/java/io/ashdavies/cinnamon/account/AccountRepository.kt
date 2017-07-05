package io.ashdavies.cinnamon.account

import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import javax.inject.Inject

class AccountRepository @Inject constructor() {

  internal fun store(user: FirebaseUser?) {
    FirebaseDatabase.getInstance()
        .getReference(REFERENCE_CHILD)
        .child(user!!.uid)
        .setValue(user)
  }

  companion object {

    val REFERENCE_CHILD = "users"
  }
}
