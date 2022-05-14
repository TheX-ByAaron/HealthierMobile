package com.tech.phantoms.healthier.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.tech.phantoms.healthier.R
import com.tech.phantoms.healthier.models.Challenge
import com.tech.phantoms.healthier.models.Coach
import com.tech.phantoms.healthier.ui.theme.Hyellow
import com.tech.phantoms.healthier.ui.theme.MediumRound
import com.tech.phantoms.healthier.ui.theme.RoyalBlack
import com.tech.phantoms.healthier.ui.theme.appFontFamily

@Composable
fun ChallengeDescriptionCoach(navController: NavController){

    LazyColumn(modifier = Modifier.fillMaxSize()){
        val coach = Coach("steven.morphy@mail.com", "steven morphy", "", "")
        val challenge = Challenge("10 days walk"
            , "Training makes wonders, start small, take a walk for 20 minutes each day for 10 days"
            , "This challenge is for people who struggle"
            , "20-05-2022", "30-05-2022"
            , coach, 0.35F, false)


        item {
            DescriptionCard(title = "Description", text = challenge.description)
        }

        item {
            DescriptionCard(title = "Objectives", text = challenge.goal)
        }

        item {
            Text(text = "Asking for feedback"
                , color = MaterialTheme.colors.Hyellow
                , fontFamily = appFontFamily
                , fontWeight = FontWeight.Bold
                , fontSize = 18.sp
                , textAlign = TextAlign.Center
                , modifier = Modifier.padding(16.dp))
        }

        items(15){
            ChallengerLink {
                navController.navigate("participantPerformance")
            }
        }
    }
}


@Composable
fun ChallengerLink(onClick: () -> Unit){

    Row(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .wrapContentHeight()
        .background(
            color = MaterialTheme.colors.RoyalBlack,
            shape = MaterialTheme.shapes.MediumRound
        )
        .clickable {
            onClick()
        }
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
                .size(50.dp)
                .clip(CircleShape))

        Text(text = "Aaron chid"
            , color = Color.White
            , fontFamily = appFontFamily
            , fontWeight = FontWeight.Bold
            , fontSize = 16.sp
            , modifier = Modifier.padding(bottom = 2.dp))

    }
}