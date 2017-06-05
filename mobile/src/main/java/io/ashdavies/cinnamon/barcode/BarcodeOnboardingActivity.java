package io.ashdavies.cinnamon.barcode;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import butterknife.OnClick;
import io.ashdavies.cinnamon.R;
import io.ashdavies.cinnamon.activity.AbstractActivity;

public class BarcodeOnboardingActivity extends AbstractActivity {

  private static final int REQUEST_CAMERA_PERMISSION = 0x12;

  @Override
  protected int getLayoutId() {
    return R.layout.activity_barcode_onboarding;
  }

  @Override
  protected int getMenuId() {
    return R.menu.activity_empty;
  }

  @OnClick(R.id.action_next)
  void onNextClick() {
    ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.CAMERA }, REQUEST_CAMERA_PERMISSION);
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    if (requestCode != REQUEST_CAMERA_PERMISSION) {
      super.onRequestPermissionsResult(requestCode, permissions, grantResults);
      return;
    }

    if (grantResults.length != 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
      startActivity(new Intent(this, BarcodeCaptureActivity.class));
      finish();
      return;
    }

    new AlertDialog.Builder(this)
        .setTitle(R.string.label_error)
        .setMessage(R.string.no_camera_permission)
        .setPositiveButton(android.R.string.ok, (dialog, which) -> dialog.cancel())
        .show();
  }
}
