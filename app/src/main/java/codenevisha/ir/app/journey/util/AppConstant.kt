package codenevisha.ir.app.journey.util

class AppConstant{
    companion object {

        val API_BASE_URL = "https://newsapi.org/v2/"
        val API_USER_TOKEN = "be98e3602adc466b92db02e7f59cc5c0"
        val API_COUNTRY = "us"
        val API_CATEGORY = "=business"

        val RESPONSE_REQUEST_400 = 400

    }

    enum class API_RESPONSE_MESSAGES{
        SERVER_ERROR,
        BAD_REQUEST
    }
}