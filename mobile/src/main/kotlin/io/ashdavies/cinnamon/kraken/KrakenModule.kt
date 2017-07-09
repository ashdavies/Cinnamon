package io.ashdavies.cinnamon.kraken

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
abstract class KrakenModule {

  @Module
  companion object {

    @Provides
    @JvmStatic
    fun kraken(retrofit: Retrofit): Kraken {
      return retrofit.create(Kraken::class.java)
    }
  }
}
