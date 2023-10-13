package com.csarjz.data.mapper

import com.csarjz.data.datasource.remote.response.RecipeResponse
import com.csarjz.data.room.entity.RecipeEntity
import com.csarjz.domain.model.Location
import com.csarjz.domain.model.Recipe
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun Recipe.toRoomEntity(): RecipeEntity {
    val gson = Gson()
    return RecipeEntity(
        id = id,
        name = name,
        description = description,
        preparation = preparation,
        preparationTime = preparationTime,
        numberOfDishes = numberOfDishes,
        imageUrl = imageUrl,
        ingredients = gson.toJson(ingredients),
        originLocation = gson.toJson(originLocation)
    )
}

fun RecipeEntity.toDomain(): Recipe {
    val gson = Gson()
    return Recipe(
        id = id,
        name = name,
        description = description,
        preparation = preparation,
        preparationTime = preparationTime,
        numberOfDishes = numberOfDishes,
        imageUrl = imageUrl,
        ingredients = gson.fromJson(ingredients, object : TypeToken<List<String>>() {}.type),
        originLocation = gson.fromJson(originLocation, Location::class.java)
    )
}

fun RecipeResponse.toDomain() = Recipe(
    id = id.orEmpty(),
    name = name.orEmpty(),
    description = description.orEmpty(),
    preparation = preparation.orEmpty(),
    preparationTime = preparationTime.orEmpty(),
    numberOfDishes = numberOfDishes ?: 0,
    imageUrl = imageUrl.orEmpty(),
    ingredients = ingredients ?: emptyList(),
    originLocation = originLocation?.toDomain() ?: Location()
)
