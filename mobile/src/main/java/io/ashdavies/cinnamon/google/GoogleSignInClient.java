package io.ashdavies.cinnamon.google;

import android.app.Application;
import android.content.Intent;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import io.ashdavies.cinnamon.R;
import io.ashdavies.cinnamon.android.StringResolver;
import javax.inject.Inject;

public class GoogleSignInClient extends GoogleApiProcessor {

  private final GoogleApiClient client;

  @Inject
  GoogleSignInClient(Application application, StringResolver resolver) {
    client = new GoogleApiClient.Builder(application)
        .addConnectionCallbacks(this)
        .addOnConnectionFailedListener(this)
        .addApi(Auth.GOOGLE_SIGN_IN_API, createGoogleSignInOptions(resolver))
        .build();
  }

  private GoogleSignInOptions createGoogleSignInOptions(StringResolver resolver) {
    return new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken(resolver.get(R.string.default_web_client_id))
        .requestEmail()
        .build();
  }

  public Intent getSignInIntent() {
    return Auth.GoogleSignInApi.getSignInIntent(client);
  }

  void signOut() {
    Auth.GoogleSignInApi.signOut(client);
  }

  @Override
  public void connect() {
    client.connect();
  }

  @Override
  public void disconnect() {
    client.disconnect();
  }
}
