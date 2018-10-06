package codenevisha.ir.app.journey.data

import codenevisha.ir.app.journey.data.pojo.ArticleModel
import codenevisha.ir.app.journey.util.AppConstant

class AppRepository
private constructor(
        private val homeRemoteDataSource: AppDataSource.HomeInterface,
        private val homeLocalDataSource: AppDataSource.HomeInterface)
    : AppDataSource.HomeInterface {


    override fun getArticles(callback: AppDataSource.LoadDataCallback, force: Boolean) {

        if (force)
            getArticlesFromRemoteDataSource(callback , force)
        else
            getArticlesFromLocalDataSource(callback , force)
    }


    private fun getArticlesFromRemoteDataSource(callback: AppDataSource.LoadDataCallback , force: Boolean) {

        homeRemoteDataSource.getArticles(object  : AppDataSource.LoadDataCallback {
            override fun onDataLoaded(articlesModel: ArticleModel) {
                callback.onDataLoaded(articlesModel)
            }

            override fun onDataNotAvailable(message: AppConstant.API_RESPONSE_MESSAGES) {
                callback.onDataNotAvailable(message)
            }
        } , force)
    }

    private fun getArticlesFromLocalDataSource(callback: AppDataSource.LoadDataCallback ,force: Boolean) {

        homeLocalDataSource.getArticles(object  : AppDataSource.LoadDataCallback {
            override fun onDataLoaded(articlesModel: ArticleModel) {
                callback.onDataLoaded(articlesModel)
            }

            override fun onDataNotAvailable(message: AppConstant.API_RESPONSE_MESSAGES) {
                callback.onDataNotAvailable(message)
            }
        } , force)
    }

    companion object {

        private var INSTANCE: AppRepository? = null


        /**
         * Returns the single instance of this class, creating it if necessary.
         *
         * @param appRemoteDataSource the backend data source
         * @param appLocalDataSource  the device storage data source
         * @return the [AppRepository] instance
         */
        fun getInstance(
                homeRemoteDataSource: AppDataSource.HomeInterface,
                homeLocalDataSource: AppDataSource.HomeInterface
        ): AppRepository {

            if (INSTANCE == null)
                INSTANCE = AppRepository(homeRemoteDataSource, homeLocalDataSource)

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

