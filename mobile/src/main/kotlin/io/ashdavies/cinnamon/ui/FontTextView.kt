package io.ashdavies.cinnamon.ui

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Paint
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import io.ashdavies.cinnamon.R
import io.ashdavies.cinnamon.cache.FontCache

class FontTextView : AppCompatTextView {

  constructor(context: Context) : super(context) {
    init(context, null)
  }

  constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
    init(context, attrs)
  }

  constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
    init(context, attrs)
  }

  private fun init(context: Context, attrs: AttributeSet?) {
    val attributes = context.obtainStyledAttributes(attrs, R.styleable.FontTextView)

    if (attributes.hasValue(R.styleable.FontTextView_android_textAppearance)) {
      val textAppearance = attributes.getResourceId(R.styleable.FontTextView_android_textAppearance, android.R.style.TextAppearance)
      val styled = getContext().obtainStyledAttributes(textAppearance, R.styleable.FontTextAppearance)
      if (styled.hasValue(R.styleable.FontTextAppearance_font)) {
        setFont(styled.getString(R.styleable.FontTextAppearance_font))
      }
      styled.recycle()
    }

    if (attributes.hasValue(R.styleable.FontTextView_font)) {
      setFont(attributes.getString(R.styleable.FontTextView_font))
    }

    attributes.recycle()
  }

  fun setFont(font: String) {
    paintFlags = paintFlags or Paint.ANTI_ALIAS_FLAG
    typeface = FontCache.get(context, font)
  }
}
