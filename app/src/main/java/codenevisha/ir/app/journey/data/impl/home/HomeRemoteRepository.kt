package codenevisha.ir.app.journey.data.impl.home

import android.util.Log
import codenevisha.ir.app.journey.data.remote.ServiceGenerator
import codenevisha.ir.app.journey.data.repository.HomeRepository
import codenevisha.ir.app.journey.data.model.ArticleModel
import codenevisha.ir.app.journey.data.remote.APIs
import codenevisha.ir.app.journey.util.AppConstant
import com.yaramobile.wicalory.data.network.ApiError
import codenevisha.ir.app.journey.data.remote.DisposeObservable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeRemoteRepository : HomeRepository.HomeInterface {

    private val apiService: APIs = ServiceGenerator.createService(APIs::class.java)

    override fun getArticlesNormal(callback: HomeRepository.LoadDataCallback, force: Boolean) {

        apiService.getArticles2(AppConstant.API_USER_TOKEN)
                .enqueue(object : Callback<ArticleModel> {

                    override fun onResponse(call: Call<ArticleModel>?, response: Response<ArticleModel>?) {
                        Log.d(TAG, "getArticlesRx: ${response.toString()}")

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
                        Log.d(TAG, "getArticlesRx: ${t.toString()}")
                        callback.onDataNotAvailable(AppConstant.API_RESPONSE_MESSAGES.SERVER_ERROR)
                    }
                })

    }

    override fun getArticlesRx(callback: HomeRepository.LoadDataCallback, force: Boolean) {


        val result = apiService
                .getArticles(AppConstant.API_USER_TOKEN)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(DisposeObservable(
                        { response ->
                            Log.d(TAG, "getArticlesRx: $response")
                            callback.onDataLoaded(response)
                        },
                        {
                            Log.d(TAG, "getArticlesRx: $it")
                            when (it.status) {
                                ApiError.ErrorStatus.BAD_REQUEST -> callback.onDataNotAvailable(AppConstant.API_RESPONSE_MESSAGES.BAD_REQUEST)
                                else -> callback.onDataNotAvailable(AppConstant.API_RESPONSE_MESSAGES.SERVER_ERROR)
                            }

                        }
                ))


    }

    companion object {

        private var INSTANCE: HomeRemoteRepository? = null

        private val TAG = "HomeRemoteRepository"

        val instance: HomeRemoteRepository
            get() {
                if (INSTANCE == null) {
                    INSTANCE = HomeRemoteRepository()
                }
                return INSTANCE!!
            }
    }

}