package com.project.D3919253

import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class CartViewModel(private val context: Context) : ViewModel() {
    private val cartPreferences = CartPreferences(context)
    private var _cartItems = mutableStateListOf<FoodModel>().apply {
        addAll(cartPreferences.loadCart())
    }

    val cartItems: List<FoodModel> = _cartItems
    //var cartItems: List<FoodModel> = ArrayList<FoodModel>(_cartItems)

    private val _bookings = mutableStateListOf<FoodModel>().apply {
        addAll(cartPreferences.loadOrderedItems())
    }

    val bookings: List<FoodModel> = _bookings

    fun addItemToCart(item: FoodModel) {
        cartPreferences.saveSingleItem(item)
    }

    fun placeOrder() {
        cartPreferences.addOrderedItems(_cartItems)
        _cartItems.clear()
        cartPreferences.clearCart()

        Log.d("cart:", "placeOrder: cartItems size after clearing: ${_cartItems.size}")
        Log.d("cart:", "placeOrder: items left in shared preferences: ${cartPreferences.loadCart().size}")
    }

    val totalPrice: String
        get() = _cartItems.sumOf { it.price.toDouble() }.toString()
}

