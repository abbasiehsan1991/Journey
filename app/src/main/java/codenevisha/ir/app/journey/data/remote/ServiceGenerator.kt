package codenevisha.ir.app.journey.data.remote

import android.util.Log
import codenevisha.ir.app.journey.util.AppConstant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object ServiceGenerator {

    private const val TAG :String = "NET_REQUEST_RESPONSES"

    var httpLoggingInterceptor =
            HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message ->

                Log.d(TAG, "APIService $message")

            }).setLevel(HttpLoggingInterceptor.Level.BODY)!!

    private val httpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)

    private val builder = Retrofit.Builder()
            .baseUrl(AppConstant.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

    fun <S> createService(serviceClass: Class<S>): S {

        httpClient.addInterceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
                    .header("Accept", "application/json")
                    .method(original.method(), original.body())
            val request = requestBuilder.build()
            chain.proceed(request)
        }
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create())

        val client = httpClient.build()
        val retrofit = builder.client(client).build()
        return retrofit.create(serviceClass)
    }

    /**
     * Maybe this method will not be used any where but I create it just
     * to show the usage of passing some values inorder to set them in the header
     * for bunch of request instead to to set header for them separately in @[ApiService] methods
     */
    fun <S> createService(serviceClass: Class<S>, token: String): S {

        httpClient.addInterceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
                    .header("Accept", "application/json")
                    .header("Accept-Language", "en")
                    .header("Authorization", "jwt $token")
                    .method(original.method(), original.body())
            val request = requestBuilder.build()
            chain.proceed(request)
        }

        val client = httpClient.build()
        val retrofit = builder.client(client).build()
        return retrofit.create(serviceClass)
    }
}