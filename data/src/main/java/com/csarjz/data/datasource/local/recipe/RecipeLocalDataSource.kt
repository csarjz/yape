package com.csarjz.data.datasource.local.recipe

import com.csarjz.data.room.entity.RecipeEntity
import kotlinx.coroutines.flow.Flow

interface RecipeLocalDataSource {

    suspend fun saveRecipes(data: List<RecipeEntity>)

    fun getRecipes(): Flow<List<RecipeEntity>>

    suspend fun getRecipeById(recipeId: String): RecipeEntity?
}
