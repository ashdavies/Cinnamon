package io.ashdavies.cinnamon.presenter;

public interface ViewPresenter<View> {

  void onAttach(View view);

  void onDetach();

  void onError(Throwable throwable);
}
