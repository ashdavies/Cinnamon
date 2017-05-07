package io.ashdavies.cinnamon.inject;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import io.ashdavies.cinnamon.home.HomeActivity;
import io.ashdavies.cinnamon.signin.SignInActivity;

@Module
abstract class AndroidBindingModule {

  @ContributesAndroidInjector
  abstract HomeActivity chatActivity();

  @ContributesAndroidInjector
  abstract SignInActivity signInActivity();
}
