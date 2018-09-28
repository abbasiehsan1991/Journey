package codenevisha.ir.app.journey.util

class AppConstant{
    companion object {

        val API_BASE_URL = "https://newsapi.org/v2/"
        val USER_TOKEN = "089aa21e5b8548b8bc9f3c0f480f4590"
        val API_COUNTRY = "us"

        val RESPONSE_REQUEST_400 = 400

    }

    enum class API_RESPONSE_MESSAGES{
        SERVER_ERROR,
        BAD_REQUEST
    }
}