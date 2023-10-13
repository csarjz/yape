package com.csarjz.yape.ui.features.home

import com.csarjz.domain.model.Recipe

data class UiState(
    val isLoading: Boolean = false,
    val recipes: List<Recipe> = emptyList(),
    var textToSearch: String = String(),
    val selectedRecipeId: String? = null,
    val error: Throwable? = null
)
