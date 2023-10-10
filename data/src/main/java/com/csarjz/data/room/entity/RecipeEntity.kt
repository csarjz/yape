package com.csarjz.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe")
class RecipeEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: String,
    @ColumnInfo(name = "name")
    var name: String = String(),
    @ColumnInfo(name = "description")
    var description: String = String(),
    @ColumnInfo(name = "preparation")
    var preparation: String = String(),
    @ColumnInfo(name = "preparationTime")
    var preparationTime: String = String(),
    @ColumnInfo(name = "numberOfDishes")
    var numberOfDishes: String = String(),
    @ColumnInfo(name = "imageUrl")
    var imageUrl: String = String(),
    @ColumnInfo(name = "ingredients")
    var ingredients: String = String(),
    @ColumnInfo(name = "originLocation")
    var originLocation: String = String()
)
