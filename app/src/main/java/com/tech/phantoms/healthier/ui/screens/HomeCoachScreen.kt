package com.tech.phantoms.healthier.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.tech.phantoms.healthier.R
import com.tech.phantoms.healthier.models.ChallengeAnalytic
import com.tech.phantoms.healthier.models.Coach
import com.tech.phantoms.healthier.ui.composables.BoxButton
import com.tech.phantoms.healthier.ui.composables.Hbutton
import com.tech.phantoms.healthier.ui.theme.*
import kotlin.math.min

@Composable
fun HomeCoachScreen(navController: NavController){

    val coach = Coach("steven.morphy@mail.com", "steven morphy", "", "")
    val challengeAnalytic = ChallengeAnalytic("Walk", coach, "10 days", 100)

    Column(modifier = Modifier.fillMaxSize()) {

        CoachHeader()

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(40.dp))

        Text(text = "Challenges you added"
            , fontFamily = appFontFamily
            , color = MaterialTheme.colors.Hyellow
            , fontWeight = FontWeight.Bold
            , fontSize = 20.sp
            , modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth())

        LazyRow(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()){
            items(20){
                CoachChallengeCard(challenge = challengeAnalytic)
            }
        }


        BoxButton(text = "Add a challenge"
            , modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp)
                .wrapContentWidth()
            , onClick = {

            })
    }
}

@Composable
fun CoachHeader(){
    Row(modifier = Modifier
        .padding(start = 16.dp, end = 16.dp, top = 16.dp)
        .fillMaxWidth()
        .wrapContentHeight()
        , verticalAlignment = Alignment.CenterVertically){

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(R.drawable.user)
                .crossfade(true)
                .build()
            , contentDescription = "coach"
            , contentScale = ContentScale.Crop
            , alignment = Alignment.Center
            , modifier = Modifier
                .padding(16.dp)
                .size(65.dp)
                .clip(CircleShape))

        Column(modifier = Modifier.padding(start = 8.dp, end = 16.dp, top = 16.dp, bottom = 16.dp)) {
            Text(text = "Welcome back"
                , color = Color.White
                , fontFamily = appFontFamily
                , fontWeight = FontWeight.Bold
                , fontSize = 16.sp
                , modifier = Modifier.padding(bottom = 2.dp))

            Text(text = "Eithen"
                , color = Color.White
                , fontFamily = appFontFamily
                , fontWeight = FontWeight.Medium
                , fontSize = 14.sp)
        }
    }
}


@Composable
fun CoachChallengeCard(challenge: ChallengeAnalytic){
    Column(modifier = Modifier
        .padding(8.dp)
        .wrapContentWidth()
        .heightIn(min = 150.dp)
        .background(
            color = MaterialTheme.colors.RoyalBlack,
            shape = MaterialTheme.shapes.MediumRound
        )
        .padding(16.dp),
        horizontalAlignment = Alignment.Start) {

        Text(text = challenge.title
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

            Text(text = challenge.duration
                , color = Color.White
                , fontFamily = appFontFamily
                , fontWeight = FontWeight.Medium
                , fontSize = 14.sp
                , modifier = Modifier.padding(start = 4.dp))
        }

        Row(verticalAlignment = Alignment.CenterVertically
            , modifier = Modifier.padding(start = 4.dp, end = 4.dp, bottom = 8.dp)) {
            Icon(painter = painterResource(id = R.drawable.ic_coaches)
                , contentDescription = "icon"
                , tint = MaterialTheme.colors.Hpink
                , modifier = Modifier.padding(4.dp))

            Text(text = "${challenge.participantNumber} users"
                , color = Color.White
                , fontFamily = appFontFamily
                , fontWeight = FontWeight.Medium
                , fontSize = 14.sp
                , modifier = Modifier.padding(start = 4.dp))
        }
    }
}