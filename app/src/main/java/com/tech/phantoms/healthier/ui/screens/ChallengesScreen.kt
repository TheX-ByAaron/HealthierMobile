package com.tech.phantoms.healthier.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import com.tech.phantoms.healthier.models.ChallengeRecommendation
import com.tech.phantoms.healthier.models.Coach
import com.tech.phantoms.healthier.ui.composables.HTextButton
import com.tech.phantoms.healthier.ui.theme.*

@Composable
fun ChallengesScreen(){

    LazyColumn(modifier = Modifier.fillMaxSize()) {

        val coach = Coach("steven.morphy@mail.com", "steven morphy", "", "")
        val challenge = ChallengeRecommendation("10 days walk", "20-05-2022", "30-05-2022", coach)

        item {
            Text(
                text = "Most popular challenges",
                fontFamily = appFontFamily,
                color = MaterialTheme.colors.Hyellow,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth())
        }

        item {
            LazyRow(modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth()
                .wrapContentWidth()){
                items(4){
                    RecommendationCard(recommendation = challenge)
                }
            }
        }

        item {
            Text(
                text = "Recommended challenges",
                fontFamily = appFontFamily,
                color = MaterialTheme.colors.Hyellow,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth())
        }

        item {
            LazyRow(modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth()
                .wrapContentWidth()){
                items(4){
                    RecommendationCard(recommendation = challenge)
                }
            }
        }

        item {
            Spacer(modifier = Modifier
                .height(80.dp)
                .fillMaxWidth())
        }
    }
}

@Composable
fun RecommendationCard(recommendation: ChallengeRecommendation){

    Column(modifier = Modifier
        .padding(8.dp)
        .wrapContentWidth()
        .heightIn(min = 180.dp)
        .background(
            color = MaterialTheme.colors.RoyalBlack,
            shape = MaterialTheme.shapes.MediumRound
        )
        .padding(16.dp),
        horizontalAlignment = Alignment.Start) {

        Text(text = recommendation.title
            , color = Color.White
            , fontFamily = appFontFamily
            , fontWeight = FontWeight.Bold
            , fontSize = 16.sp
            , modifier = Modifier.padding(start = 8.dp,end= 4.dp,top = 4.dp, bottom = 2.dp))

        Row(verticalAlignment = Alignment.CenterVertically
            , modifier = Modifier.padding(start = 4.dp, end = 4.dp, bottom = 8.dp)) {

            Icon(painter = painterResource(id = R.drawable.ic_clock)
                , contentDescription = "icon"
                , tint = MaterialTheme.colors.Hpink
                , modifier = Modifier.padding(4.dp))

            Text(text = recommendation.startDate
                , color = Color.White
                , fontFamily = appFontFamily
                , fontWeight = FontWeight.Medium
                , fontSize = 14.sp
                , modifier = Modifier.padding(start = 4.dp))
        }

        Row(verticalAlignment = Alignment.CenterVertically
            , modifier = Modifier.padding(start = 4.dp, end = 4.dp, bottom = 8.dp)) {
            Icon(painter = painterResource(id = R.drawable.ic_clock)
                , contentDescription = "icon"
                , tint = MaterialTheme.colors.Hpink
                , modifier = Modifier.padding(4.dp))

            Text(text = recommendation.endDate
                , color = Color.White
                , fontFamily = appFontFamily
                , fontWeight = FontWeight.Medium
                , fontSize = 14.sp
                , modifier = Modifier.padding(start = 4.dp))
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(R.drawable.user)
                    .crossfade(true)
                    .build()
                , contentDescription = "customer"
                , contentScale = ContentScale.Crop
                , alignment = Alignment.Center
                , modifier = Modifier
                    .padding(4.dp)
                    .size(30.dp)
                    .clip(CircleShape))

            Text(text = recommendation.coach.name
                , color = Color.White
                , fontFamily = appFontFamily
                , fontWeight = FontWeight.Medium
                , fontSize = 14.sp)
        }

        HTextButton(text = "More details"
            , modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp)
                .fillMaxWidth()
            , onClick = {}
            , tint = Color.White)
    }

}