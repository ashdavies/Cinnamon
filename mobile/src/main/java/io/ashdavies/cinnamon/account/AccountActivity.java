package io.ashdavies.cinnamon.account;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import io.ashdavies.cinnamon.R;
import io.ashdavies.cinnamon.activity.AbstractActivity;
import io.ashdavies.cinnamon.barcode.BarcodeCaptureActivity;
import io.ashdavies.cinnamon.home.HomeActivity;
import javax.inject.Inject;

public class AccountActivity extends AbstractActivity implements AccountPresenter.View {

  private static final int REQUEST_CODE_BARCODE_READER = 0x92;

  public static void start(Activity activity) {
    activity.startActivity(new Intent(activity, AccountActivity.class));
  }

  @BindView(R.id.headline_welcome) TextView welcome;

  @Inject AccountPresenter presenter;
  @Inject AccountActivity activity;
  @Inject Typeface typeface;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    presenter.onAttach(this);
    welcome.setTypeface(typeface);
  }

  @Override
  protected int getLayoutId() {
    return R.layout.activity_account;
  }

  @Override
  protected int getMenuId() {
    return R.menu.activity_account;
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    presenter.signInAnonymously();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    presenter.onDetach();
  }

  @Override
  public void startHomeActivity() {
    HomeActivity.start(this);
  }

  @OnClick(R.id.action_account_google)
  void onGoogleAccountClick() {
  }

  @OnClick(R.id.action_account_kraken)
  void onKrakenAccountClick() {
    startActivityForResult(new Intent(this, BarcodeCaptureActivity.class), REQUEST_CODE_BARCODE_READER);
  }
}
