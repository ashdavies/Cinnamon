package io.ashdavies.cinnamon.account;

import android.content.Intent;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import io.ashdavies.cinnamon.R;
import io.ashdavies.cinnamon.activity.AbstractActivity;
import io.ashdavies.cinnamon.barcode.BarcodeOnboardingActivity;
import javax.inject.Inject;

public class AccountActivity extends AbstractActivity implements AccountView {

  private static final int REQUEST_BARCODE_CAPTURE = 0x14;

  @BindView(R.id.headline_welcome) TextView welcome;

  @Inject AccountPresenter presenter;
  @Inject AccountActivity activity;

  @Override
  protected int getLayoutId() {
    return R.layout.activity_account;
  }

  @Override
  protected int getMenuId() {
    return R.menu.activity_empty;
  }

  @OnClick(R.id.action_account_google)
  void onGoogleAccountClick() {
  }

  @OnClick(R.id.action_account_kraken)
  void onKrakenAccountClick() {
    startActivityForResult(new Intent(this, BarcodeOnboardingActivity.class), REQUEST_BARCODE_CAPTURE);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    switch (requestCode) {
      case REQUEST_BARCODE_CAPTURE:
        presenter.onBarcodeResult(resultCode, data);
        return;

      default:
        super.onActivityResult(requestCode, resultCode, data);
    }
  }
}
