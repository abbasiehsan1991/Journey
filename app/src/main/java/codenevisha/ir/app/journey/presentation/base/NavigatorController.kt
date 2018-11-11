package codenevisha.ir.app.journey.presentation.base

import android.arch.lifecycle.MutableLiveData
import android.databinding.ViewDataBinding
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import codenevisha.ir.app.journey.presentation.home.HomeFragment
import codenevisha.ir.app.journey.util.extensions.TransitionAnimation
import codenevisha.ir.app.journey.util.extensions.newFragmentInstance
import codenevisha.ir.app.journey.util.extensions.setCustomAnimation

/**
 * CREATED BY Javadroid FOR `WiCalory` PROJECT
 * AT: 2018/Jun/19 18:28
 */
class NavigatorController(
        private var callback: MutableLiveData<OnBackPressedListener?>,
        private val fragmentManager: FragmentManager,
        val rootView: Int
) {

    var currentFragment: Fragment? = null

    fun <V : BaseViewModel, B : ViewDataBinding> changeFragment(
            fragment: BaseFragment<V, B>,
            animationType: TransitionAnimation,
            backStackTag: String
    ) {
        currentFragment = fragment

        fragmentManager.beginTransaction().apply {
            setCustomAnimation(animationType)
            add(rootView, fragment)
            addToBackStack(backStackTag)
            commitAllowingStateLoss()
        }
    }

// Main Page ---------------------------------------------------------------------------------------

    fun gotoHome() {

        changeFragment(
                newFragmentInstance<HomeFragment>().apply {
                    navigator = this@NavigatorController
                },
                TransitionAnimation.FADE,
                "Dashboard")
    }


}