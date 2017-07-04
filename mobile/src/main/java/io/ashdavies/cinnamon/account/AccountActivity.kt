package io.ashdavies.cinnamon.account

import android.content.Intent
import android.widget.TextView
import butterknife.BindView
import butterknife.OnClick
import io.ashdavies.cinnamon.R
import io.ashdavies.cinnamon.activity.AbstractActivity
import io.ashdavies.cinnamon.barcode.BarcodeOnboardingActivity
import javax.inject.Inject

class AccountActivity : AbstractActivity(), AccountView {

  @BindView(R.id.headline_welcome) internal lateinit var welcome: TextView

  @Inject internal lateinit var presenter: AccountPresenter
  @Inject internal lateinit var activity: AccountActivity

  override fun getLayoutId(): Int {
    return R.layout.activity_account
  }

  override fun getMenuId(): Int {
    return R.menu.activity_empty
  }

  @OnClick(R.id.action_account_google)
  internal fun onGoogleAccountClick() {
    presenter.onGoogleLogin()
  }

  @OnClick(R.id.action_account_kraken)
  internal fun onKrakenAccountClick() {
    startActivityForResult(Intent(this, BarcodeOnboardingActivity::class.java), REQUEST_BARCODE_CAPTURE)
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
    when (requestCode) {
      REQUEST_BARCODE_CAPTURE -> {
        presenter.onBarcodeResult(resultCode, data)
        return
      }

      else -> super.onActivityResult(requestCode, resultCode, data)
    }
  }

  companion object {

    private val REQUEST_BARCODE_CAPTURE = 0x14
  }
}
