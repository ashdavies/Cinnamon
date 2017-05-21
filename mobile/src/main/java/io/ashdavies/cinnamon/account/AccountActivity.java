package io.ashdavies.cinnamon.account;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
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
  @Inject Typeface typeface;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    welcome.setTypeface(typeface);
  }

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
