package com.csarjz.yape.ui.features.detail

@Suppress("ConvertObjectToDataObject")
sealed interface UiEvent {
    class GetRecipe(val recipeId: String) : UiEvent
    object ShowMapButtonClick : UiEvent
    object MapShown : UiEvent
    object ErrorShown : UiEvent
}
