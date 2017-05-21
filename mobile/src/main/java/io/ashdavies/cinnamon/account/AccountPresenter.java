package io.ashdavies.cinnamon.account;

import io.ashdavies.cinnamon.presenter.AbstractViewPresenter;
import javax.inject.Inject;

public class AccountPresenter extends AbstractViewPresenter<AccountView> {

  @Inject
  AccountPresenter(AccountView view) {
    super(view);
  }
}
