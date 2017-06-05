package io.ashdavies.cinnamon.activity;

import android.arch.lifecycle.LifecycleActivity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.MenuRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;
import dagger.android.support.HasSupportFragmentInjector;
import io.ashdavies.cinnamon.R;
import io.ashdavies.cinnamon.view.AbstractView;
import javax.inject.Inject;
import timber.log.Timber;

public abstract class AbstractActivity extends LifecycleActivity implements AbstractView, HasFragmentInjector, HasSupportFragmentInjector {

  @Inject
  DispatchingAndroidInjector<Fragment> supportFragmentInjector;

  @Inject
  DispatchingAndroidInjector<android.app.Fragment> frameworkFragmentInjector;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    AndroidInjection.inject(this);
    super.onCreate(savedInstanceState);
    setContentView(getLayoutId());
  }

  @Override
  public void setContentView(int layoutResId) {
    super.setContentView(layoutResId);
    ButterKnife.bind(this);
  }

  @LayoutRes
  protected abstract int getLayoutId();

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(getMenuId(), menu);
    return true;
  }

  @MenuRes
  protected abstract int getMenuId();

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == android.R.id.home) {
      this.finish();
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  @Override
  public boolean shouldShowRequestPermissionRationale(@NonNull String permission) {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && super.shouldShowRequestPermissionRationale(permission);
  }

  @Override
  public void onError(Throwable throwable) {
    alert(throwable.getMessage());
    error(throwable);
  }

  private void alert(String message) {
    new AlertDialog.Builder(this)
        .setTitle(R.string.label_error)
        .setMessage(message)
        .setPositiveButton(R.string.action_ok, null)
        .show();
  }

  private void error(Throwable throwable) {
    Timber.e(throwable);
  }

  @Override
  public AndroidInjector<Fragment> supportFragmentInjector() {
    return this.supportFragmentInjector;
  }

  @Override
  public AndroidInjector<android.app.Fragment> fragmentInjector() {
    return this.frameworkFragmentInjector;
  }
}
