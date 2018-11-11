package codenevisha.ir.app.journey.presentation.home

import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ProgressBar
import codenevisha.ir.app.journey.R
import codenevisha.ir.app.journey.app.Injection
import codenevisha.ir.app.journey.data.impl.home.HomeRepositoryImpl
import codenevisha.ir.app.journey.databinding.FragmentMainBinding
import codenevisha.ir.app.journey.presentation.base.BaseFragment
import codenevisha.ir.app.journey.presentation.base.NavigatorController
import codenevisha.ir.app.journey.util.SnackbarMessage
import codenevisha.ir.app.journey.util.SnackbarUtils
import java.util.*

/**
 * CREATED BY Javadroid FOR `Journey` PROJECT
 * AT: 2018/Nov/11 14:47
 */
class HomeFragment : BaseFragment<HomeViewModel, FragmentMainBinding>() {

    override var title: String = "Home"
    override var menuId: Int = 0
    override val layoutId: Int = R.layout.fragment_main
    override val toolbar: Toolbar? = null
    override val progressBar: ProgressBar? = null

    private val appRepository: HomeRepositoryImpl by lazy { Injection.provideApplicationRepository(context!!) }
    private val mListAdapter: HomeAdapter? by lazy { HomeAdapter(ArrayList(0)) }
    lateinit var navigator: NavigatorController


    companion object {
        val FRAGMENT_NAME: String = HomeFragment::class.java.name
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelFactory = HomeFactory(appRepository)
        binding.viewmodel = viewModel
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        with(viewModel) {

            start()

            mSnackbarText.observe(this@HomeFragment, object : SnackbarMessage.SnackbarObserver {
                override fun onNewMessage(@StringRes snackbarMessageResourceId: Int) {
                    SnackbarUtils.showSnackbar(view, getString(snackbarMessageResourceId))
                }
            })

        }
        binding.recyclerFragmentMain.adapter = mListAdapter
        binding.recyclerFragmentMain.hasFixedSize()
    }
}