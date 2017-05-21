package io.ashdavies.cinnamon.inject;

import android.app.Application;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.releasablereferences.ForReleasableReferences;
import dagger.releasablereferences.ReleasableReferenceManager;
import io.ashdavies.cinnamon.Cinnamon;
import io.ashdavies.cinnamon.android.StringResolver;

@Module
abstract class ApplicationModule {

  @Binds
  abstract Application application(Cinnamon cinnamon);

  @Provides
  static StringResolver resolver(Application application) {
    return new StringResolver(application.getResources());
  }

  @Provides
  static SharedPreferences preferences(Application application) {
    return PreferenceManager.getDefaultSharedPreferences(application);
  }

  @Binds
  abstract ReleasableReferenceManager references(@ForReleasableReferences(ApplicationScope.class) ReleasableReferenceManager references);

  @Provides
  static Typeface typeface(Application application) {
    return Typeface.createFromAsset(application.getAssets(), "fonts/product-sans-regular.ttf");
  }
}
