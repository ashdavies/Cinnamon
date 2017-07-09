package io.ashdavies.cinnamon.home

import io.ashdavies.cinnamon.presenter.AbstractViewPresenter
import io.ashdavies.cinnamon.trades.Client
import javax.inject.Inject

internal class HomePresenter @Inject constructor(client: Client, view: HomeView) : AbstractViewPresenter<HomeView>(view) {

  init {
    client.fetch().subscribe(view::onNext, view::onError)
  }
}
