package io.ashdavies.cinnamon.presenter;

import io.ashdavies.cinnamon.view.AbstractView;
import javax.annotation.Nullable;

public abstract class AbstractViewPresenter<View extends AbstractView> implements AbstractView, ViewPresenter<View> {

  @Nullable
  private View view;

  @Override
  public void onAttach(View view) {
    this.view = view;
  }

  protected View getView() {
    if (view == null) {
      throw new ViewNotAttachedException();
    }

    return view;
  }

  protected boolean isAttached() {
    return view != null;
  }

  @Override
  public void onDetach() {
    view = null;
  }

  @Override
  public void onError(Throwable throwable) {
    getView().onError(throwable);
  }

  private static class ViewNotAttachedException extends RuntimeException {
  }
}
