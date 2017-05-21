package io.ashdavies.cinnamon;

import android.support.v7.app.AppCompatDelegate;
import com.facebook.stetho.Stetho;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import io.ashdavies.cinnamon.inject.DaggerApplicationComponent;
import io.ashdavies.cinnamon.inject.ReleasableCallbacks;
import javax.inject.Inject;
import timber.log.Timber;

public class Cinnamon extends DaggerApplication {

  @Inject Timber.Tree tree;
  @Inject ReleasableCallbacks references;

  @Override
  protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
    return DaggerApplicationComponent.builder().create(this);
  }

  @Override
  public void onCreate() {
    super.onCreate();

    setUpTimber();
    setUpNightMode();
    setUpStetho();
  }

  private void setUpTimber() {
    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
      return;
    }

    Timber.plant(tree);
  }

  private void setUpNightMode() {
    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
  }

  private void setUpStetho() {
    if (!BuildConfig.DEBUG) {
      return;
    }

    Stetho.initialize(Stetho.newInitializerBuilder(this)
        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
        .build());
  }
}
