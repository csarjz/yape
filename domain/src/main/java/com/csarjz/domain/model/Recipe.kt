package com.csarjz.domain.model

class Recipe(
    var name: String,
    var description: String,
    var preparation: String,
    var preparationTime: String,
    var numberOfDishes: Int,
    var imageUrl: String,
    var ingredients: List<String>,
    var originLocation: Location
)
