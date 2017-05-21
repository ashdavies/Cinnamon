package io.ashdavies.cinnamon.home;

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
import io.ashdavies.cinnamon.account.AccountActivity;
import io.ashdavies.cinnamon.activity.AbstractActivity;
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
  @Inject Typeface typeface;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setSupportActionBar(toolbar);
    setCollapsingToolbarFont();
  }

  private void setCollapsingToolbarFont() {
    collapsing.setCollapsedTitleTypeface(typeface);
    collapsing.setExpandedTitleTypeface(typeface);
  }

  @Override
  public void onBackPressed() {
    startActivity(new Intent(this, AccountActivity.class));
    finish();
  }

  @Override
  protected int getLayoutId() {
    return R.layout.activity_home;
  }

  @Override
  protected int getMenuId() {
    return R.menu.activity_empty;
  }

  @Override
  public void startSignInActivity() {
    startActivity(new Intent(this, AccountActivity.class));
    finish();
  }
}
