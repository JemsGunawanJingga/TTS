package edu.uksw.fti.pam.acitivityintent.ui.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import edu.uksw.fti.pam.acitivityintent.R
import edu.uksw.fti.pam.acitivityintent.models.TodosViewModel
import edu.uksw.fti.pam.acitivityintent.ui.BottomNavItems

var Firstname:String = ""
var Lastname:String = ""

@Composable
fun NavigationGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItems.Home.screen_route
    ) {
        composable(BottomNavItems.Home.screen_route) {
            HomeScreen()
        }
        composable(BottomNavItems.View.screen_route) {
            ViewScreen()
        }
        composable(BottomNavItems.Profile.screen_route) {
            ProfileScreen(Firstname, Lastname)
        }
    }
}



@Composable
fun BottomNavigation(
    navController: NavController,firstname:String,lastname:String
){
    Firstname = firstname
    Lastname = lastname
    val items = listOf(
        BottomNavItems.Home,
        BottomNavItems.View,
        BottomNavItems.Profile
    )
    androidx.compose.material.BottomNavigation(
        backgroundColor = Color(0XFF7F67BE),
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(
                    tint = Color.White,
                    painter = painterResource(item.icon),
                    contentDescription = "${item.title} icon")
                },
                label = {
                    Text(text = item.title,
                    fontSize = 9.sp)
                },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.Black.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {
                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}


@Composable
fun TopBar(
    onSearchIconClicked: () -> Unit
){
    var showMenu by remember { mutableStateOf(false) }
    val context = LocalContext.current

    TopAppBar(
        title = { Text("Data Pemilu") },
        modifier = Modifier
            .background(Color(0XFF7F67BE)),
        actions = {

            IconButton(onClick = onSearchIconClicked ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search_24),
                    contentDescription = "Search Icon",
                    modifier = Modifier.size(25.dp),
                    tint = Color.White
                )
            }

            IconButton(onClick = { showMenu = !showMenu }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_morevert),
                    contentDescription = "Search Icon",
                    modifier = Modifier.size(25.dp),
                    tint = Color.White
                )
            }

            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false }
            ) {

                DropdownMenuItem(onClick = { Toast.makeText(context, "Settings", Toast.LENGTH_SHORT).show() }) {
                    Text(text = "Settings")
                }

                DropdownMenuItem(onClick = { Toast.makeText(context, "Logout", Toast.LENGTH_SHORT).show() }) {
                    Text(text = "Logout")
                }

            }


        }
    )
}

@Composable
fun SearchBar(
    onCloseIconClicked: () -> Unit
){
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = "",
        onValueChange ={},
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search ,
                contentDescription = "Search Icon",
                tint = Color.Black
            )
        },
        trailingIcon = {
            IconButton(onClick =  onCloseIconClicked) {
                Icon(
                    imageVector = Icons.Filled.Close ,
                    contentDescription = "Close Icon",
                    tint = Color.Black
                )
            }
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.Black,
            focusedBorderColor = Color.White
        ),
        placeholder = {
            Text(
                text = "Search....",
                color = Color.White
            )
        }
    )

}

@Composable
fun search(
    ViewModel:DataViewModel
) {

    val state = ViewModel.state

    Column {
        if (state.isSearchBarVisible){
            SearchBar (
                onCloseIconClicked = {
                    ViewModel.onAction(UserAction.CloseIconClicked)
                }
            )
        }else {
            TopBar (
                onSearchIconClicked = {
                    ViewModel.onAction(UserAction.SearchIconClicked)
                }
            )
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BottomNavigationMainScreenView(username: ArrayList<String>){

    val navController = rememberNavController()
    var lastname:String = username[1]
    var firstname:String = username[0]

    Scaffold(
        topBar = { search(ViewModel = DataViewModel())},
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = { FloatingActionButton(onClick = {}){
            Icon(
                painter = painterResource(id = R.drawable.ic_drive_file),
                contentDescription = "Pen Icon",
                modifier = Modifier.size(25.dp)
            )
        } },
        bottomBar = {
            BottomNavigation(
                navController = navController,firstname,lastname
            )
        }
    ) {
        NavigationGraph(navController = navController)
    }
}