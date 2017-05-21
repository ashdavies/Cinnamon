package io.ashdavies.cinnamon.barcode;

import android.support.v4.app.FragmentActivity;
import dagger.Binds;
import dagger.Module;

@Module
public interface BarcodeOnboardingModule {

  @Binds
  FragmentActivity activity(BarcodeOnboardingActivity activity);
}
