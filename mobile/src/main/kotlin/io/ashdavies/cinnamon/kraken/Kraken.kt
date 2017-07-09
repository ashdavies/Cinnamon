package io.ashdavies.cinnamon.kraken

import io.ashdavies.cinnamon.currency.Pair
import io.ashdavies.cinnamon.trades.Trades
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Kraken {

  @GET("public/Time")
  fun time(): Single<Any>

  @GET("public/Assets")
  fun assets(): Single<Any>

  @GET("public/AssetPairs")
  fun assetPairs(): Single<Any>

  @GET("public/Ticker")
  fun ticker(): Single<Any>

  @GET("public/OHLC")
  fun ohlc(): Single<Any>

  @GET("public/Depth")
  fun depth(): Single<Any>

  @GET("public/Trades")
  fun trades(@Query("pair") pair: Pair): Single<Trades>

  @GET("public/Spread")
  fun spread(): Single<Any>
}
