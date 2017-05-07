package io.ashdavies.cinnamon.home;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import butterknife.BindView;
import io.ashdavies.cinnamon.R;
import io.ashdavies.cinnamon.activity.AbstractActivity;
import io.ashdavies.cinnamon.signin.SignInActivity;
import javax.inject.Inject;

public class HomeActivity extends AbstractActivity implements HomeView {

  @BindView(R.id.coordinator) CoordinatorLayout coordinator;
  @BindView(R.id.collapsing) CollapsingToolbarLayout collapsing;
  @BindView(R.id.toolbar) Toolbar toolbar;

  @BindView(R.id.trade_balance) TextView tradeBalance;
  @BindView(R.id.trade_equity) TextView tradeEquity;
  @BindView(R.id.used_margin) TextView usedMargin;
  @BindView(R.id.free_margin) TextView freeMargin;
  @BindView(R.id.margin_level) TextView marginLevel;

  @BindView(R.id.actions) FloatingActionButton action;

  @Inject HomePresenter presenter;

  public static void start(Activity activity) {
    activity.startActivity(new Intent(activity, HomeActivity.class));
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setSupportActionBar(toolbar);
    setCollapsingToolbarFont();

    presenter.onAttach(this);
  }

  private void setCollapsingToolbarFont() {
    Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/product-sans-regular.ttf");

    collapsing.setCollapsedTitleTypeface(typeface);
    collapsing.setExpandedTitleTypeface(typeface);
  }

  @Override
  public void onBackPressed() {
    SignInActivity.start(this);
    finish();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    presenter.onDetach();
  }

  @Override
  protected int getLayoutId() {
    return R.layout.activity_home;
  }

  @Override
  protected int getMenuId() {
    return R.menu.home_activity;
  }

  @Override
  public void startSignInActivity() {
    SignInActivity.start(this);
    finish();
  }
}
