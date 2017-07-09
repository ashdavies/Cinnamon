package io.ashdavies.cinnamon.home

import android.support.v4.app.FragmentActivity
import dagger.Binds
import dagger.Module

@Module
abstract class HomeModule {

  @Binds
  internal abstract fun activity(activity: HomeActivity): FragmentActivity

  @Binds
  internal abstract fun view(activity: HomeActivity): HomeView
}
