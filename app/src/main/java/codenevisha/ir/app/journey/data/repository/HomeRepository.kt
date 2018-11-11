package codenevisha.ir.app.journey.data.repository

import codenevisha.ir.app.journey.data.model.ArticleModel
import codenevisha.ir.app.journey.util.AppConstant

interface HomeRepository {

    interface HomeInterface {
        fun getArticlesNormal(callback: LoadDataCallback, force: Boolean)
        fun getArticlesRx(callback: LoadDataCallback, force: Boolean)

    }


    /**
     * I create a default callback for bunch of requests
     * But also we can create separate callbacks if we need that
     */
    interface LoadDataCallback {

        fun onDataLoaded(articlesModel: ArticleModel)
        fun onDataNotAvailable(message: AppConstant.API_RESPONSE_MESSAGES)
    }

}
