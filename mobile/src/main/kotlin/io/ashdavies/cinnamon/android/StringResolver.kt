package io.ashdavies.cinnamon.android

import android.content.res.Resources
import android.support.annotation.StringRes
import javax.inject.Inject

class StringResolver @Inject constructor(private val resources: Resources) {

  operator fun get(@StringRes resId: Int, vararg args: Any): String {
    return resources.getString(resId, *args)
  }
}
