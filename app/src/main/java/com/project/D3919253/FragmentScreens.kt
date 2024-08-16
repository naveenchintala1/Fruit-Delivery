package com.project.D3919253

sealed class FragmentScreens (val screens: String){
    data object Home: FragmentScreens ("Home")
    data object Bookings: FragmentScreens ("Bookings")
    data object AboutUs: FragmentScreens ("Contact Us")
    data object MyProfile: FragmentScreens ("Profile")
}