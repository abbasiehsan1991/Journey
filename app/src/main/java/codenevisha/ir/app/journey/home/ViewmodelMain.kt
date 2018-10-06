package codenevisha.ir.app.journey.home

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import codenevisha.ir.app.journey.R
import codenevisha.ir.app.journey.data.AppDataSource
import codenevisha.ir.app.journey.data.AppRepository
import codenevisha.ir.app.journey.data.pojo.Article
import codenevisha.ir.app.journey.data.pojo.ArticleModel
import codenevisha.ir.app.journey.util.AppConstant
import codenevisha.ir.app.journey.util.SnackbarMessage


/**
 * Exposes the data to be used in the task list screen.
 *
 *
 * [BaseObservable] implements a listener registration mechanism which is notified when a
 * property changes. This is done by assigning a [Bindable] annotation to the property's
 * getter method.
 */
class ViewmodelMain constructor(private val mTasksRepository: AppRepository, context: Application)
    : AndroidViewModel(context) {

    val itemArticles = MutableLiveData<List<Article>>()

    val dataLoading = MutableLiveData<Boolean>()

    val empty = MutableLiveData<Boolean>()

    private val isDataLoadingError = MutableLiveData<Boolean>()

    private val mSnackbarText = SnackbarMessage()

    fun getSnackbarMessage(): SnackbarMessage {
        return mSnackbarText
    }


    fun start() {
        loadTasks(true, true)
    }

    private fun loadTasks(forceUpdate: Boolean, showLoadingUI: Boolean) {

        if (showLoadingUI) {
            dataLoading.setValue(true)
        }


        mTasksRepository.getArticles(object : AppDataSource.LoadDataCallback {

            override fun onDataLoaded(articlesModel: ArticleModel) {

                if (showLoadingUI)
                    dataLoading.value = false

                isDataLoadingError.value = false

                empty.value = articlesModel.articles?.isEmpty()

                itemArticles.value = articlesModel.articles as List<Article>

            }

            override fun onDataNotAvailable(message: AppConstant.API_RESPONSE_MESSAGES) {

                if (showLoadingUI)
                    dataLoading.value = false

                isDataLoadingError.value = true

                mSnackbarText.value = R.string.error_faild_get_data
            }

        }, true)

    }

    companion object {
        private val TAG = "HomeViewmodel"
    }


}