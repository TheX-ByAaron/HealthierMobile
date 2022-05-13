package com.tech.phantoms.healthier.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
import com.tech.phantoms.healthier.ui.dialogs.AppPolicyDialog
import com.tech.phantoms.healthier.ui.dialogs.WearableDialog
import com.tech.phantoms.healthier.ui.theme.HealthierTheme
import com.tech.phantoms.healthier.ui.theme.Hpink
import com.tech.phantoms.healthier.ui.theme.Hyellow
import com.tech.phantoms.healthier.ui.theme.appFontFamily

@Composable
fun HomeAuth(navController: NavController){


    Column(modifier = Modifier.fillMaxSize()
        , horizontalAlignment = Alignment.CenterHorizontally) {

        var isPolicyDialogOpen by remember { mutableStateOf(false) }
        var isWearableConfirmationDialogOpen by remember { mutableStateOf(false)}
        val setPolicyDialog: (Boolean) -> Unit = {
            isPolicyDialogOpen = it
        }
        val setWearableConfirmation: (Boolean) -> Unit = {
            isWearableConfirmationDialogOpen = it
        }

        if(isPolicyDialogOpen){
            AppPolicyDialog(isOpen = isPolicyDialogOpen, setIsOpen = setPolicyDialog)
        }

        if(isWearableConfirmationDialogOpen){
            WearableDialog()
        }

        Image(painter = painterResource(id = R.drawable.ic_logo_stripped)
            , contentDescription = "main logo"
            , modifier = Modifier
                .padding(top = 48.dp, bottom = 16.dp)
                .width(190.dp)
                .height(140.dp))

        Text(text = "Healthier"
            ,color = MaterialTheme.colors.Hpink
            , fontFamily = appFontFamily
            , fontWeight = FontWeight.Bold
            , fontSize = 36.sp
            , textAlign = TextAlign.Center
            , modifier = Modifier
                .padding(bottom = 24.dp)
                .fillMaxWidth())

        Text(text = stringResource(R.string.app_description)
            , color = Color.White
            , fontFamily = appFontFamily
            , fontWeight = FontWeight.Medium
            , fontSize = 16.sp
            , textAlign = TextAlign.Center
            , modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth())

        Hbutton(modifier = Modifier.padding(top = 32.dp, bottom = 8.dp)
            , text = "Connect your account"
            , onClick = {
                //TODO: launch the Terra authentification flow

            })

        HTextButton(modifier = Modifier.padding(bottom = 8.dp)
            , text= "I am a coach"
            , tint = MaterialTheme.colors.Hpink
            , onClick = {
                //TODO: launch the coach page
            })

        Text(text = "By connecting to this app, you are agreeing to the"
            , color = Color.White
            , fontFamily = appFontFamily
            , fontWeight = FontWeight.Medium
            , fontSize = 16.sp
            , textAlign = TextAlign.Center
            , modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth())

        HTextButton(text = "app's policy", tint = MaterialTheme.colors.Hyellow
            , onClick = {
                //TODO: launch the app's policy dialog
                setPolicyDialog(true)

            })
    }
}

@Preview(showBackground = true)
@Composable
fun HomeAuthPreview(){
    HealthierTheme {
        HomeAuth(navController = rememberNavController())
    }
}