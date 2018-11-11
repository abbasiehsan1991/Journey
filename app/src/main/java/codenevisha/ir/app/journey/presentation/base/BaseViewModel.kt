package codenevisha.ir.app.journey.presentation.base

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField

/**
 * CREATED BY Javadroid FOR `WiCalory` PROJECT
 * AT: 2018/Jun/12 16:32
 */
open class BaseViewModel() : ViewModel() {

    val showProgress: ObservableField<Boolean> = ObservableField()
    val networkError: ObservableField<Boolean> = ObservableField()


    init {
        showProgress.set(false)
        networkError.set(false)
    }

    open fun tryAgainFunction() {

    }

    fun showProgressBar() {
        showProgress.set(true)
    }

    fun hideProgressBar() {
        showProgress.set(false)

    }

    fun showConnectionError() {
        hideProgressBar()
        networkError.set(true)
    }

    fun hideConnectionError() {
        networkError.set(false)
    }
}