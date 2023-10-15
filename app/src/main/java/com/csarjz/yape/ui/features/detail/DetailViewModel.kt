package com.csarjz.yape.ui.features.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.csarjz.domain.usecase.GetRecipeByIdUseCase
import com.csarjz.domain.util.GenericException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getRecipeByIdUseCase: GetRecipeByIdUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun handleUiEvent(uiEvent: UiEvent) = viewModelScope.launch {
        when (uiEvent) {
            is UiEvent.GetRecipe -> getRecipe(uiEvent.recipeId)
            is UiEvent.ShowMapButtonClick -> _uiState.update { it.copy(navigateToMap = true) }
            is UiEvent.MapShown -> _uiState.update { it.copy(navigateToMap = false) }
            is UiEvent.ErrorShown -> _uiState.update { it.copy(error = null) }
        }
    }

    private suspend fun getRecipe(recipeId: String) {
        try {
            if (_uiState.value.recipe != null) {
                return
            }
            val recipe = getRecipeByIdUseCase(recipeId) ?: throw GenericException()
            _uiState.update { it.copy(recipe = recipe) }
        } catch (throwable: Throwable) {
            _uiState.update { it.copy(error = throwable) }
        }
    }
}
