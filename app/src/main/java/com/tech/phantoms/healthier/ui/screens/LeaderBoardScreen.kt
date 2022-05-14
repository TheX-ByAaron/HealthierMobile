package com.tech.phantoms.healthier.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.tech.phantoms.healthier.R
import com.tech.phantoms.healthier.ui.composables.HealthChip
import com.tech.phantoms.healthier.ui.theme.Hyellow
import com.tech.phantoms.healthier.ui.theme.MediumRound
import com.tech.phantoms.healthier.ui.theme.RoyalBlack
import com.tech.phantoms.healthier.ui.theme.appFontFamily

@Composable
fun LeaderBoardScreen(){

    Column(modifier = Modifier.fillMaxSize()) {

        var selectedTag by remember{ mutableStateOf("Overall activity")}

        val tags = arrayListOf("Sleep", "Fitness", "Diet"
            , "Stop smoking", "Reduce body fat")

        Text(text = "Challenge leaderboard"
            , fontFamily = appFontFamily
            , color = MaterialTheme.colors.Hyellow
            , fontWeight = FontWeight.Bold
            , fontSize = 20.sp
            , modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth())
        
        LazyRow(modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
            .wrapContentHeight()){
            
            item { 
                HealthChip(
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                    name = "Overall activity",
                    isSelected = selectedTag == "Overall activity",
                    setIsSelected = {
                        selectedTag = "Overall activity"
                    }
                )
            }

            items(tags.toList()){habit ->
                HealthChip(
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                    name = habit,
                    isSelected = selectedTag == habit,
                    setIsSelected = {
                        selectedTag = habit
                    }
                )
            }
        }

        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .weight(1F)
            , horizontalAlignment = Alignment.CenterHorizontally){

            item {
                UserWinner(modifier = Modifier
                    .padding(start = 24.dp, end = 24.dp, top = 24.dp, bottom = 8.dp)
                    .size(130.dp))
            }

            item {
                Row(modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp)
                    , verticalAlignment = Alignment.CenterVertically
                    , horizontalArrangement = Arrangement.SpaceEvenly){

                    UserWinner(modifier = Modifier
                        .padding(24.dp)
                        .size(90.dp))

                    UserWinner(modifier = Modifier
                        .padding(24.dp)
                        .size(90.dp))
                }
            }

            items(20){
                UserCard()
            }
        }



    }
}


@Composable
fun UserWinner(modifier: Modifier = Modifier){
    Box(modifier = modifier){

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(R.drawable.user)
                .crossfade(true)
                .build()
            , contentDescription = "customer"
            , contentScale = ContentScale.Crop
            , alignment = Alignment.Center
            , modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape))

        Icon(painter = painterResource(id = R.drawable.ic_leaderboard_fill)
            , contentDescription = "crown"
            , tint = MaterialTheme.colors.Hyellow
            , modifier = Modifier
                .align(Alignment.BottomEnd)
                .size(30.dp))
    }
}


@Composable
fun UserCard() {

    Row(modifier = Modifier
        .padding(horizontal = 16.dp, vertical = 8.dp)
        .fillMaxWidth()
        .wrapContentHeight()
        .background(
            color = MaterialTheme.colors.RoyalBlack,
            shape = MaterialTheme.shapes.MediumRound
        )
        , verticalAlignment = Alignment.CenterVertically){

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
                .size(40.dp)
                .clip(CircleShape))


        Text(text = "Eithen fall"
            , color = Color.White
            , fontFamily = appFontFamily
            , fontWeight = FontWeight.Bold
            , fontSize = 16.sp
            , modifier = Modifier.padding(bottom = 2.dp))
    }
}

