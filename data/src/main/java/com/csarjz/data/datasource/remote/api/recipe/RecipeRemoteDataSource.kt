package com.csarjz.data.datasource.remote.api.recipe

import com.csarjz.data.datasource.remote.response.RecipeResponse

interface RecipeRemoteDataSource {
    suspend fun getRecipes(): List<RecipeResponse>
}
