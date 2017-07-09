package io.ashdavies.cinnamon.inject

import android.app.Application
import android.content.ComponentCallbacks2
import android.content.res.Configuration
import dagger.releasablereferences.ReleasableReferenceManager
import javax.inject.Inject

class ReleasableCallbacks @Inject internal constructor(private val manager: ReleasableReferenceManager) : ComponentCallbacks2 {

  @Inject
  internal fun register(application: Application) {
    application.registerComponentCallbacks(this)
  }

  override fun onTrimMemory(level: Int) {
    if (level >= ComponentCallbacks2.TRIM_MEMORY_RUNNING_MODERATE) {
      onLowMemory()
      return
    }

    onHighMemory()
  }

  override fun onConfigurationChanged(config: Configuration) {
    /* no op */
  }

  override fun onLowMemory() {
    manager.releaseStrongReferences()
  }

  private fun onHighMemory() {
    manager.restoreStrongReferences()
  }
}
