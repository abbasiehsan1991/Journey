package codenevisha.ir.app.journey.presentation

import android.content.Context
import codenevisha.ir.app.journey.R
import codenevisha.ir.app.journey.databinding.ActivityMainBinding
import codenevisha.ir.app.journey.presentation.base.BaseActivity
import codenevisha.ir.app.journey.presentation.base.NavigatorController
import codenevisha.ir.app.journey.util.helper.LocaleHelper

/**
 * CREATED BY Javadroid FOR `Journey` PROJECT
 * AT: 2018/Nov/11 14:51
 */

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>(){

    override val layoutId: Int = R.layout.activity_main

    private val navigator: NavigatorController by lazy { NavigatorController(backCallback, supportFragmentManager, binding.root.id) }


    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase, "fa"))
    }

    override fun onStart() {
        super.onStart()
        navigator.gotoHome()
    }

    override fun onBackPressed() {
        println("entrycount-> ${supportFragmentManager.backStackEntryCount} ")
        if (supportFragmentManager.backStackEntryCount == 1) {
            finish()
        } else {
            super.onBackPressed()
        }
    }


}