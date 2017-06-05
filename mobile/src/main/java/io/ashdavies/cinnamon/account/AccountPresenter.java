package io.ashdavies.cinnamon.account;

import android.app.Activity;
import android.content.Intent;
import com.facebook.crypto.Crypto;
import com.facebook.crypto.Entity;
import com.google.android.gms.vision.barcode.Barcode;
import io.ashdavies.cinnamon.barcode.BarcodeCaptureActivity;
import io.ashdavies.cinnamon.presenter.AbstractViewPresenter;
import javax.inject.Inject;

public class AccountPresenter extends AbstractViewPresenter<AccountView> {

  private final Crypto crypto;

  @Inject
  AccountPresenter(AccountView view, Crypto crypto) {
    super(view);

    this.crypto = crypto;
  }

  void onBarcodeResult(int resultCode, Intent data) {
    if (resultCode != Activity.RESULT_OK) {
      return;
    }

    Barcode barcode = BarcodeCaptureActivity.fromResult(data);

    // factory class also has explicit methods: createCrypto128Bits and ceateCrypto256Bits if desired.
    Entity entity = Entity.create(barcode.displayValue);
  }
}
