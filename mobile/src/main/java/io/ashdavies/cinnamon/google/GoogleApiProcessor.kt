package io.ashdavies.cinnamon.google

import android.os.Bundle
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import io.reactivex.Flowable
import io.reactivex.processors.ReplayProcessor

abstract class GoogleApiProcessor private constructor(private val processor: ReplayProcessor<Event>) : GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

  internal constructor() : this(ReplayProcessor.create<Event>())

  override fun onConnected(bundle: Bundle?) {
    processor.onNext(GoogleApiProcessor.Event.CONNECTED)
  }

  override fun onConnectionSuspended(cause: Int) {
    processor.onNext(GoogleApiProcessor.Event.SUSPENDED)
  }

  override fun onConnectionFailed(result: ConnectionResult) {
    processor.onError(ConnectionFailedException(result))
  }

  fun onConnectionEvent(): Flowable<Event> {
    return processor
        .doOnSubscribe { connect() }
        .doOnCancel { disconnect() }
  }

  protected abstract fun connect()

  protected abstract fun disconnect()

  enum class Event {
    CONNECTED,
    SUSPENDED
  }
}
