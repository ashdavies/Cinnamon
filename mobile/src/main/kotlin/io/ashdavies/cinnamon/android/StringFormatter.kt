package io.ashdavies.cinnamon.android

interface StringFormatter<in T> {

  fun format(t: T): String
}
