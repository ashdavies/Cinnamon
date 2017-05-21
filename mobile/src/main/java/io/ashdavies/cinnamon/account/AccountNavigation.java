package io.ashdavies.cinnamon.account;

import io.ashdavies.cinnamon.common.Navigator;
import javax.inject.Inject;

class AccountNavigation {

  private final Navigator navigator;

  @Inject
  AccountNavigation(Navigator navigator) {
    this.navigator = navigator;
  }
}
