package codenevisha.ir.app.journey.util

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager


/**
 * This provides methods to help Activities load their UI.
 */
object ActivityUtils {

    private val TAG = "ActivityUtils"

    /**
     * The `fragment` is added to the container view with id `frameId`. The operation is
     * performed by the `fragmentManager`.
     */
    fun replaceFragmentInActivity(fragmentManager: FragmentManager,
                                  fragment: Fragment, frameId: Int,
                                  frg_tag: String) {

        val transaction = fragmentManager.beginTransaction()
        transaction.replace(frameId, fragment, frg_tag)
        transaction.commit()

    }
}
