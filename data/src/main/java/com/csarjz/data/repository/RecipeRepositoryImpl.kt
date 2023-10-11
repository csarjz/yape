package com.csarjz.data.repository

import com.csarjz.data.datasource.local.recipe.RecipeLocalDataSource
import com.csarjz.data.datasource.remote.api.recipe.RecipeRemoteDataSource
import com.csarjz.data.mapper.toDomain
import com.csarjz.data.mapper.toRoomEntity
import com.csarjz.domain.model.Recipe
import com.csarjz.domain.repository.RecipeRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val ioDispatcher: CoroutineDispatcher,
    private val recipeLocalDataSource: RecipeLocalDataSource,
    private val recipeRemoteDataSource: RecipeRemoteDataSource
) : RecipeRepository {

    override fun getRecipes(): Flow<List<Recipe>> {
        return recipeLocalDataSource.getRecipes().map { recipes ->
            recipes.map { recipe -> recipe.toDomain() }
        }
    }

    override suspend fun getRecipeById(recipeId: String): Recipe? = withContext(ioDispatcher) {
        recipeLocalDataSource.getRecipeById(recipeId)?.toDomain()
    }

    override suspend fun refreshFromRemoteRecipes() = withContext(ioDispatcher) {
        val recipes: List<Recipe> = recipeRemoteDataSource.getRecipes().map { it.toDomain() }
        if (recipes.isNotEmpty()) {
            recipeLocalDataSource.saveRecipes(recipes.map { it.toRoomEntity() })
        }
    }
}
