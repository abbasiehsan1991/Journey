package codenevisha.ir.app.journey.data.remote

import codenevisha.ir.app.journey.data.model.ArticleModel
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * CREATED BY Javadroid FOR `Journey` PROJECT
 * AT: 2018/Nov/11 15:49
 */
interface APIs{

    @GET("top-headlines?country=us&category=business")
    fun getArticles(
            @Query("apiKey") userApiKey: String)
            : Observable<Response<ArticleModel>>

    @GET("top-headlines?country=us&category=business")
    fun getArticles2(
            @Query("apiKey") userApiKey: String)
            : Call<ArticleModel>
}