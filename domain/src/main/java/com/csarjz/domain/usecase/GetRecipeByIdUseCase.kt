package com.csarjz.domain.usecase

import com.csarjz.domain.model.Recipe
import com.csarjz.domain.repository.RecipeRepository
import javax.inject.Inject

class GetRecipeByIdUseCase @Inject constructor(
    private val recipeRepository: RecipeRepository
) {
    suspend operator fun invoke(recipeId: String): Recipe? = recipeRepository.getRecipeById(recipeId)
}
