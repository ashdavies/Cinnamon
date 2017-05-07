package io.ashdavies.cinnamon.firebase;

import android.app.Application;
import android.os.Bundle;
import io.ashdavies.cinnamon.Reporting;
import javax.inject.Inject;

class FirebaseReporting implements Reporting {

  private final com.google.firebase.analytics.FirebaseAnalytics analytics;

  @Inject
  FirebaseReporting(Application application) {
    this.analytics = com.google.firebase.analytics.FirebaseAnalytics.getInstance(application);
  }

  @Override
  public void event(String message, Bundle bundle) {
    analytics.logEvent(message, bundle);
  }
}
