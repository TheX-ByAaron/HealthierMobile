package com.tech.phantoms.healthier.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tech.phantoms.healthier.R
import com.tech.phantoms.healthier.ui.composables.BottomNavBar
import com.tech.phantoms.healthier.ui.composables.NavRoute
import com.tech.phantoms.healthier.ui.composables.TopBar
import com.tech.phantoms.healthier.ui.screens.CoachCustomersScreen
import com.tech.phantoms.healthier.ui.theme.HBlack
import com.tech.phantoms.healthier.ui.theme.HealthierTheme

class HomeCoachActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTheme(R.style.Theme_Healthier)
        setContent {
            HomeCoachScreenContent {
                val routes = arrayListOf(
                    NavRoute("HomeCoach", R.drawable.ic_home, R.drawable.ic_home_fill),
                    NavRoute("Customers", R.drawable.ic_coaches, R.drawable.ic_coaches_fill)
                )
                val navController = rememberNavController()

                Scaffold(
                    backgroundColor = MaterialTheme.colors.HBlack,
                    topBar = { TopBar() },
                    content = {
                        NavHost(navController = navController, startDestination = "HomeCoach"){
                            composable("HomeCoach"){}
                            composable("Customers"){ CoachCustomersScreen() }
                        }
                    },
                    bottomBar = {
                        BottomNavBar(navRoutes = routes, navController = navController, homeRoute = "HomeCoach")
                    }
                )
            }
        }
    }
}


@Composable
fun HomeCoachScreenContent(content: @Composable () -> Unit){
    HealthierTheme {
        Surface(color = MaterialTheme.colors.HBlack) {
            content()
        }
    }
}