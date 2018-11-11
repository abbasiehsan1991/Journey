package codenevisha.ir.app.journey.util.extensions

import android.content.Context
import android.os.Handler
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.view.View
import codenevisha.ir.app.journey.R
import codenevisha.ir.app.journey.data.local.pref.PreferenceManager

/**
 * CREATED BY Javadroid FOR `WiCalory` PROJECT
 * AT: 2018/Jun/11 11:46
 */

fun Context.getAppPrefs(): PreferenceManager = PreferenceManager.getInstance(this)

fun DialogFragment.replaceFragmentWithAnimation(container: View, fragment: Fragment, backstackTag: String) {
    Handler().post {
        val transaction = childFragmentManager.beginTransaction()
        transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left)
        transaction.replace(container.id, fragment)
        transaction.addToBackStack(backstackTag)
        transaction.commitAllowingStateLoss()
    }

}