package io.ashdavies.cinnamon.account

import android.support.v4.app.FragmentActivity
import com.facebook.android.crypto.keychain.AndroidConceal
import com.facebook.android.crypto.keychain.SharedPrefsBackedKeyChain
import com.facebook.crypto.Crypto
import com.facebook.crypto.CryptoConfig
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class AccountModule {

  @Binds
  internal abstract fun activity(account: AccountActivity): FragmentActivity

  @Binds
  internal abstract fun view(activity: AccountActivity): AccountView

  @Module
  companion object {

    @Provides
    @JvmStatic
    internal fun crypto(activity: FragmentActivity): Crypto {
      return AndroidConceal.get().createDefaultCrypto(SharedPrefsBackedKeyChain(activity, CryptoConfig.KEY_256))
    }
  }
}
