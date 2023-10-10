package com.csarjz.data.datasource.remote.api

import com.csarjz.domain.util.BadRequestException
import com.csarjz.domain.util.Constant.HttpCode
import com.csarjz.domain.util.GenericException
import retrofit2.Response

fun <T> Response<T>?.getBody(): T = when {
    this == null -> throw GenericException()
    isSuccessful -> body() ?: throw GenericException()
    code() == HttpCode.BAD_REQUEST -> throw BadRequestException(errorBody()?.string())
    else -> throw GenericException()
}
