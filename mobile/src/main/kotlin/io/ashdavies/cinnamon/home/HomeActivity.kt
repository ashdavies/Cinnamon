package io.ashdavies.cinnamon.home

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.CollapsingToolbarLayout
import android.support.design.widget.CoordinatorLayout
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import butterknife.BindView
import io.ashdavies.cinnamon.R
import io.ashdavies.cinnamon.account.AccountActivity
import io.ashdavies.cinnamon.activity.AbstractActivity
import io.ashdavies.cinnamon.cache.FontCache
import io.ashdavies.cinnamon.currency.Pair
import io.ashdavies.cinnamon.trades.Trades
import javax.inject.Inject

class HomeActivity : AbstractActivity(), HomeView {

  @BindView(R.id.coordinator) internal lateinit var coordinator: CoordinatorLayout

  @BindView(R.id.collapsing) internal lateinit var collapsing: CollapsingToolbarLayout
  @BindView(R.id.toolbar) internal lateinit var toolbar: Toolbar

  @BindView(R.id.recycler) internal lateinit var recycler: RecyclerView

  @Inject internal lateinit var presenter: HomePresenter

  private val adapter: HomeAdapter = HomeAdapter()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setSupportActionBar(toolbar)

    setCollapsingToolbarFont()
    setTradesAdapter()
  }

  private fun setCollapsingToolbarFont() {
    collapsing.setCollapsedTitleTypeface(FontCache.get(this, R.string.product_sans_regular))
    collapsing.setExpandedTitleTypeface(FontCache.get(this, R.string.product_sans_regular))
  }

  private fun setTradesAdapter() {
    recycler.adapter = adapter
  }

  override fun onNext(trades: Trades) {
    adapter.trades = trades.result.pairs[Pair.XETHZEUR]!!
  }

  override fun onBackPressed() {
    startActivity(Intent(this, AccountActivity::class.java))
    finish()
  }

  override fun getLayoutId(): Int {
    return R.layout.activity_home_signed_out
  }

  override fun getMenuId(): Int {
    return R.menu.activity_empty
  }
}
