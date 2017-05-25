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
    startActivity(new Intent(this, BarcodeOnboardingActivity.class));
    finish();
  }
}
