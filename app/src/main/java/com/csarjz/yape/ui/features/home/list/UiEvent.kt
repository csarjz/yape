package com.csarjz.yape.ui.features.home.list

@Suppress("ConvertObjectToDataObject")
sealed interface UiEvent {
    object LoadRecipes : UiEvent
    object RefreshRecipes : UiEvent
    class Search(val text: String) : UiEvent
    class RecipeItemClick(val recipeId: String) : UiEvent
    object DetailShown : UiEvent
    object ErrorShown : UiEvent
}
