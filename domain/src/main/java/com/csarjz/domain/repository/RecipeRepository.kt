package com.csarjz.domain.repository

import com.csarjz.domain.model.Recipe
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {

    fun getRecipes(): Flow<List<Recipe>>

    suspend fun getRecipeById(recipeId: String): Recipe?

    suspend fun refreshFromRemoteRecipes()

    suspend fun saveRecipesLocally(data: List<Recipe>)
}
