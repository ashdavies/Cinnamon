package io.ashdavies.cinnamon.home

import io.ashdavies.cinnamon.trades.Trades
import io.ashdavies.cinnamon.view.AbstractView

interface HomeView : AbstractView {

  fun onNext(trades: Trades)
}
