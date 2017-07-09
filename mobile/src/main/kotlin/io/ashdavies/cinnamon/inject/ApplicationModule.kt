package io.ashdavies.cinnamon.inject

import android.app.Application
import android.content.SharedPreferences
import android.content.res.Resources
import android.preference.PreferenceManager
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.releasablereferences.ForReleasableReferences
import dagger.releasablereferences.ReleasableReferenceManager
import io.ashdavies.cinnamon.Cinnamon
import io.ashdavies.cinnamon.network.NetworkModule

@Module(includes = arrayOf(NetworkModule::class))
internal abstract class ApplicationModule {

  @Binds
  internal abstract fun application(cinnamon: Cinnamon): Application

  @Binds
  internal abstract fun references(@ForReleasableReferences(ApplicationScope::class) references: ReleasableReferenceManager): ReleasableReferenceManager

  @Module
  companion object {

    @Provides
    @JvmStatic
    fun resources(application: Application): Resources {
      return application.resources
    }

    @Provides
    @JvmStatic
    fun preferences(application: Application): SharedPreferences {
      return PreferenceManager.getDefaultSharedPreferences(application)
    }
  }
}
