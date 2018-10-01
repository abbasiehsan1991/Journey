package codenevisha.ir.app.journey.data

import codenevisha.ir.app.journey.data.pojo.Article
import codenevisha.ir.app.journey.util.AppConstant
import retrofit2.Response

interface AppDataSource {

    interface HomeInterface{

         fun getArticles(callback: LoadDataCallback , force:Boolean)

    }


    /**
     * I create a default callback for bunch of requests
     * But also we can create separate callbacks if we need that
     */
    interface   LoadDataCallback{

        fun onDataLoaded(articles : List<Any>)
        fun onDataNotAvailable(message : AppConstant.API_RESPONSE_MESSAGES)
    }

}