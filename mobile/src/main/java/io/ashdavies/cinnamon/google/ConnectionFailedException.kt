package io.ashdavies.cinnamon.google

import com.google.android.gms.common.ConnectionResult
import org.json.JSONException
import org.json.JSONObject

class ConnectionFailedException internal constructor(val result: ConnectionResult) : Throwable(getStatusCode(result)) {

  companion object {

    private val CONNECTION_RESULT = "ConnectionResult"
    private val STATUS_CODE = "statusCode"

    private fun getStatusCode(result: ConnectionResult): String {
      try {
        return JSONObject(result.toString().substring(CONNECTION_RESULT.length)).getString(STATUS_CODE)
      } catch (ignored: JSONException) {
        return "PARSE_EXCEPTION"
      }
    }
  }
}
