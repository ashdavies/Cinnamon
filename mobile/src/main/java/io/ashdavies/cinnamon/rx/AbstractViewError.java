package io.ashdavies.cinnamon.rx;

import io.ashdavies.cinnamon.view.AbstractView;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

public class AbstractViewError<View extends AbstractView> implements Consumer<Throwable> {

  private final View view;

  public AbstractViewError(View view) {
    this.view = view;
  }

  @Override
  public void accept(@NonNull Throwable throwable) throws Exception {
    view.onError(throwable);
  }
}
