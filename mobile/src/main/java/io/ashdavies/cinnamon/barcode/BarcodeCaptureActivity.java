package io.ashdavies.cinnamon.barcode;

import android.content.Intent;
import com.edwardvanraak.materialbarcodescanner.MaterialBarcodeScanner;
import com.google.android.gms.vision.barcode.Barcode;
import io.ashdavies.cinnamon.R;
import io.ashdavies.cinnamon.activity.AbstractActivity;
import javax.inject.Inject;

public class BarcodeCaptureActivity extends AbstractActivity implements MaterialBarcodeScanner.OnResultListener {

  private static final String EXTRA_BARCODE = "extra.barcode";

  @Inject MaterialBarcodeScanner scanner;

  @Override
  protected int getLayoutId() {
    return R.layout.activity_barcode_capture;
  }

  @Override
  protected int getMenuId() {
    return R.menu.activity_empty;
  }

  @Override
  public void onResult(Barcode barcode) {
    Intent intent = new Intent();
    intent.putExtra(EXTRA_BARCODE, barcode);

    setResult(RESULT_OK, intent);
    finish();
  }

  public static Barcode fromResult(Intent intent) {
    return intent.getParcelableExtra(EXTRA_BARCODE);
  }
}
