package com.tech.phantoms.healthier.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tech.phantoms.healthier.R
import com.tech.phantoms.healthier.ui.composables.HTextButton
import com.tech.phantoms.healthier.ui.composables.Hbutton
import com.tech.phantoms.healthier.ui.composables.PasswordInput
import com.tech.phantoms.healthier.ui.composables.TextInput
import com.tech.phantoms.healthier.ui.theme.*

@Composable
fun CoachRegister(navController: NavController){

    Column(modifier = Modifier.fillMaxSize()
        , horizontalAlignment = Alignment.CenterHorizontally) {

        var emailStr by remember { mutableStateOf("") }
        var passwordStr by remember { mutableStateOf("") }
        var confirmPasswordStr by remember { mutableStateOf("") }
        val inputModifier = Modifier
            .padding(top = 10.dp, start = 16.dp, end = 16.dp, bottom = 10.dp)
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colors.RoyalBlack,
                shape = MaterialTheme.shapes.FullRounded
            )

        Text(text = "Sign up"
            , color = Color.White
            , fontFamily = appFontFamily
            , fontWeight = FontWeight.Bold
            , fontSize = 32.sp
            , modifier = Modifier.padding(24.dp))
        
        TextInput(input = emailStr
            , onInputChange = {emailStr = it}
            , hint = "Email"
            , modifier = inputModifier)

        PasswordInput(input = passwordStr
            , onInputChange = {passwordStr = it}
            , hint = "Password"
            , modifier = inputModifier)

        PasswordInput(input = confirmPasswordStr
            , onInputChange = {confirmPasswordStr = it}
            , hint = "Confirm password"
            , modifier = inputModifier)
        
        Text(text = "We need a recognized certificate in order to prove your expertise"
            , color = Color.White
            , fontFamily = appFontFamily
            , fontSize = 16.sp
            , fontWeight = FontWeight.Medium
            , textAlign = TextAlign.Center
            , modifier = Modifier.padding(all = 16.dp))

        Row(verticalAlignment = Alignment.CenterVertically
            , modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .height(50.dp)
                .background(
                    color = MaterialTheme.colors.RoyalBlack,
                    shape = MaterialTheme.shapes.FullRounded
                )
                .clip(MaterialTheme.shapes.FullRounded)
                .clickable {

                }
            , horizontalArrangement = Arrangement.SpaceBetween
            , ){

            Text(text = "Upload certificate"
                , color = Color.White
                , fontFamily = appFontFamily
                , fontSize = 16.sp
                , fontWeight = FontWeight.Medium
                , textAlign = TextAlign.Center
                , modifier = Modifier.padding(start = 16.dp, end = 16.dp) )

            Icon(painter = painterResource(id = R.drawable.ic_eye)
                , contentDescription = "upload certificate"
                , tint = MaterialTheme.colors.Hyellow
                , modifier = Modifier.padding(end = 16.dp))

        }

        Hbutton(text = "Sign up"
            , modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp)
                .fillMaxWidth()
            , onClick = {
                //TODO: Do the sign up action
            })

        Surface(modifier = Modifier
            .padding(start = 32.dp, end = 32.dp, top = 16.dp, bottom = 24.dp)
            .fillMaxWidth()
            .height(2.dp)
            , color = MaterialTheme.colors.Hyellow
            , shape = MaterialTheme.shapes.FullRounded) {}

        Text(text = "You already have an account?"
            , color = Color.White
            , fontFamily = appFontFamily
            , fontWeight = FontWeight.Medium
            , fontSize = 16.sp
            , textAlign = TextAlign.Center
            , modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth())

        HTextButton(text = "Log into your account now!"
            , tint = MaterialTheme.colors.Hyellow
            , onClick = {
                navController.navigate("CoachLogin"){
                    launchSingleTop = true
                }
            })
        
    }
}

@Preview
@Composable
fun CoachAuthPreview(){
    HealthierTheme {
        CoachRegister(rememberNavController())
    }
}