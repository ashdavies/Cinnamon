package io.ashdavies.cinnamon.cache;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.StringRes;
import java.util.HashMap;
import java.util.Map;

public class FontCache {

  private static final Map<String, Typeface> cache = new HashMap<>();

  private FontCache() throws IllegalAccessException {
    throw new IllegalAccessException();
  }

  public static Typeface get(Context context, @StringRes int resId) {
    return get(context, context.getString(resId));
  }

  public static Typeface get(Context context, String font) {
    synchronized (cache) {
      if (!cache.containsKey(font)) {
        cache.put(font, Typeface.createFromAsset(context.getApplicationContext().getAssets(), "fonts/" + font + ".ttf"));
      }

      return cache.get(font);
    }
  }
}
