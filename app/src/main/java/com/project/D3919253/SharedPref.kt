package com.project.D3919253

import android.content.Context
import android.content.SharedPreferences

object SharedPref {

    private const val PREFS_NAME = "user_prefs"
    private const val KEY_NAME = "name"
    private const val KEY_EMAIL = "email"
    private const val KEY_MOBILE_NUMBER = "mobile_number"
    private const val KEY_AGE = "age"

    private fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun saveUserProfile(context: Context, userProfile: UserProfileModel) {
        val editor = getPreferences(context).edit()
        editor.putString(KEY_NAME, userProfile.name)
        editor.putString(KEY_EMAIL, userProfile.email)
        editor.putString(KEY_MOBILE_NUMBER, userProfile.mobileNumber)
        editor.putInt(KEY_AGE, userProfile.age)
        editor.apply()
    }

    fun getUserProfile(context: Context): UserProfileModel {
        val prefs = getPreferences(context)
        return UserProfileModel(
            name = prefs.getString(KEY_NAME, "") ?: "",
            email = prefs.getString(KEY_EMAIL, "") ?: "",
            mobileNumber = prefs.getString(KEY_MOBILE_NUMBER, "") ?: "",
            age = prefs.getInt(KEY_AGE, 0)
        )
    }

    fun clearUserProfile(context: Context) {
        getPreferences(context).edit().clear().apply()
    }

}