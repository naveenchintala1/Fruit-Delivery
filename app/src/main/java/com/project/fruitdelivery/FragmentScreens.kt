package com.project.fruitdelivery

sealed class FragmentScreens (val screens: String){
    data object Home: FragmentScreens ("Home")
    data object Bookings: FragmentScreens ("Bookings")
    data object Contact: FragmentScreens ("Contact Us")
}