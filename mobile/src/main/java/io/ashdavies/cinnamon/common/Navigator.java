package io.ashdavies.cinnamon.common;

import android.support.v4.app.FragmentActivity;
import javax.inject.Inject;

public class Navigator {

  private final FragmentActivity activity;

  @Inject
  public Navigator(FragmentActivity activity) {
    this.activity = activity;
  }

  public void navigate(Command command) {
    command.navigate(activity);
  }

  public interface Command {

    void navigate(FragmentActivity activity);
  }
}
