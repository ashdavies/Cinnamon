package io.ashdavies.cinnamon.home;

import android.support.v4.app.FragmentActivity;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class HomeModule {

  @Binds
  abstract FragmentActivity activity(HomeActivity activity);

  @Binds
  abstract HomeView view(HomeActivity activity);
}
