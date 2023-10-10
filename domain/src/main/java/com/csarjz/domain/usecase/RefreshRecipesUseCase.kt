package com.csarjz.domain.usecase

import com.csarjz.domain.repository.RecipeRepository
import javax.inject.Inject

class RefreshRecipesUseCase @Inject constructor(
    private val recipeRepository: RecipeRepository
) {
    suspend operator fun invoke() = recipeRepository.refreshFromRemoteRecipes()
}
