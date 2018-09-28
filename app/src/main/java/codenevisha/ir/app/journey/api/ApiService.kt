package codenevisha.ir.app.journey.api

import codenevisha.ir.app.journey.data.pojo.Article
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {


    @GET("top-headlines?country={country}&apiKey={user_api_key}")
    abstract fun getArticles(@Path("country") country : String,
                             @Path("user_api_key") userApiKey: String)
            :Call<List<Article>>

}