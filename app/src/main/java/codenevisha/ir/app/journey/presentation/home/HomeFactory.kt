package codenevisha.ir.app.journey.presentation.home

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import codenevisha.ir.app.journey.data.impl.home.HomeRepositoryImpl

/**
 * CREATED BY Javadroid FOR `Journey` PROJECT
 * AT: 2018/Nov/11 15:00
 */
class HomeFactory(
        private val mAppRepository: HomeRepositoryImpl
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(mAppRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: Add your new ViewModel into ViewmodelFactory.class") as Throwable
    }

}
