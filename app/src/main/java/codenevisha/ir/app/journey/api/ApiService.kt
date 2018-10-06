package codenevisha.ir.app.journey.api

import codenevisha.ir.app.journey.data.pojo.ArticleModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("top-headlines?country=us")
    fun getArticles(@Query("category") category: String,
                    @Query("apiKey") userApiKey: String)
            : Call<ArticleModel>

}