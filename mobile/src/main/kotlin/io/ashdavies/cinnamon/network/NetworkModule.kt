package io.ashdavies.cinnamon.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.ashdavies.cinnamon.kraken.KrakenModule
import io.ashdavies.cinnamon.trades.Adapter
import io.ashdavies.cinnamon.trades.Trade
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


@Module(includes = arrayOf(KrakenModule::class))
class NetworkModule {

  @Module
  companion object {

    private val BASE_URL = "https://api.kraken.com/0/"

    @Provides
    @JvmStatic
    fun scheduling(): Scheduling {
      return Scheduling(Schedulers.io(), AndroidSchedulers.mainThread())
    }

    @Provides
    @JvmStatic
    fun logging(): HttpLoggingInterceptor {
      val interceptor = HttpLoggingInterceptor()
      interceptor.level = HttpLoggingInterceptor.Level.BODY
      return interceptor
    }

    @Provides
    @JvmStatic
    fun client(logging: HttpLoggingInterceptor): OkHttpClient {
      return OkHttpClient.Builder()
          .addInterceptor(logging)
          .build()
    }

    @Provides
    @JvmStatic
    fun gson(): Gson {
      return GsonBuilder()
          .registerTypeAdapter(Trade::class.java, Adapter())
          .create()
    }

    @Provides
    @JvmStatic
    fun retrofit(client: OkHttpClient, gson: Gson): Retrofit {
      return Retrofit.Builder()
          .baseUrl(BASE_URL)
          .client(client)
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .addConverterFactory(GsonConverterFactory.create(gson))
          .build()
    }
  }
}
