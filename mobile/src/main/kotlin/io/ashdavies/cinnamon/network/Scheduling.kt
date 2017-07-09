package io.ashdavies.cinnamon.network

import io.reactivex.Scheduler
import io.reactivex.SingleTransformer
import javax.inject.Inject

class Scheduling @Inject constructor(val executor: Scheduler, val notifier: Scheduler) {

  fun <T> apply(): SingleTransformer<T, T> {
    return SingleTransformer { single ->
      single
          .subscribeOn(executor)
          .observeOn(notifier)
    }
  }
}
