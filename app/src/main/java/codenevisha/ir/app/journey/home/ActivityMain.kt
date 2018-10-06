package codenevisha.ir.app.journey.home

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import codenevisha.ir.app.journey.Injection
import codenevisha.ir.app.journey.R
import codenevisha.ir.app.journey.data.AppRepository
import codenevisha.ir.app.journey.util.ActivityUtils
import codenevisha.ir.app.journey.util.ViewModelFactory

class ActivityMain : AppCompatActivity() {

    private var fragmentMain = FragmentMain()
    private lateinit var appRepository: AppRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewFragmentMain()

        appRepository = Injection.provideApplicationRepository(applicationContext)

    }

    private fun setupViewFragmentMain() {
        // Create the fragment
        fragmentMain = FragmentMain.newInstance()

        ActivityUtils.replaceFragmentInActivity(
                supportFragmentManager, fragmentMain,
                R.id.fragment_container, FragmentMain.FRAGMENT_NAME)

    }

    /**
     * @param activity contains the [FragmentActivity]
     * @return [HomeViewmodel] that belongs to [FragmentActivity]
     */
    fun obtainViewmodelMain(): ViewmodelMain {

        // Use a Factory to inject dependencies into the ViewModel
        val factory = ViewModelFactory(this.application, appRepository)

        return ViewModelProviders.of(this, factory).get(ViewmodelMain::class.java)
    }
}
