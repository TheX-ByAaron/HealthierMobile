package com.tech.phantoms.healthier.ui.screens

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.tech.phantoms.healthier.activities.HomeUserActivity
import com.tech.phantoms.healthier.ui.composables.Hbutton
import com.tech.phantoms.healthier.ui.composables.HealthChip
import com.tech.phantoms.healthier.ui.theme.HealthierTheme
import com.tech.phantoms.healthier.ui.theme.appFontFamily

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategoryChoice(navController: NavController){

    val activity = LocalContext.current as? Activity
    Box(modifier = Modifier.fillMaxSize()
        , contentAlignment = Alignment.Center){

        var healthcategoryList = arrayListOf("Sleep", "Fitness", "Diet"
            , "Stop smoking", "Reduce body fat")


        val healthCategorySelectionList = ArrayList<String>()

        Column(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()) {

            Text(text = "Choose healthy habits that you want to get or improve"
                , color = Color.White
                , fontFamily = appFontFamily
                , fontSize = 16.sp
                , fontWeight = FontWeight.Medium
                , textAlign = TextAlign.Center
                , modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 32.dp))

            LazyVerticalGrid(cells = GridCells.Fixed(2)){

                items(healthcategoryList.toList()){ name ->
                    HealthChip(name = name
                        , modifier = Modifier.padding(4.dp)
                        , isSelected = healthCategorySelectionList.contains(name)
                        , setIsSelected = {
                           if(healthCategorySelectionList.contains(name)){
                               healthCategorySelectionList.remove(name)
                           }else{
                               healthCategorySelectionList.add(name)
                           }
                        })
                }
            }

            Hbutton(text = "Confirm"
                , modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 32.dp, bottom = 8.dp)
                    .fillMaxWidth()
                , onClick = {
                    val intent = Intent(activity, HomeUserActivity::class.java)
                    activity?.startActivity(intent)
                    activity?.finish()
                })
        }
    }
}

@Preview
@Composable
fun CategoryChoicePreview(){
    HealthierTheme {
        CategoryChoice(rememberNavController())
    }
}