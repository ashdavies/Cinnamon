package io.ashdavies.cinnamon.barcode;

import io.ashdavies.cinnamon.R;
import io.ashdavies.cinnamon.activity.AbstractActivity;

public class BarcodeOnboardingActivity extends AbstractActivity {

  @Override
  protected int getLayoutId() {
    return R.layout.activity_barcode_onboarding;
  }

  @Override
  protected int getMenuId() {
    return R.menu.activity_empty;
  }
}
