package io.ashdavies.cinnamon.home

import io.ashdavies.cinnamon.presenter.AbstractViewPresenter
import javax.inject.Inject

internal class HomePresenter @Inject constructor(view: HomeView) : AbstractViewPresenter<HomeView>(view)
