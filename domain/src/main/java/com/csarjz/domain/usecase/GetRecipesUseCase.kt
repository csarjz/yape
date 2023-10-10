package com.csarjz.domain.usecase

import com.csarjz.domain.model.Recipe
import com.csarjz.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRecipesUseCase @Inject constructor(
    private val recipeRepository: RecipeRepository
) {
    operator fun invoke(): Flow<List<Recipe>> = recipeRepository.getRecipes()
}
