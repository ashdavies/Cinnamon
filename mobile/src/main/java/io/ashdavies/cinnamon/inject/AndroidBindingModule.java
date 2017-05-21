package io.ashdavies.cinnamon.inject;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import io.ashdavies.cinnamon.account.AccountActivity;
import io.ashdavies.cinnamon.home.HomeActivity;

@Module
abstract class AndroidBindingModule {

  @ContributesAndroidInjector
  abstract AccountActivity signInActivity();

  @ContributesAndroidInjector
  abstract HomeActivity homeActivity();
}
