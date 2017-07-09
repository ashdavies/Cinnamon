package io.ashdavies.cinnamon.home

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import io.ashdavies.cinnamon.R
import io.ashdavies.cinnamon.trades.Trade

class HomeAdapter(var trades: List<Trade> = ArrayList<Trade>()) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

  override fun getItemCount(): Int {
    return trades.size
  }

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
    return ViewHolder.create(parent)
  }

  override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
    holder!!.bind(trades[position])
  }

  class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    init {
      ButterKnife.bind(this, view)
    }

    internal fun bind(trade: Trade) {
    }

    companion object {

      fun create(parent: ViewGroup?): ViewHolder {
        return ViewHolder(parent!!.inflate(R.layout.item_trade))
      }

      private fun ViewGroup.inflate(@LayoutRes resId: Int): View {
        return LayoutInflater.from(context).inflate(resId, this, false)
      }
    }
  }
}
