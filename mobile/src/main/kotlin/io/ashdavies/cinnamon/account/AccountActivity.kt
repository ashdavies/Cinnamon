package io.ashdavies.cinnamon.account

import android.content.Intent
import android.widget.TextView
import butterknife.BindView
import butterknife.OnClick
import io.ashdavies.cinnamon.R
import io.ashdavies.cinnamon.activity.AbstractActivity
import javax.inject.Inject

class AccountActivity : AbstractActivity(), AccountView {

  @BindView(R.id.headline_welcome) internal lateinit var welcome: TextView

  @Inject internal lateinit var presenter: AccountPresenter

  override fun getLayoutId(): Int {
    return R.layout.activity_account
  }

  override fun getMenuId(): Int {
    return R.menu.activity_empty
  }

  @OnClick(R.id.action_account_google)
  internal fun onGoogleAccountClick() {
    presenter.onGoogleSignIn()
  }

  @OnClick(R.id.action_account_kraken)
  internal fun onKrakenAccountClick() {
    presenter.onKrakenSignIn()
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
    super.onActivityResult(requestCode, resultCode, data)
    presenter.onActivityResult(requestCode, resultCode, data)
  }
}
