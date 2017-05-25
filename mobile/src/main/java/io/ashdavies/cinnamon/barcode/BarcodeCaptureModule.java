package io.ashdavies.cinnamon.barcode;

import android.support.v4.app.FragmentActivity;
import com.edwardvanraak.materialbarcodescanner.MaterialBarcodeScanner;
import com.edwardvanraak.materialbarcodescanner.MaterialBarcodeScannerBuilder;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public interface BarcodeCaptureModule {

  @Binds
  FragmentActivity activity(BarcodeCaptureActivity activity);

  @Binds
  MaterialBarcodeScanner.OnResultListener listener(BarcodeCaptureActivity activity);

  @Provides
  static MaterialBarcodeScanner scanner(FragmentActivity activity, MaterialBarcodeScanner.OnResultListener listener) {
    return new MaterialBarcodeScannerBuilder()
        .withActivity(activity)
        .withEnableAutoFocus(true)
        .withBleepEnabled(true)
        .withBackfacingCamera()
        .withResultListener(listener)
        .build();
  }
}
