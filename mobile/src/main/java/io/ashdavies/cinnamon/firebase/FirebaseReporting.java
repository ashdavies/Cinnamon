package io.ashdavies.cinnamon.firebase;

import android.app.Application;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.ashdavies.cinnamon.Reporting;
import javax.inject.Inject;

class FirebaseReporting implements Reporting {

  private final FirebaseAnalytics analytics;

  @Inject
  FirebaseReporting(Application application) {
    this.analytics = FirebaseAnalytics.getInstance(application);
  }

  @Override
  public void event(String message, Bundle bundle) {
    analytics.logEvent(message, bundle);
  }
}
