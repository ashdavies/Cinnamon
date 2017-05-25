package io.ashdavies.cinnamon.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import io.ashdavies.cinnamon.R;
import io.ashdavies.cinnamon.cache.FontCache;

public class FontTextView extends AppCompatTextView {

  public FontTextView(Context context) {
    super(context);
    init(context, null);
  }

  public FontTextView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(context, attrs);
  }

  public FontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context, attrs);
  }

  private void init(Context context, AttributeSet attrs) {
    TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.FontTextView);

    if (attributes.hasValue(R.styleable.FontTextView_android_textAppearance)) {
      int textAppearance = attributes.getResourceId(R.styleable.FontTextView_android_textAppearance, android.R.style.TextAppearance);
      TypedArray styled = getContext().obtainStyledAttributes(textAppearance, R.styleable.FontTextAppearance);
      if (styled.hasValue(R.styleable.FontTextAppearance_font)) {
        setFont(styled.getString(R.styleable.FontTextAppearance_font));
      }
      styled.recycle();
    }

    if (attributes.hasValue(R.styleable.FontTextView_font)) {
      setFont(attributes.getString(R.styleable.FontTextView_font));
    }

    attributes.recycle();
  }

  public void setFont(String font) {
    setPaintFlags(getPaintFlags() | Paint.ANTI_ALIAS_FLAG);
    setTypeface(FontCache.get(getContext(), font));
  }
}
