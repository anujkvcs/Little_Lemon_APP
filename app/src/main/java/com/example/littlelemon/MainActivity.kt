package com.example.littlelemon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.littlelemon.ui.theme.LittleLemonTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonTheme {
                AppNavigator()
            }
        }
    }
}
@Composable
fun AppNavigator() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Home.route) {
        composable(Home.route) {
            HomeScreen(navController)
        }
        composable(
            route = DishDetails.route + "/{${DishDetails.argDishId}}",
            arguments = listOf(navArgument(DishDetails.argDishId) {
                type = NavType.IntType
                nullable = false
            })
        ) { backStackEntry ->
            val dishId = backStackEntry.arguments?.getInt(DishDetails.argDishId)
            requireNotNull(dishId) { "Dish id is null" }
            DishDetails(dishId)
        }
    }
}