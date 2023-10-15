package com.csarjz.yape.ui.features.detail

import com.csarjz.domain.model.Recipe

data class UiState(
    val recipe: Recipe? = null,
    val navigateToMap: Boolean = false,
    val error: Throwable? = null
)
