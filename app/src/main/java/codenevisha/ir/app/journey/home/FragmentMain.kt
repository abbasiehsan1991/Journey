package codenevisha.ir.app.journey.home

import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import codenevisha.ir.app.journey.databinding.FragmentMainBinding
import codenevisha.ir.app.journey.util.SnackbarMessage
import codenevisha.ir.app.journey.util.SnackbarUtils
import java.util.*

class FragmentMain : Fragment() {

    private lateinit var viewModel: ViewmodelMain

    private lateinit var fragmentBinding: FragmentMainBinding

    private var mListAdapter: AdapterHome? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = (activity as ActivityMain).obtainViewmodelMain()
        viewModel.start()

        mListAdapter = AdapterHome(ArrayList(0))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentBinding = FragmentMainBinding.inflate(inflater, container, false)
        val root = fragmentBinding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentBinding.setLifecycleOwner(this)
        fragmentBinding.viewmodel = viewModel

        //prepare snake bar to show messages
        setupSnakbar()

        //prepare recyclerView
        setupRecyclerMain()
    }

    private fun setupSnakbar() {
        viewModel.getSnackbarMessage().observe(this, object : SnackbarMessage.SnackbarObserver {
            override fun onNewMessage(@StringRes snackbarMessageResourceId: Int) {

                SnackbarUtils.showSnackbar(view, getString(snackbarMessageResourceId))

            }
        })
    }


    private fun setupRecyclerMain() {
        fragmentBinding.recyclerFragmentMain.layoutManager = LinearLayoutManager(activity)
        fragmentBinding.recyclerFragmentMain.adapter = mListAdapter
        fragmentBinding.recyclerFragmentMain.hasFixedSize()
    }


    companion object {
        val FRAGMENT_NAME: String = FragmentMain::class.java.name

        fun newInstance(): FragmentMain {

            val fragmentMain = FragmentMain()
            val args = Bundle()
            fragmentMain.arguments = args

            return fragmentMain
        }
    }
}