package com.tech.phantoms.healthier.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.tech.phantoms.healthier.R
import com.tech.phantoms.healthier.ui.theme.Hyellow
import com.tech.phantoms.healthier.ui.theme.MediumRound
import com.tech.phantoms.healthier.ui.theme.RoyalBlack
import com.tech.phantoms.healthier.ui.theme.appFontFamily




@Composable
fun UserCoachesScreen(){

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .clip(MaterialTheme.shapes.MediumRound)){

        item{
            Text(text = "Your coaches"
                , fontFamily = appFontFamily
                , color = MaterialTheme.colors.Hyellow
                , fontWeight = FontWeight.Bold
                , fontSize = 20.sp
                , modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth())
        }

        items(15){
            CoachCard()
        }

        item{
            Spacer(modifier = Modifier
                .height(80.dp)
                .fillMaxWidth())
        }
    }
}

@Composable
fun CoachCard(){

    Row(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .wrapContentHeight()
        .background(
            color = MaterialTheme.colors.RoyalBlack,
            shape = MaterialTheme.shapes.MediumRound
        )
        , verticalAlignment = Alignment.Top){

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(R.drawable.user)
                .crossfade(true)
                .build()
            , contentDescription = "customer"
            , contentScale = ContentScale.Crop
            , alignment = Alignment.Center
            , modifier = Modifier
                .padding(16.dp)
                .size(50.dp)
                .clip(CircleShape))

        Column(modifier = Modifier.padding(start = 8.dp, end = 16.dp, top = 16.dp, bottom = 16.dp)) {
            Text(text = "Eithen fall"
                , color = Color.White
                , fontFamily = appFontFamily
                , fontWeight = FontWeight.Bold
                , fontSize = 16.sp
                , modifier = Modifier.padding(bottom = 2.dp))

            Text(text = "Category"
                , color = Color.White
                , fontFamily = appFontFamily
                , fontWeight = FontWeight.Medium
                , fontSize = 14.sp)
        }
    }
}