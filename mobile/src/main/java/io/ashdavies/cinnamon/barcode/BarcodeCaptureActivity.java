package io.ashdavies.cinnamon.barcode;

import io.ashdavies.cinnamon.R;
import io.ashdavies.cinnamon.activity.AbstractActivity;

public class BarcodeCaptureActivity extends AbstractActivity {

  @Override
  protected int getLayoutId() {
    return R.layout.activity_barcode_capture;
  }

  @Override
  protected int getMenuId() {
    return R.menu.activity_empty;
  }
}
