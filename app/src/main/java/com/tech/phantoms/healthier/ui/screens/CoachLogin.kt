package com.tech.phantoms.healthier.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tech.phantoms.healthier.ui.composables.HTextButton
import com.tech.phantoms.healthier.ui.composables.Hbutton
import com.tech.phantoms.healthier.ui.composables.PasswordInput
import com.tech.phantoms.healthier.ui.composables.TextInput
import com.tech.phantoms.healthier.ui.theme.*


@Composable
fun CoachLogin(navController: NavController){
    Box(modifier = Modifier.fillMaxSize()
        , contentAlignment = Alignment.Center){
        Column(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally) {

            var emailStr by remember { mutableStateOf("") }
            var passwordStr by remember { mutableStateOf("") }
            val inputModifier = Modifier
                .padding(top = 10.dp, start = 16.dp, end = 16.dp, bottom = 10.dp)
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colors.RoyalBlack,
                    shape = MaterialTheme.shapes.FullRounded
                )

            Text(text = "Sign in"
                , color = Color.White
                , fontFamily = appFontFamily
                , fontWeight = FontWeight.Bold
                , fontSize = 32.sp
                , modifier = Modifier.padding(start = 24.dp, end = 24.dp, bottom = 24.dp, top = 32.dp))

            TextInput(input = emailStr
                , onInputChange = {emailStr = it}
                , hint = "Email"
                , modifier = inputModifier)

            PasswordInput(input = passwordStr
                , onInputChange = {passwordStr = it}
                , hint = "Password"
                , modifier = inputModifier)

            Hbutton(text = "Sign in"
                , modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp)
                    .fillMaxWidth()
                , onClick = {
                    //TODO: Do the sign in action
                })

            Surface(modifier = Modifier
                .padding(start = 32.dp, end = 32.dp, top = 16.dp, bottom = 24.dp)
                .fillMaxWidth()
                .height(2.dp)
                , color = MaterialTheme.colors.Hyellow
                , shape = MaterialTheme.shapes.FullRounded) {}

            Text(text = "You don't have an account?"
                , color = Color.White
                , fontFamily = appFontFamily
                , fontWeight = FontWeight.Medium
                , fontSize = 16.sp
                , textAlign = TextAlign.Center
                , modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .fillMaxWidth())

            HTextButton(text = "Create a new one now!"
                , tint = MaterialTheme.colors.Hyellow
                , onClick = {
                    navController.popBackStack()
                })
        }
    }

}

@Preview
@Composable
fun CoachLoginPreview(){
    HealthierTheme {
        CoachLogin(rememberNavController())
    }
}