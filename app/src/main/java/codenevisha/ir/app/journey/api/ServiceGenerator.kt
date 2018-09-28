package codenevisha.ir.app.journey.api

import java.io.IOException
import java.util.concurrent.TimeUnit

import codenevisha.ir.app.journey.util.AppConstant
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ServiceGenerator {

    private val httpClient = OkHttpClient.Builder()
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