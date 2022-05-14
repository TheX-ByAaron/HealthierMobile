package com.tech.phantoms.healthier.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tech.phantoms.healthier.R
import com.tech.phantoms.healthier.ui.composables.BottomNavBar
import com.tech.phantoms.healthier.ui.composables.NavRoute
import com.tech.phantoms.healthier.ui.composables.TopBar
import com.tech.phantoms.healthier.ui.screens.*
import com.tech.phantoms.healthier.ui.theme.HBlack
import com.tech.phantoms.healthier.ui.theme.HealthierTheme

class HomeUserActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Healthier)

        setContent {
            HomeUserScreenContent {
                val routes = arrayListOf(
                    NavRoute("HomeUser", R.drawable.ic_home, R.drawable.ic_home_fill),
                    NavRoute("Challenges", R.drawable.ic_challenges, R.drawable.ic_challenges_fill),
                    NavRoute("LeaderBoard", R.drawable.ic_leaderboard, R.drawable.ic_leaderboard_fill),
                    NavRoute("Coaches", R.drawable.ic_coaches, R.drawable.ic_coaches_fill)
                )
                val navController = rememberNavController()

                Scaffold(
                    backgroundColor = MaterialTheme.colors.HBlack,

                    topBar = { TopBar() },

                    content = {
                      NavHost(navController = navController, startDestination = "HomeUser"){
                          composable("HomeUser"){ HomeUserScreen(navController = navController) }
                          composable("Challenges"){ ChallengesScreen() }
                          composable("LeaderBoard"){ LeaderBoardScreen() }
                          composable("Coaches"){ UserCoachesScreen() }
                          composable("ChallengePerformance"){ ChallengePerformanceScreen() }
                          composable("ChallengeDetails"){ ChallengeDetailsScreen() }
                      }
                    },

                    bottomBar = {
                        BottomNavBar(navRoutes = routes, navController = navController, homeRoute = "HomeUser")
                    }
                )
            }
        }
    }
}

@Composable
fun HomeUserScreenContent(content: @Composable () -> Unit){
    HealthierTheme {
        Surface(color = MaterialTheme.colors.HBlack) {
            content()
        }
    }
}