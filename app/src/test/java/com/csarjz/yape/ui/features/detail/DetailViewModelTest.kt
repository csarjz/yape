package com.csarjz.yape.ui.features.detail

import com.csarjz.domain.model.Recipe
import com.csarjz.domain.usecase.GetRecipeByIdUseCase
import com.csarjz.domain.util.GenericException
import com.csarjz.yape.util.MainDispatcherRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DetailViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @RelaxedMockK
    private lateinit var getRecipeByIdUseCase: GetRecipeByIdUseCase

    private val viewModel by lazy { DetailViewModel(getRecipeByIdUseCase) }
    private val recipeId = "123"
    private val recipe = Recipe(id = recipeId)

    @Before
    fun setUp() = MockKAnnotations.init(this)

    @Test
    fun `get recipe`() = runTest {
        coEvery { getRecipeByIdUseCase(any()) } returns recipe
        viewModel.handleUiEvent(UiEvent.GetRecipe(recipeId))
        assertEquals(viewModel.uiState.value.recipe, recipe)
    }

    @Test
    fun `when showMapButton is clicked`() = runTest {
        viewModel.handleUiEvent(UiEvent.ShowMapButtonClick)
        assertTrue(viewModel.uiState.value.navigateToMap)
    }

    @Test
    fun `when map is shown`() = runTest {
        viewModel.handleUiEvent(UiEvent.MapShown)
        assertFalse(viewModel.uiState.value.navigateToMap)
    }

    @Test
    fun `when throw exception`() = runTest {
        coEvery { getRecipeByIdUseCase(any()) } throws GenericException()
        viewModel.handleUiEvent(UiEvent.GetRecipe(recipeId))
        assertTrue(viewModel.uiState.value.error != null)
    }

    @Test
    fun `when error is shown`() = runTest {
        viewModel.handleUiEvent(UiEvent.ErrorShown)
        assertEquals(viewModel.uiState.value.error, null)
    }
}