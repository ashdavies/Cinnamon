package io.ashdavies.cinnamon.inject;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import io.ashdavies.cinnamon.Cinnamon;
import io.ashdavies.cinnamon.firebase.FirebaseModule;

@Component(
    modules = {
        ApplicationModule.class,
        AndroidBindingModule.class,
        AndroidSupportInjectionModule.class,
        FirebaseModule.class
    }
)
@ApplicationScope
public interface ApplicationComponent extends AndroidInjector<Cinnamon> {

  @Component.Builder
  abstract class Builder extends AndroidInjector.Builder<Cinnamon> {
  }
}
