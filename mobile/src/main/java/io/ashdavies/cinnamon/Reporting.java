package io.ashdavies.cinnamon;

import android.os.Bundle;

public interface Reporting {

  void event(String name, Bundle bundle);
}
