package com.csarjz.yape.ui.features.map

import com.csarjz.domain.model.Recipe

data class UiState(
    val isLoading: Boolean = true,
    val recipe: Recipe? = null,
    val error: Throwable? = null
)
