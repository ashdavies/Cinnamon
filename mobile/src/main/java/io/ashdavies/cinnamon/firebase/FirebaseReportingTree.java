package io.ashdavies.cinnamon.firebase;

import android.util.Log;
import com.google.firebase.crash.FirebaseCrash;
import javax.inject.Inject;
import timber.log.Timber.Tree;

class FirebaseReportingTree extends Tree {

  @Inject
  FirebaseReportingTree() {
  }

  @Override
  protected void log(int priority, String tag, String message, Throwable throwable) {
    if (priority < Log.INFO) {
      return;
    }

    FirebaseCrash.log(message);
    if (throwable != null) {
      FirebaseCrash.report(throwable);
    }
  }
}
