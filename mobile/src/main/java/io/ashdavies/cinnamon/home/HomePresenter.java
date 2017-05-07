package io.ashdavies.cinnamon.home;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import io.ashdavies.cinnamon.Configuration;
import io.ashdavies.cinnamon.android.StringResolver;
import io.ashdavies.cinnamon.presenter.AbstractViewPresenter;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Inject;

class HomePresenter extends AbstractViewPresenter<HomeView> {

  private CompositeDisposable disposables;

  @Inject Configuration configuration;
  @Inject StringResolver resolver;

  @Inject
  HomePresenter() {
  }

  @Override
  public void onAttach(HomeView view) {
    super.onAttach(view);

    initCurrentUser();
    initDisposables();
  }

  private void initCurrentUser() {
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    if (user == null) {
      getView().startSignInActivity();
    }
  }

  private void initDisposables() {
    if (disposables != null && !disposables.isDisposed()) {
      disposables.dispose();
    }

    disposables = new CompositeDisposable();
  }

  @Override
  public void onDetach() {
    super.onDetach();

    disposables.dispose();
    disposables = null;
  }
}
