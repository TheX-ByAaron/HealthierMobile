package com.tech.phantoms.healthier.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tech.phantoms.healthier.R
import com.tech.phantoms.healthier.ui.screens.CategoryChoice
import com.tech.phantoms.healthier.ui.screens.CoachAuth
import com.tech.phantoms.healthier.ui.screens.HomeAuth
import com.tech.phantoms.healthier.ui.theme.HBlack
import com.tech.phantoms.healthier.ui.theme.HealthierTheme

class AuthActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Healthier)
        setContent {
            val navController = rememberNavController()

            MainActivityScreenContent {
                    NavHost(navController = navController, startDestination = "HomeAuth"){
                        composable("HomeAuth"){ HomeAuth(navController = navController) }
                        composable("CoachAuth"){ CoachAuth(navController = navController) }
                        composable("Categories"){ CategoryChoice(navController = navController) }
                    }
            }
        }
    }
}


@Composable
fun MainActivityScreenContent(content: @Composable () -> Unit){
    HealthierTheme {
        Surface(color = MaterialTheme.colors.HBlack) {
            content()
        }
    }
}