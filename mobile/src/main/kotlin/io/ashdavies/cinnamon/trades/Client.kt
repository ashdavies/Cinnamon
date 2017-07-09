package io.ashdavies.cinnamon.trades

import io.ashdavies.cinnamon.currency.Pair
import io.ashdavies.cinnamon.kraken.Kraken
import io.ashdavies.cinnamon.network.Scheduling
import io.reactivex.Single
import javax.inject.Inject

class Client @Inject constructor(val kraken: Kraken, val scheduling: Scheduling) {

  fun fetch(): Single<Trades> {
    return kraken.trades(Pair.XETHZEUR).compose(scheduling.apply())
  }
}
