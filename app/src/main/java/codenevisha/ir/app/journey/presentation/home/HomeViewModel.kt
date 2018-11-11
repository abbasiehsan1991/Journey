package codenevisha.ir.app.journey.presentation.home

import android.arch.lifecycle.MutableLiveData
import codenevisha.ir.app.journey.R
import codenevisha.ir.app.journey.data.impl.home.HomeRepositoryImpl
import codenevisha.ir.app.journey.data.model.Article
import codenevisha.ir.app.journey.data.model.ArticleModel
import codenevisha.ir.app.journey.data.repository.HomeRepository
import codenevisha.ir.app.journey.presentation.base.BaseViewModel
import codenevisha.ir.app.journey.util.AppConstant
import codenevisha.ir.app.journey.util.SnackbarMessage

/**
 * CREATED BY Javadroid FOR `Journey` PROJECT
 * AT: 2018/Nov/11 14:47
 */
class HomeViewModel constructor(
        private val mTasksRepository: HomeRepositoryImpl
) : BaseViewModel() {

    companion object {
        private val TAG = "HomeViewmodel"
    }

    val itemArticles = MutableLiveData<ArrayList<Article>>()
    val dataLoading = MutableLiveData<Boolean>()
    val empty = MutableLiveData<Boolean>()

    private val isDataLoadingError = MutableLiveData<Boolean>()
    val mSnackbarText = SnackbarMessage()


    fun start() {
        loadTasks(true, true)
    }

    private fun loadTasks(forceUpdate: Boolean, showLoadingUI: Boolean) {

        if (showLoadingUI) {
            dataLoading.value = true
        }


        mTasksRepository.getArticlesRx(object : HomeRepository.LoadDataCallback {

            override fun onDataLoaded(articlesModel: ArticleModel) {

                if (showLoadingUI)
                    dataLoading.value = false

                isDataLoadingError.value = false

                empty.value = articlesModel.articles?.isEmpty()

                itemArticles.value = articlesModel.articles as ArrayList<Article>

            }

            override fun onDataNotAvailable(message: AppConstant.API_RESPONSE_MESSAGES) {

                if (showLoadingUI)
                    dataLoading.value = false

                isDataLoadingError.value = true

                mSnackbarText.value = R.string.error_faild_get_data
            }

        }, true)

    }


}