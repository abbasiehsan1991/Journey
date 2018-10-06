package codenevisha.ir.app.journey.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import codenevisha.ir.app.journey.R

class FragmentMain : Fragment() {

    lateinit var viewModel: ViewmodelMain

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = (activity as ActivityMain).obtainViewmodelMain()
        viewModel.start()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_main, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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