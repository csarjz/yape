package com.csarjz.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.csarjz.data.room.entity.RecipeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: List<RecipeEntity>)

    @Query("SELECT * FROM recipe")
    fun getRecipes(): Flow<List<RecipeEntity>>

    @Query("SELECT * FROM recipe WHERE id = :recipeId")
    suspend fun getRecipeById(recipeId: String): RecipeEntity

    @Query("DELETE FROM recipe")
    suspend fun deleteAll()
}
