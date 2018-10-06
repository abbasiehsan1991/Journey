package codenevisha.ir.app.journey.data

import codenevisha.ir.app.journey.data.pojo.ArticleModel
import codenevisha.ir.app.journey.util.AppConstant

interface AppDataSource {

    interface HomeInterface{

         fun getArticles(callback: LoadDataCallback , force:Boolean)

    }


    /**
     * I create a default callback for bunch of requests
     * But also we can create separate callbacks if we need that
     */
    interface   LoadDataCallback{

        fun onDataLoaded(articlesModel : ArticleModel)
        fun onDataNotAvailable(message : AppConstant.API_RESPONSE_MESSAGES)
    }

}
