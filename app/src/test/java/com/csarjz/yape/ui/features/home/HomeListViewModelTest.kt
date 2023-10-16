package com.csarjz.yape.ui.features.home

import com.csarjz.domain.model.Recipe
import com.csarjz.domain.usecase.GetRecipesUseCase
import com.csarjz.domain.usecase.RefreshRecipesUseCase
import com.csarjz.domain.util.GenericException
import com.csarjz.yape.util.MainDispatcherRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeListViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @RelaxedMockK
    private lateinit var getRecipesUseCase: GetRecipesUseCase

    @RelaxedMockK
    private lateinit var refreshRecipesUseCase: RefreshRecipesUseCase

    private val viewModel by lazy {
        HomeListViewModel(getRecipesUseCase, refreshRecipesUseCase)
    }

    private val recipeId1 = "123"
    private val recipeId2 = "456"
    private val recipeList = listOf(
        Recipe(id = recipeId1, name = "Ceviche", ingredients = listOf("Pesacado", "Sal")),
        Recipe(id = recipeId2, ingredients = listOf("Tomate", "Sal al gusto"))
    )

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        coEvery { getRecipesUseCase() } returns flow {
            emit(recipeList)
        }
    }

    @Test
    fun `load recipes`() = runTest {
        viewModel.handleUiEvent(UiEvent.LoadRecipes)
        assertEquals(viewModel.uiState.value.recipes, recipeList)
    }

    @Test
    fun `search recipes`() = runTest {
        viewModel.handleUiEvent(UiEvent.Search("Cevi"))
        assertEquals(viewModel.uiState.value.recipes.first().id, recipeId1)

        viewModel.handleUiEvent(UiEvent.Search("Tomat"))
        assertEquals(viewModel.uiState.value.recipes.first().id, recipeId2)

        viewModel.handleUiEvent(UiEvent.Search("Sal"))
        assertEquals(viewModel.uiState.value.recipes.size, 2)
    }

    @Test
    fun `refresh recipes`() = runTest {
        viewModel.handleUiEvent(UiEvent.RefreshRecipes)
        coVerify(exactly = 1) { refreshRecipesUseCase() }
    }

    @Test
    fun `when recipe item is clicked`() = runTest {
        viewModel.handleUiEvent(UiEvent.RecipeItemClick(recipeId1))
        assertEquals(viewModel.uiState.value.selectedRecipeId, recipeId1)
    }

    @Test
    fun `when detail is shown`() = runTest {
        viewModel.handleUiEvent(UiEvent.DetailShown)
        assertEquals(viewModel.uiState.value.selectedRecipeId, null)
    }

    @Test
    fun `when throw exception`() = runTest {
        coEvery { refreshRecipesUseCase() } throws GenericException()

        viewModel.handleUiEvent(UiEvent.RefreshRecipes)

        assertFalse(viewModel.uiState.value.isLoading)
        assertTrue(viewModel.uiState.value.error != null)
    }

    @Test
    fun `when error is shown`() = runTest {
        viewModel.handleUiEvent(UiEvent.ErrorShown)
        assertEquals(viewModel.uiState.value.error, null)
    }

}