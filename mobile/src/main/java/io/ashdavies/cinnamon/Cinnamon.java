package io.ashdavies.cinnamon;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import io.ashdavies.cinnamon.inject.DaggerApplicationComponent;
import javax.inject.Inject;
import timber.log.Timber;

public class Cinnamon extends DaggerApplication {

  @Inject Timber.Tree tree;

  @Override
  protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
    return DaggerApplicationComponent.builder().create(this);
  }

  @Override
  public void onCreate() {
    super.onCreate();

    setUpTimber();
  }

  private void setUpTimber() {
    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
      return;
    }

    Timber.plant(tree);
  }
}
