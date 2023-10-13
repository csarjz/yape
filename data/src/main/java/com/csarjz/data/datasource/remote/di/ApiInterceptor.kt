package com.csarjz.data.datasource.remote.di

import com.csarjz.domain.util.Constant
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

/**
 * This class is used to inject headers before sending a request.
 * As an example I am adding the headers x-platform and x-version
 */
@Singleton
class ApiInterceptor @Inject constructor(
    @Named("appVersion") private val appVersion: String,
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request().newBuilder().let {
            it.header(Constant.Header.X_PLATFORM, Constant.Header.PLATFORM)
            it.header(Constant.Header.X_VERSION, appVersion)
            it.build()
        }
        return chain.proceed(request)
    }
}
