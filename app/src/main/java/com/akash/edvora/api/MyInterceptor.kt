package com.akash.edvora.api

import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Content-type", "application/json")
            .addHeader("X-platform", "Android")
            .addHeader("X-Auth-Token", "12345678")
            .build()
        return chain.proceed(request)
    }
}