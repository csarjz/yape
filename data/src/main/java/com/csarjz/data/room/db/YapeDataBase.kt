package com.csarjz.data.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.csarjz.data.room.dao.RecipeDao
import com.csarjz.data.room.entity.RecipeEntity

@Database(
    version = 1,
    entities = [RecipeEntity::class]
)
abstract class YapeDataBase : RoomDatabase() {

    abstract fun recipeDao(): RecipeDao
}
