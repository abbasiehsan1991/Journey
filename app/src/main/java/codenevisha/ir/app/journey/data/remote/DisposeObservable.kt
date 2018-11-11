package codenevisha.ir.app.journey.data.remote

import codenevisha.ir.app.journey.util.Logger
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.yaramobile.wicalory.data.network.ApiError
import io.reactivex.observers.DisposableObserver
import okhttp3.ResponseBody
import retrofit2.Response

/**
 * CREATED BY Javadroid FOR `WiCalory` PROJECT
 * AT: 2018/Jul/23 17:28
 */
class DisposeObservable<T>(
        private val success: (body: T) -> Unit,
        private val failure: (error: ApiError) -> Unit = {}
) : DisposableObserver<Response<T>>() {

    override fun onComplete() {
    }

    override fun onNext(t: Response<T>) {
        if (t.body() == null || (t.body() is List<*> && (t.body() as List<*>).size == 0)) {
            failure(ApiError(ApiError.ErrorStatus.EMPTY_RESPONSE, "خطایی در برقراری ارتباط رخ داده، لطفا دوباره تلاش کنید"))
            getErrorMessage(t.errorBody())
            return
        }

        if (t.code() == 400 || t.code() == 404) { // Bad Request
            failure(ApiError(ApiError.ErrorStatus.BAD_REQUEST, "خطایی در برقراری ارتباط رخ داده، لطفا دوباره تلاش کنید"))
            getErrorMessage(t.errorBody())
            return
        }

        if (t.code() == 401) {  // unAuthorized
            failure(ApiError(ApiError.ErrorStatus.UNAUTHORIZED, "برای انجام این عمل باید وارد حساب کاربری خود شوید."))
            getErrorMessage(t.errorBody())
            return
        }
        success(t.body() as T)
    }

    override fun onError(e: Throwable) {
        failure(ApiError(ApiError.ErrorStatus.INTERNAL_ERROR, "خطایی در برقراری ارتباط رخ داده، لطفا دوباره تلاش کنید"))
    }

    private fun getErrorMessage(errorBody: ResponseBody?): String = try {
        val result = errorBody?.string()?.replace("\n", " ")?.replace("   ", " ")
        Logger.printLog("DisposeObservable: errorBody = [$result]", Logger.LOG_E)
        val json = Gson().fromJson(result, JsonObject::class.java)
        json.get("message").asString
    } catch (t: Throwable) {
        ""
    }
}