package codenevisha.ir.app.journey.data.impl.home

import codenevisha.ir.app.journey.data.model.ArticleModel
import codenevisha.ir.app.journey.data.repository.HomeRepository
import codenevisha.ir.app.journey.util.AppConstant

class HomeRepositoryImpl
private constructor(
        private val homeRemoteRepository: HomeRepository.HomeInterface,
        private val homeLocalRepository: HomeRepository.HomeInterface)
    : HomeRepository.HomeInterface {

    override fun getArticlesNormal(callback: HomeRepository.LoadDataCallback, force: Boolean) {
        getArticlesRx(callback, force)
    }


    override fun getArticlesRx(callback: HomeRepository.LoadDataCallback, force: Boolean) {

        if (force)
            getArticlesFromRemoteDataSource(callback, force)
        else
            getArticlesFromLocalDataSource(callback, force)
    }


    private fun getArticlesFromRemoteDataSource(callback: HomeRepository.LoadDataCallback, force: Boolean) {

        homeRemoteRepository.getArticlesRx(object : HomeRepository.LoadDataCallback {
            override fun onDataLoaded(articlesModel: ArticleModel) {
                callback.onDataLoaded(articlesModel)
            }

            override fun onDataNotAvailable(message: AppConstant.API_RESPONSE_MESSAGES) {
                callback.onDataNotAvailable(message)
            }
        }, force)
    }

    private fun getArticlesFromLocalDataSource(callback: HomeRepository.LoadDataCallback, force: Boolean) {

        homeLocalRepository.getArticlesRx(object : HomeRepository.LoadDataCallback {
            override fun onDataLoaded(articlesModel: ArticleModel) {
                callback.onDataLoaded(articlesModel)
            }

            override fun onDataNotAvailable(message: AppConstant.API_RESPONSE_MESSAGES) {
                callback.onDataNotAvailable(message)
            }
        }, force)
    }

    companion object {

        private var INSTANCE: HomeRepositoryImpl? = null


        /**
         * Returns the single instance of this class, creating it if necessary.
         *
         * @param appRemoteDataSource the backend data source
         * @param appLocalDataSource  the device storage data source
         * @return the [HomeRepositoryImpl] instance
         */
        fun getInstance(
                homeRemoteRepository: HomeRepository.HomeInterface,
                homeLocalRepository: HomeRepository.HomeInterface
        ): HomeRepositoryImpl {

            if (INSTANCE == null)
                INSTANCE = HomeRepositoryImpl(homeRemoteRepository, homeLocalRepository)

            return INSTANCE!!
        }


        /**
         *Clear Available Instance
         */
        fun destroyInstance() {
            INSTANCE = null
        }
    }

}

