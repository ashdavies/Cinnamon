package io.ashdavies.cinnamon

import android.os.Bundle

interface Reporting {

  fun event(name: String, bundle: Bundle)
}
