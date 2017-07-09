package io.ashdavies.cinnamon.trades

data class Trade(val price: Float, val volume: Float, val time: Float, val order: Order, val type: Type, val misc: String) {

  enum class Order {
    BUY, SELL
  }

  enum class Type {
    MARKET, LIMIT
  }
}
