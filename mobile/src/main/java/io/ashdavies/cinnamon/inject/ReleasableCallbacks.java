package io.ashdavies.cinnamon.inject;

import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import dagger.releasablereferences.ReleasableReferenceManager;
import javax.inject.Inject;

public class ReleasableCallbacks implements ComponentCallbacks2 {

  private final ReleasableReferenceManager manager;

  @Inject
  ReleasableCallbacks(ReleasableReferenceManager manager) {
    this.manager = manager;
  }

  @Inject
  void register(Application application) {
    application.registerComponentCallbacks(this);
  }

  @Override
  public void onTrimMemory(int level) {
    if (level >= TRIM_MEMORY_RUNNING_MODERATE) {
      onLowMemory();
      return;
    }

    onHighMemory();
  }

  @Override
  public void onConfigurationChanged(Configuration config) {
    /* no op */
  }

  @Override
  public void onLowMemory() {
    manager.releaseStrongReferences();
  }

  private void onHighMemory() {
    manager.restoreStrongReferences();
  }
}
