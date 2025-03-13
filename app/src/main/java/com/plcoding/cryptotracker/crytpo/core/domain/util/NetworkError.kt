package com.plcoding.cryptotracker.crytpo.core.domain.util

enum class NetworkError:Error {

    REQUEST_TIMEOUT,
    UNKNOWN,
    TOO_MANY_REQUESTS,
    SERIALIZATION,
    NO_INTERNET,
    SERVER_ERROR

}