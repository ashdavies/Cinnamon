package io.ashdavies.cinnamon.firebase;

import dagger.Binds;
import dagger.Module;
import io.ashdavies.cinnamon.Configuration;
import io.ashdavies.cinnamon.Reporting;
import io.ashdavies.cinnamon.inject.ApplicationScope;
import timber.log.Timber;

@Module(includes = FirebaseRemoteConfigModule.class)
public abstract class FirebaseModule {

  @Binds
  @ApplicationScope
  abstract Configuration config(FirebaseConfiguration firebaseConfig);

  @Binds
  abstract Timber.Tree tree(FirebaseReportingTree firebaseReportingTree);

  @Binds
  abstract Reporting reporting(FirebaseReporting reporting);
}
