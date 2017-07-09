package io.ashdavies.cinnamon.trades

import io.ashdavies.cinnamon.currency.Pair

data class Trades(val error: List<String>, val result: Result) {

  data class Result(val pairs: Map<Pair, List<Trade>>)
}
