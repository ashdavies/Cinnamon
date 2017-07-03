package io.ashdavies.cinnamon.activity;

import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.MenuRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;
import io.ashdavies.cinnamon.R;
import io.ashdavies.cinnamon.view.AbstractView;
import timber.log.Timber;

public abstract class AbstractActivity extends DaggerAppCompatActivity implements AbstractView, LifecycleRegistryOwner {

  private final LifecycleRegistry registry = new LifecycleRegistry(this);

  @Override
  protected void onCreate(Bundle savedInstanceState) {
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
  public LifecycleRegistry getLifecycle() {
    return registry;
  }
}
