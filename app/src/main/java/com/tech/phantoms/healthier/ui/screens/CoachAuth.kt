package com.tech.phantoms.healthier.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tech.phantoms.healthier.ui.theme.HealthierTheme

@Composable
fun CoachAuth(navController: NavController){

}

@Preview
@Composable
fun CoachAuthPreview(){
    HealthierTheme {
        CoachAuth(rememberNavController())
    }
}