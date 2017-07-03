package io.ashdavies.cinnamon.account;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.vision.barcode.Barcode;
import io.ashdavies.cinnamon.barcode.BarcodeCaptureActivity;
import io.ashdavies.cinnamon.barcode.BarcodePreferenceStorage;
import io.ashdavies.cinnamon.presenter.AbstractViewPresenter;
import javax.inject.Inject;
import timber.log.Timber;

public class AccountPresenter extends AbstractViewPresenter<AccountView> {

  private final BarcodePreferenceStorage storage;

  @Inject
  AccountPresenter(AccountView view, BarcodePreferenceStorage storage) {
    super(view);

    this.storage = storage;
  }

  void onBarcodeResult(int resultCode, Intent data) {
    if (resultCode != Activity.RESULT_OK) {
      return;
    }

    onBarcodeResult(BarcodeCaptureActivity.fromResult(data));
  }

  private void onBarcodeResult(Barcode barcode) {
    try {
      storage.put(barcode);
    } catch (Exception exception) {
      Timber.e(exception);
    }
  }

  void onGoogleLogin() {
    
  }
}
