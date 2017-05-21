package io.ashdavies.cinnamon.home;

import io.ashdavies.cinnamon.presenter.AbstractViewPresenter;
import javax.inject.Inject;

class HomePresenter extends AbstractViewPresenter<HomeView> {

  @Inject
  HomePresenter(HomeView view) {
    super(view);
  }
}
