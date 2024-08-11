package com.project.fruitdelivery

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.edit
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import java.io.StringReader
import kotlin.math.log

class CartPreferences(context: Context) {
    private val sharedPreferences = context.getSharedPreferences("CartPrefs", 0)
    private val editor = sharedPreferences.edit();
    private val gson = Gson()

    fun saveCart(cartItems: List<FoodModel>) {
        val json = gson.toJson(cartItems)
        sharedPreferences.edit().putString("cart_items", json).apply()
    }

    fun saveSingleItem(item: FoodModel) {
        var _cartItems = mutableStateListOf<FoodModel>().apply {
            addAll(loadCart())
        }
        val existingItemIndex = _cartItems.indexOfFirst { it.id == item.id }
        if (existingItemIndex != -1) {
            _cartItems[existingItemIndex] = item
        } else {
            _cartItems.add(item)
        }
        saveCart(_cartItems)
    }

    fun loadCart(): List<FoodModel> {
        val json = sharedPreferences.getString("cart_items", null) ?: "[]"
        return safelyParseJson(json)
    }

    fun clearCart() {
        //sharedPreferences.edit().remove("cart_items").apply()
        editor.putString("cart_items", "[]").apply()

        if(sharedPreferences.getString("cart_items","").equals("[]")){
            Log.d("cart : ", "clearCart: " + "cart is empty")
        }
    }

    fun saveOrderedItems(orderedItems: List<FoodModel>) {
        val json = gson.toJson(orderedItems)
        sharedPreferences.edit().putString("ordered_items", json).apply()
    }

    fun loadOrderedItems(): List<FoodModel> {
        val json = sharedPreferences.getString("ordered_items", null) ?: "[]"
        return safelyParseJson(json)
    }

    fun addOrderedItems(newItems: List<FoodModel>) {
        val existingItems = loadOrderedItems()
        val updatedItems = existingItems.toMutableList().apply {
            addAll(newItems)
        }
        saveOrderedItems(updatedItems)
    }

    private fun safelyParseJson(json: String): List<FoodModel> {
        return try {
            val jsonReader = JsonReader(StringReader(json))
            jsonReader.isLenient = true
            gson.fromJson(jsonReader, object : TypeToken<List<FoodModel>>() {}.type)
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}
