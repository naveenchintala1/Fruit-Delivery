package com.project.fruitdelivery

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.project.fruitdelivery.ui.theme.FoodDeliveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodDeliveryTheme {
                MainScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FoodDeliveryTheme {
        MainScreen()

    }
}

@Preview
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }

    Scaffold(
        bottomBar = {

            BottomAppBar(containerColor = Color(0xFFFFFFFF), modifier = Modifier.height(55.dp)) {
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Home
                        navController.navigate(FragmentScreens.Home.screens) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    },
                    modifier = Modifier.weight(1f),
                ) {
                    Icon(
                        Icons.Default.Home,
                        contentDescription = null,
                        modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Home) Color.Green else Color(
                            0xFFACABAB
                        ),
                    )
                }

                IconButton(
                    onClick = {
                        selected.value = Icons.Default.DateRange
                        navController.navigate(FragmentScreens.Bookings.screens) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    },
                    modifier = Modifier.weight(1f),
                ) {
                    Icon(
                        Icons.Default.DateRange,
                        contentDescription = null,
                        modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.DateRange) Color.Green else Color.LightGray,
                    )
                }

                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Person
                        navController.navigate(FragmentScreens.Contact.screens) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    },
                    modifier = Modifier.weight(1f),
                ) {
                    Icon(
                        Icons.Default.Person,
                        contentDescription = null,
                        modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Person) Color.Green else Color.LightGray,
                    )
                }

            }
        },
    ){paddingValues ->
        NavHost(
            navController = navController,
            startDestination = FragmentScreens.Home.screens,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(FragmentScreens.Home.screens){ HomeController() }
            composable(FragmentScreens.Bookings.screens){ Bookings() }
            composable(FragmentScreens.Contact.screens){ ContactUs() }

        }

    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalPagerApi::class)
@Composable
fun Dashboard() {
    val selectedTabIndex = remember { mutableStateOf(0) }
    val tabTitles = listOf("Fruits", "Veggies")
    val pagerState = rememberPagerState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Venkata Ramana Fruit Delivery" , fontSize = 16.sp) },
            )
        }

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            // TabRow with Pager
            TabRow(
                selectedTabIndex = selectedTabIndex.value,
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex.value])
                    )
                }
            ) {
                tabTitles.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex.value == index,
                        onClick = {
                            selectedTabIndex.value = index
                        },
                        text = { Text(
                            text = title,
                            color = if (selectedTabIndex.value == index) Color.Black else Color.DarkGray,
                            fontSize = 16.sp
                        ) }
                    )
                }
            }

            HorizontalPager(
                state = pagerState,
                count = tabTitles.size,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) { page ->
                when (page) {
//                    0 -> //FruitsTabContent(navController = na)
//                    1 ->// VegetablesTabContent()
                }
            }


        }
    }
}

