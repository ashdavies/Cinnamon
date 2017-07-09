package io.ashdavies.cinnamon.inject

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import io.ashdavies.cinnamon.Cinnamon
import io.ashdavies.cinnamon.firebase.FirebaseModule

@Component(modules = arrayOf(
    ApplicationModule::class,
    AndroidBindingModule::class,
    AndroidSupportInjectionModule::class,
    FirebaseModule::class
))
@ApplicationScope
interface ApplicationComponent : AndroidInjector<Cinnamon> {

  @Component.Builder
  abstract class Builder : AndroidInjector.Builder<Cinnamon>()
}
