package edu.uksw.fti.pam.acitivityintent.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import edu.uksw.fti.pam.acitivityintent.R

sealed class BottomNavItems(
    val title: String,
    val icon: Int, //diganti integer
    val screen_route: String
) {
    object Home: BottomNavItems("Home", R.drawable.ic_home, "home")
    object View: BottomNavItems("View", R.drawable.baseline_view_list_24, "articlee")
    object Profile: BottomNavItems("Profile", R.drawable.ic_person_24, "profile")
}