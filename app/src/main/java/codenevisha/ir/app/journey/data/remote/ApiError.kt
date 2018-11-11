package com.yaramobile.wicalory.data.network

/**
 * CREATED BY Javadroid FOR `WiCalory` PROJECT
 * AT: 2018/Jun/19 16:51
 */
class ApiError(val status: ErrorStatus, val message: String) {


    enum class ErrorStatus {
        UNAUTHORIZED, EMPTY_RESPONSE, TIMEOUT, INTERNAL_ERROR, BAD_REQUEST
    }
}