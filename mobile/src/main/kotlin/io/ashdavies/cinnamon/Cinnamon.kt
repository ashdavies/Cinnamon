package io.ashdavies.cinnamon

import android.support.v7.app.AppCompatDelegate
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.ashdavies.cinnamon.inject.DaggerApplicationComponent
import io.ashdavies.cinnamon.inject.ReleasableCallbacks
import timber.log.Timber
import javax.inject.Inject

class Cinnamon : DaggerApplication() {

  @Inject lateinit internal var tree: Timber.Tree
  @Inject lateinit internal var references: ReleasableCallbacks

  override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
    return DaggerApplicationComponent.builder().create(this)
  }

  override fun onCreate() {
    super.onCreate()

    setUpTimber()
    setUpNightMode()
  }

  private fun setUpTimber() {
    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
      return
    }

    Timber.plant(tree)
  }

  private fun setUpNightMode() {
    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
  }
}
