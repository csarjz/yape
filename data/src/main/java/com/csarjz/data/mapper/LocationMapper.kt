package com.csarjz.data.mapper

import com.csarjz.data.datasource.remote.response.LocationResponse
import com.csarjz.domain.model.Location
import com.csarjz.domain.util.Constant.Number

fun LocationResponse.toDomain() = Location(
    latitude = latitude ?: Number.ZERO_DEC,
    longitude = longitude ?: Number.ZERO_DEC
)
