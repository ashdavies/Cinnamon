package io.ashdavies.cinnamon.account;

import android.support.v4.app.FragmentActivity;
import dagger.Binds;
import dagger.Module;

@Module
public interface AccountModule {

  @Binds
  FragmentActivity activity(AccountActivity account);

  @Binds
  AccountView view(AccountActivity activity);
}
