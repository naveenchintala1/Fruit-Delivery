package com.project.fruitdelivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults.textFieldColors
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.project.fruitdelivery.ui.theme.FoodDeliveryTheme


class Home : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodDeliveryTheme {
                HomeController()
            }
        }
    }
}

@Composable
fun HomeController(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home"){
            HomeScreen(navController)
        }
        composable("cart"){
            CartScreen()
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){
    val selectedTabIndex = remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
                title = { Text(text = "Venkata Ramana Fruit Delivery")
                },
                actions = {
                    IconButton(onClick = {
                        navController.navigate("cart")
                    }) {
                        Icon(Icons.Default.ShoppingCart, contentDescription = "Cart")
                    }
                }

            )
        },

        containerColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            TabRow(
                selectedTabIndex = selectedTabIndex.value,
                contentColor = Color.DarkGray,
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex.value]),
                        color = Color(0xFF009688)
                    )
                }
            ) {
                Tab(
                    selected = selectedTabIndex.value == 0,
                    onClick = { selectedTabIndex.value = 0 },
                    text = { Text(
                        text = "Fruits",
                        color = if (selectedTabIndex.value == 0) Color.DarkGray else Color.LightGray
                    ) }
                )
                Tab(
                    selected = selectedTabIndex.value == 1,
                    onClick = { selectedTabIndex.value = 1 },
                    text = {
                        Text(
                        text = "Veggies",
                        color = if (selectedTabIndex.value == 1) Color.DarkGray else Color.LightGray
                         )
                    }
                )
            }

            when (selectedTabIndex.value) {
                0 -> FruitsTabContent()
                1 -> VegetablesTabContent()
            }

        }
    }
}


@Preview
@Composable
fun PreviewHome() {
    //Home()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FruitsTabContent() {


    Box(modifier = Modifier.run { fillMaxSize().background(Color(0xFFECECEC)) }
    ){
        val fruits = remember {
            listOf(
                FoodModel(
                    id = "1",
                    name = "Apple",
                    weight = "150",
                    unit = "g",
                    price = "1.00",
                    imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSDS4r-NVHYDDEHE0GlD0LuijNMhFLM-cV3nQ&s"
                ),
                FoodModel(
                    id = "2",
                    name = "Banana",
                    weight = "120",
                    unit = "g",
                    price = "0.99",
                    imageUrl = "https://media.istockphoto.com/id/1494763483/photo/banana-concept.webp?b=1&s=170667a&w=0&k=20&c=YZVpR1AFJkXVxOrkRshzU1vvDVAlTDW2TNv5IOvZxSM="
                ),
                FoodModel(
                    id = "3",
                    name = "Orange",
                    weight = "200",
                    unit = "g",
                    price = "2.49",
                    imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTOYZS1lDimqPEqVX7KORZ7AkNiCDZk96gxlw&s"
                ),
                FoodModel(
                    id = "4",
                    name = "Strawberry",
                    weight = "50",
                    unit = "g",
                    price = "3.99",
                    imageUrl = "https://media.istockphoto.com/id/477834644/photo/fresh-strawberries-background.webp?b=1&s=170667a&w=0&k=20&c=gccioa8WogvUMEuYSz-DhGMmF1zdqmlSk-LvFGbssN0="
                ),
                FoodModel(
                    id = "5",
                    name = "Papaya",
                    weight = "50",
                    unit = "g",
                    price = "3.99",
                    imageUrl = "https://media.istockphoto.com/id/864053288/photo/whole-and-half-of-ripe-papaya-fruit-with-seeds-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=hJ5DpNTt0oKjZMIHYV6gUHTntB2zIs_78dPKiuDUXgE="
                ),
                FoodModel(
                    id = "6",
                    name = "Mango",
                    weight = "50",
                    unit = "g",
                    price = "3.99",
                    imageUrl = "https://plantparadise.in/cdn/shop/products/Background-hd-Mango-Wallpaper-Download_90144dd9-3d28-4186-a105-85ad7846a7f2.jpg?v=1691200169"
                )
            )
        }

        val (query, setQuery) = remember { mutableStateOf("") }

        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFECECEC))) {
            Column(modifier = Modifier.fillMaxSize()) {
                SearchView(query = query, onQueryChange = setQuery)
                val filteredFruits = fruits.filter {
                    it.name.contains(query, ignoreCase = true)
                }
                FruitList(fruits = filteredFruits)
            }
        }

        //FruitList(fruits = fruits)
    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchView(query: String, onQueryChange: (String) -> Unit) {
    TextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        label = { Text(text = "Search") },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon") },
        colors = textFieldColors(containerColor = Color.White)
    )
}

@Composable
fun FruitList(fruits: List<FoodModel>) {
    LazyColumn {
        items(fruits) { fruit ->
            FoodItem(
                food = fruit
            )
        }
    }
}

@Composable
fun VegetablesTabContent() {
    Box(modifier = Modifier.run { fillMaxSize().background(Color(0xFFECECEC)) }){
        val fruits = remember {
            listOf(
                FoodModel(
                    id = "1",
                    name = "Potato",
                    weight = "150",
                    unit = "g",
                    price = "1.99",
                    imageUrl = "https://m.media-amazon.com/images/I/313dtY-LOEL._AC_UF1000,1000_QL80_.jpg"
                ),
                FoodModel(
                    id = "2",
                    name = "Brinjal",
                    weight = "120",
                    unit = "g",
                    price = "0.99",
                    imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQqRUaEHqy_cX-JYmpTAOUdizBYOOJcSoC1Tg&s"
                ),
                FoodModel(
                    id = "3",
                    name = "Tomato",
                    weight = "200",
                    unit = "g",
                    price = "2.49",
                    imageUrl = "https://economictimes.indiatimes.com/thumb/msid-95423731,width-1200,height-900,resizemode-4,imgsize-56196/tomatoes-canva.jpg?from=mdr"
                ),
                FoodModel(
                    id = "4",
                    name = "Peas",
                    weight = "50",
                    unit = "g",
                    price = "3.99",
                    imageUrl = "https://images.healthshots.com/healthshots/en/uploads/2021/08/23133154/Peas-1600x900.jpg"
                ),
                FoodModel(
                    id = "5",
                    name = "Cauliflower",
                    weight = "50",
                    unit = "g",
                    price = "3.99",
                    imageUrl = "https://cdn.mos.cms.futurecdn.net/ApkWfRWrKKyHAx3oi3DrQR-1200-80.jpg"
                ),
                FoodModel(
                    id = "6",
                    name = "Capsicum",
                    weight = "50",
                    unit = "g",
                    price = "3.99",
                    imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5JHUyvTvqdcTaCY-uxtNhe-Q5iKWuSHuqRw&s"
                )
            )
        }

        val (query, setQuery) = remember { mutableStateOf("") }

        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFECECEC))) {
            Column(modifier = Modifier.fillMaxSize()) {
                SearchView(query = query, onQueryChange = setQuery)
                val filteredFruits = fruits.filter {
                    it.name.contains(query, ignoreCase = true)
                }
                FruitList(fruits = filteredFruits)
            }
        }

        //FruitList(fruits = fruits)
    }
}

@Composable
fun CartScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Cart Screen")
        
    }
}