package io.ashdavies.cinnamon.account;

import android.support.v4.app.FragmentActivity;
import com.facebook.android.crypto.keychain.AndroidConceal;
import com.facebook.android.crypto.keychain.SharedPrefsBackedKeyChain;
import com.facebook.crypto.Crypto;
import com.facebook.crypto.CryptoConfig;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class AccountModule {

  @Binds
  abstract FragmentActivity activity(AccountActivity account);

  @Binds
  abstract AccountView view(AccountActivity activity);

  @Provides
  static Crypto crypto(FragmentActivity activity) {
    return AndroidConceal.get().createDefaultCrypto(new SharedPrefsBackedKeyChain(activity, CryptoConfig.KEY_256));
  }
}
