package io.ashdavies.cinnamon.inject

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.ashdavies.cinnamon.account.AccountActivity
import io.ashdavies.cinnamon.account.AccountModule
import io.ashdavies.cinnamon.barcode.BarcodeCaptureActivity
import io.ashdavies.cinnamon.barcode.BarcodeCaptureModule
import io.ashdavies.cinnamon.barcode.BarcodeOnboardingActivity
import io.ashdavies.cinnamon.barcode.BarcodeOnboardingModule
import io.ashdavies.cinnamon.home.HomeActivity
import io.ashdavies.cinnamon.home.HomeModule

@Module
internal interface AndroidBindingModule {

  @ContributesAndroidInjector(modules = arrayOf(AccountModule::class))
  fun accountActivity(): AccountActivity

  @ContributesAndroidInjector(modules = arrayOf(BarcodeOnboardingModule::class))
  fun barcodeOnboardingActivity(): BarcodeOnboardingActivity

  @ContributesAndroidInjector(modules = arrayOf(BarcodeCaptureModule::class))
  fun barcodeCaptureActivity(): BarcodeCaptureActivity

  @ContributesAndroidInjector(modules = arrayOf(HomeModule::class))
  fun homeActivity(): HomeActivity
}
