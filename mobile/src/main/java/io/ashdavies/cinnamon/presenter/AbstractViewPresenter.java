package io.ashdavies.cinnamon.presenter;

import io.ashdavies.cinnamon.view.AbstractView;

public abstract class AbstractViewPresenter<View extends AbstractView> implements AbstractView {

  private final View view;

  public AbstractViewPresenter(View view) {
    this.view = view;
  }

  protected View getView() {
    return view;
  }

  @Override
  public void onError(Throwable throwable) {
    getView().onError(throwable);
  }
}
