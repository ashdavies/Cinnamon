package io.ashdavies.cinnamon.android

import io.ashdavies.cinnamon.R
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

internal class TimeFormatter private constructor(private val resolver: StringResolver, private val format: SimpleDateFormat) : StringFormatter<Long> {

  @Inject
  constructor(resolver: StringResolver) : this(resolver, SimpleDateFormat(FORMAT, Locale.getDefault()))

  override fun format(millis: Long): String {
    val diff = System.currentTimeMillis() - millis

    if (diff < TimeUnit.HOURS.toMillis(1)) {
      return resolver[R.string.label_minutes, Math.max(1, TimeUnit.MILLISECONDS.toMinutes(diff))]
    }

    if (diff < TimeUnit.DAYS.toMillis(1)) {
      return resolver[R.string.label_hours, Math.max(1, TimeUnit.MILLISECONDS.toHours(diff))]
    }

    return format.format(Date(millis))
  }

  companion object {

    private val FORMAT = "MMM dd"
  }
}
