package io.ashdavies.cinnamon.signin;

import io.ashdavies.cinnamon.presenter.AbstractViewPresenter;
import io.ashdavies.cinnamon.rx.AbstractViewError;
import io.ashdavies.cinnamon.view.AbstractView;
import io.ashdavies.rx.rxfirebase.RxFirebaseAuth;
import javax.inject.Inject;

public class SignInPresenter extends AbstractViewPresenter<SignInPresenter.View> {

  @Inject
  SignInPresenter() {
  }

  @Override
  public void onAttach(View view) {
    super.onAttach(view);
    signInAnonymously();
  }

  private void signInAnonymously() {
    RxFirebaseAuth.getInstance()
        .signInAnonymously()
        .subscribe(authResult -> getView().startHomeActivity(), new AbstractViewError<>(getView()));
  }

  public interface View extends AbstractView {

    void startHomeActivity();
  }
}
