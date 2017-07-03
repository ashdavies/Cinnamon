package io.ashdavies.cinnamon.barcode;

import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Base64;
import com.facebook.crypto.Crypto;
import com.facebook.crypto.Entity;
import com.facebook.crypto.exception.CryptoInitializationException;
import com.facebook.crypto.exception.KeyChainException;
import com.google.android.gms.vision.barcode.Barcode;
import java.io.IOException;
import javax.inject.Inject;

public class BarcodePreferenceStorage {

  private static final String KEY_ENTITY_KEY = "key";
  private static final String KEY_ENTITY_SECRET = "secret";

  /**
   * Format   QR_CODE
   * Type     URI
   * Time     DD/MM/YYYY HH:MM:SS
   * Metadata H
   *
   * kraken://apikey?key=([A-Za-z0-9\+]{55}\+)&secret=([A-Za-z0-9\+]{86}==)
   */

  private final Crypto crypto;
  private final SharedPreferences preferences;

  @Inject
  BarcodePreferenceStorage(Crypto crypto, SharedPreferences preferences) {
    this.crypto = crypto;
    this.preferences = preferences;
  }

  public void put(Barcode barcode) throws CryptoUnavailableException, KeyChainException, CryptoInitializationException, IOException {
    if (!crypto.isAvailable()) {
      throw new CryptoUnavailableException();
    }

    Uri uri = Uri.parse(barcode.rawValue);

    byte[] key = crypto.encrypt(uri.getQueryParameter(KEY_ENTITY_KEY).getBytes(), Entity.create(KEY_ENTITY_KEY));
    byte[] secret = crypto.encrypt(uri.getQueryParameter(KEY_ENTITY_SECRET).getBytes(), Entity.create(KEY_ENTITY_SECRET));

    SharedPreferences.Editor editor = preferences.edit();

    editor.putString(KEY_ENTITY_KEY, Base64.encodeToString(key, Base64.DEFAULT));
    editor.putString(KEY_ENTITY_SECRET, Base64.encodeToString(secret, Base64.DEFAULT));

    editor.apply();
  }

  private static class CryptoUnavailableException extends Exception {
  }
}
