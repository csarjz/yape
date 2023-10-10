package com.csarjz.data.datasource.remote.api

import com.csarjz.data.datasource.remote.response.RecipeResponse
import retrofit2.Response
import retrofit2.http.GET

interface AppRestApi {

    @GET("recipe")
    suspend fun getRecipes(): Response<List<RecipeResponse>>
}
