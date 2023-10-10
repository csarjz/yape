package com.csarjz.data.datasource.remote.api.recipe

import com.csarjz.data.datasource.remote.api.AppRestApi
import com.csarjz.data.datasource.remote.api.getBody
import com.csarjz.data.datasource.remote.response.RecipeResponse
import javax.inject.Inject

class RecipeRemoteDataSourceImpl @Inject constructor(
    private val api: AppRestApi
) : RecipeRemoteDataSource {

    override suspend fun getRecipes(): List<RecipeResponse> = api.getRecipes().getBody()
}
