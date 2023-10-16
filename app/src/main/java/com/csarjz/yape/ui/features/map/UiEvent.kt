package com.csarjz.yape.ui.features.map

@Suppress("ConvertObjectToDataObject")
sealed interface UiEvent {
    class GetRecipe(val recipeId: String) : UiEvent
    object ErrorShown : UiEvent
}
