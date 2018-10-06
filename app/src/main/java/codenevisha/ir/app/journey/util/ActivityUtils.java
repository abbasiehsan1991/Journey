package codenevisha.ir.app.journey.util;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


/**
 * This provides methods to help Activities load their UI.
 */
public class ActivityUtils {

  private static final String TAG = "ActivityUtils";
  
  /**
   * The {@code fragment} is added to the container view with id {@code frameId}. The operation is
   * performed by the {@code fragmentManager}.
   */
  public static void replaceFragmentInActivity(@NonNull FragmentManager fragmentManager,
                                               @NonNull Fragment fragment, int frameId,
                                               String frg_tag) {

    FragmentTransaction transaction = fragmentManager.beginTransaction();
    transaction.replace(frameId, fragment, frg_tag);
    transaction.commit();

  }
}
