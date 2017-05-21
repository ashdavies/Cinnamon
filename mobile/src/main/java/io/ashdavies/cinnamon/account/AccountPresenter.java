package io.ashdavies.cinnamon.account;

import io.ashdavies.cinnamon.presenter.AbstractViewPresenter;
import io.ashdavies.cinnamon.rx.AbstractViewError;
import io.ashdavies.cinnamon.view.AbstractView;
import io.ashdavies.rx.rxfirebase.RxFirebaseAuth;
import javax.inject.Inject;

public class AccountPresenter extends AbstractViewPresenter<AccountPresenter.View> {

  @Inject
  AccountPresenter() {
  }

  void signInAnonymously() {
    RxFirebaseAuth.getInstance()
        .signInAnonymously()
        .subscribe(authResult -> getView().startHomeActivity(), new AbstractViewError<>(getView()));
  }

  public interface View extends AbstractView {

    void startHomeActivity();
  }
}
