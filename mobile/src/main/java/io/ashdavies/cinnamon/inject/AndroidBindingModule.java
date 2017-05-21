package io.ashdavies.cinnamon.inject;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import io.ashdavies.cinnamon.account.AccountActivity;
import io.ashdavies.cinnamon.account.AccountModule;
import io.ashdavies.cinnamon.barcode.BarcodeCaptureActivity;
import io.ashdavies.cinnamon.barcode.BarcodeCaptureModule;
import io.ashdavies.cinnamon.barcode.BarcodeOnboardingActivity;
import io.ashdavies.cinnamon.barcode.BarcodeOnboardingModule;
import io.ashdavies.cinnamon.home.HomeActivity;
import io.ashdavies.cinnamon.home.HomeModule;

@Module
interface AndroidBindingModule {

  @ContributesAndroidInjector(modules = AccountModule.class)
  AccountActivity accountActivity();

  @ContributesAndroidInjector(modules = BarcodeOnboardingModule.class)
  BarcodeOnboardingActivity barcodeOnboardingActivity();

  @ContributesAndroidInjector(modules = BarcodeCaptureModule.class)
  BarcodeCaptureActivity barcodeCaptureActivity();

  @ContributesAndroidInjector(modules = HomeModule.class)
  HomeActivity homeActivity();
}
