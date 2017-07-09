package io.ashdavies.cinnamon.trades

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter

class Adapter : TypeAdapter<Trade>() {

  override fun read(reader: JsonReader?): Trade {
    return Trade(reader!!.nextFloat(), reader.nextFloat(), reader.nextFloat(), reader.nextOrder(), reader.nextType(), reader.nextString())
  }

  private fun JsonReader.nextFloat(): Float {
    return nextDouble().toFloat()
  }

  private fun JsonReader.nextOrder(): Trade.Order {
    return Trade.Order.valueOf(nextString())
  }

  private fun JsonReader.nextType(): Trade.Type {
    return Trade.Type.valueOf(nextString())
  }

  override fun write(writer: JsonWriter?, value: Trade?) {
    writer!!
        .value(value!!.price)
        .value(value.volume)
        .value(value.time)
        .value(value.order.name)
        .value(value.type.name)
        .value(value.misc)
  }
}
