package codenevisha.ir.app.journey.data.remote

import android.util.Log
import codenevisha.ir.app.journey.api.ApiService
import codenevisha.ir.app.journey.api.ServiceGenerator
import codenevisha.ir.app.journey.data.AppDataSource
import codenevisha.ir.app.journey.data.pojo.ArticleModel
import codenevisha.ir.app.journey.util.AppConstant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeRemoteDataSource : AppDataSource.HomeInterface {

    override fun getArticles(callback: AppDataSource.LoadDataCallback, force: Boolean) {

        val apiService = ServiceGenerator.createService(ApiService::class.java)
        apiService.getArticles(AppConstant.API_USER_TOKEN)
                .enqueue(object : Callback<ArticleModel> {

                    override fun onResponse(call: Call<ArticleModel>?, response: Response<ArticleModel>?) {
                        Log.d(TAG, "getArticles: ${response.toString()}")

                        response?.let {

                            if (response.isSuccessful) {

                                callback.onDataLoaded(response.body()!!)

                            } else {

                                if (response.code() == AppConstant.RESPONSE_REQUEST_400)
                                    callback.onDataNotAvailable(AppConstant.API_RESPONSE_MESSAGES.BAD_REQUEST)
                                else
                                    callback.onDataNotAvailable(AppConstant.API_RESPONSE_MESSAGES.SERVER_ERROR)

                            }
                        }
                    }

                    override fun onFailure(call: Call<ArticleModel>?, t: Throwable?) {
                        Log.d(TAG, "getArticles: ${t.toString()}")
                        callback.onDataNotAvailable(AppConstant.API_RESPONSE_MESSAGES.SERVER_ERROR)
                    }
                })

    }

    companion object {

        private var INSTANCE: HomeRemoteDataSource? = null

        private val TAG = "HomeRemoteDataSource"

        val instance: HomeRemoteDataSource
            get() {
                if (INSTANCE == null) {
                    INSTANCE = HomeRemoteDataSource()
                }
                return INSTANCE!!
            }
    }

}