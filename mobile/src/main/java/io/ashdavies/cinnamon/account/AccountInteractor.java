package io.ashdavies.cinnamon.account;

import io.ashdavies.rx.rxfirebase.RxFirebaseAuth;
import javax.inject.Inject;

public class AccountInteractor {

  private final RxFirebaseAuth auth;

  @Inject
  AccountInteractor(RxFirebaseAuth auth) {
    this.auth = auth;
  }
}
