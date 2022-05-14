package com.tech.phantoms.healthier.ui.dialogs

import android.content.ContentValues.TAG
import android.content.Context.MODE_PRIVATE
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.core.content.edit
import androidx.navigation.NavController
import co.tryterra.terra.HealthStoreManager
import co.tryterra.terra.ServiceUnavailable
import co.tryterra.terra.Terra
import com.google.android.libraries.healthdata.HealthDataClient
import com.google.android.libraries.healthdata.HealthDataService
import com.tech.phantoms.healthier.ui.composables.Hbutton
import com.tech.phantoms.healthier.ui.theme.MediumRound
import com.tech.phantoms.healthier.ui.theme.RoyalBlack
import com.tech.phantoms.healthier.ui.theme.appFontFamily

@Composable
fun WearableDialog(isOpen: Boolean
                   , setIsOpen : (Boolean) -> Unit
                   , navController: NavController){

    Dialog(onDismissRequest = { setIsOpen(false) },
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)) {

        val context = LocalContext.current
        val pref = context.getSharedPreferences("HEALTHIER_APP", MODE_PRIVATE)

        Column(modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .background(
            color = MaterialTheme.colors.RoyalBlack,
            shape = MaterialTheme.shapes.MediumRound)
            , horizontalAlignment = Alignment.CenterHorizontally){

            Text(text = "For a better experience with our app you need a wearable device"
                , color = Color.White
                , fontFamily = appFontFamily
                , fontSize = 20.sp
                , fontWeight = FontWeight.Bold
                , textAlign = TextAlign.Center
                , modifier = Modifier.padding(all = 16.dp))

            Text(text = "Do you have one ?"
                , color = Color.White
                , fontFamily = appFontFamily
                , fontSize = 20.sp
                , fontWeight = FontWeight.Bold
                , modifier = Modifier.padding(all = 16.dp))

            Row(modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .wrapContentHeight()
                , horizontalArrangement = Arrangement.SpaceEvenly) {

                Hbutton(modifier = Modifier
                    .padding(8.dp)
                    .widthIn(min = 120.dp)
                    , text = "Yes"
                    , onClick = {
                        try{
                            val healthDataStore: HealthDataClient by lazy { HealthDataService.getClient(context)}
                            val store: HealthStoreManager = HealthStoreManager(healthDataStore)
                            val terra: Terra = Terra("tech-phantoms-YI95ylfQzr"
                                , "5fed5e41113c04a59374ab8c91bda07027b9effdf9719bd2cfbeea49f3165ff1"
                                , context, store)
                        }catch (exception: ServiceUnavailable){
                            Log.e(TAG, "${exception.message}")
                            //Try again later (Unexcepted to ever be raised)
                            //This error occurs if there is an error connecting to our servers
                        }
                        catch (exception: IllegalAccessError){
                            //Raised when Health Platform is not available on this device
                            Log.e(TAG, "${exception.message}")
                        }finally {
                            pref.edit {
                                putBoolean("AUTH_USER", true)
                            }
                        }
                        navController.navigate("Categories"){
                            launchSingleTop = true
                        }
                    })

                Hbutton(modifier = Modifier
                    .padding(8.dp)
                    .widthIn(min = 120.dp)
                    , text = "No"
                    , onClick = {
                        setIsOpen(false)
                    })
            }
        }
    }
}