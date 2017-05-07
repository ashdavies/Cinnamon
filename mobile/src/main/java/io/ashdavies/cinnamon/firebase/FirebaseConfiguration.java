package io.ashdavies.cinnamon.firebase;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.ashdavies.cinnamon.Configuration;
import io.ashdavies.rx.rxtasks.RxTasks;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import timber.log.Timber;

class FirebaseConfiguration implements Configuration {

  private static final long CACHE_EXPIRATION_IN_SECONDS = TimeUnit.HOURS.toMillis(1);

  private final FirebaseRemoteConfig firebase;

  @Inject
  FirebaseConfiguration(FirebaseRemoteConfig firebase) {
    this.firebase = firebase;
  }

  @Inject
  void prepare() {
    RxTasks.completable(firebase.fetch(getCacheExpirationInSeconds()))
        .subscribe(firebase::activateFetched, Timber::e);
  }

  private long getCacheExpirationInSeconds() {
    return CACHE_EXPIRATION_IN_SECONDS;
  }
}
