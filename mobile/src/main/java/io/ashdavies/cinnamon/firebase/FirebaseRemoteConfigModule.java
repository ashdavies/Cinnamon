package io.ashdavies.cinnamon.firebase;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import dagger.Module;
import dagger.Provides;
import io.ashdavies.cinnamon.BuildConfig;
import io.ashdavies.cinnamon.R;

@Module
public abstract class FirebaseRemoteConfigModule {

  @Provides
  static FirebaseRemoteConfig config() {
    FirebaseRemoteConfig firebase = FirebaseRemoteConfig.getInstance();

    firebase.setConfigSettings(buildSettings());
    firebase.setDefaults(R.xml.remote_config_defaults);

    return firebase;
  }

  private static FirebaseRemoteConfigSettings buildSettings() {
    return new FirebaseRemoteConfigSettings.Builder()
        .setDeveloperModeEnabled(BuildConfig.DEBUG)
        .build();
  }
}
