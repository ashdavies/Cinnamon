package io.ashdavies.cinnamon.signin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import io.ashdavies.cinnamon.R;
import io.ashdavies.cinnamon.activity.AbstractActivity;
import io.ashdavies.cinnamon.home.HomeActivity;
import javax.inject.Inject;

public class SignInActivity extends AbstractActivity implements SignInPresenter.View {

  public static void start(Activity activity) {
    activity.startActivity(newIntent(activity));
  }

  private static Intent newIntent(Context context) {
    return new Intent(context, SignInActivity.class);
  }

  @Inject SignInPresenter presenter;
  @Inject SignInActivity activity;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    presenter.onAttach(this);
  }

  @Override
  protected int getLayoutId() {
    return R.layout.activity_signin;
  }

  @Override
  protected int getMenuId() {
    return R.menu.signin_activity;
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
}
