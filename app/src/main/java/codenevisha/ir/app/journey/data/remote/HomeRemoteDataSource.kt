package codenevisha.ir.app.journey.data.remote

import codenevisha.ir.app.journey.api.ApiService
import codenevisha.ir.app.journey.api.ServiceGenerator
import codenevisha.ir.app.journey.data.AppDataSource
import codenevisha.ir.app.journey.data.pojo.Article
import codenevisha.ir.app.journey.util.AppConstant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeRemoteDataSource : AppDataSource.HomeInterface {

    override fun getArticles(callback: AppDataSource.LoadDataCallback,force:Boolean) {

        val apiService = ServiceGenerator.createService(ApiService::class.java)
        apiService.getArticles(AppConstant.API_COUNTRY, AppConstant.USER_TOKEN)
                .enqueue(object : Callback<List<Article>> {

                    override fun onResponse(call: Call<List<Article>>?, response: Response<List<Article>>?) {

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

                    override fun onFailure(call: Call<List<Article>>?, t: Throwable?) {

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