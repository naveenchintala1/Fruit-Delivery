package com.project.fruitdelivery

data class FoodModel(
    val id: String = "",
    val name: String = "",
    val weight: String = "",
    val unit: String = "",
    val price: String = "",
    val imageUrl: String = "",
    var quantity: Int = 0
)
