package com.tech.phantoms.healthier.ui.screens

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.tech.phantoms.healthier.R
import com.tech.phantoms.healthier.activities.HomeCoachActivity
import com.tech.phantoms.healthier.models.Challenge
import com.tech.phantoms.healthier.models.Coach
import com.tech.phantoms.healthier.ui.composables.Hbutton
import com.tech.phantoms.healthier.ui.theme.*

@Composable
fun HomeUserScreen(navController: NavController){

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .clip(MaterialTheme.shapes.MediumRound)){

        item {
            UserHeader()
        }

        item{
            PersonalInfoCard()
        }

        item{
            PersonalActivity()
        }

        item{
            OngoingChallenges(navController)
        }

        item{
            FinishedChallenges(navController)
        }

        item{
            Spacer(modifier = Modifier
                .height(80.dp)
                .fillMaxWidth())
        }


    }
}


@Composable
fun UserHeader(){
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
            , contentDescription = "customer"
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

            Text(text = "Haroune"
                , color = Color.White
                , fontFamily = appFontFamily
                , fontWeight = FontWeight.Medium
                , fontSize = 14.sp)
        }
    }
}

@Composable
fun PersonalInfoCard(){
    Column(
        modifier = Modifier
            .padding(top = 8.dp, start = 16.dp, bottom = 8.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(text = "Personal info"
            , fontFamily = appFontFamily
            , color = MaterialTheme.colors.Hyellow
            , fontWeight = FontWeight.Bold
            , fontSize = 20.sp
            , modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth())

        LazyRow(modifier = Modifier
            .padding(bottom = 8.dp)
            .fillMaxWidth()
            .wrapContentHeight()){

            items(4){
                TeeraParameter(title = "Steps", value = "3600")
            }

        }
    }
}

@Composable
fun PersonalActivity(){
    Column(
        modifier = Modifier
            .padding(top = 8.dp, start = 16.dp, bottom = 8.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(text = "Today's activity"
            , fontFamily = appFontFamily
            , color = MaterialTheme.colors.Hyellow
            , fontWeight = FontWeight.Bold
            , fontSize = 20.sp
            , modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth())

        LazyRow(modifier = Modifier
            .padding(bottom = 8.dp)
            .fillMaxWidth()
            .wrapContentHeight()){

            items(4){
                TeeraParameter(title = "Steps", value = "3600")
            }

        }
    }
}

@Composable
fun OngoingChallenges(navController: NavController){

    val coach = Coach("steven.morphy@mail.com", "steven morphy", "", "")
    val challenge = Challenge("10 days walk", "", "","20-05-2022", "30-05-2022", coach, 0.35F, false)

    Column(
        modifier = Modifier
            .padding(top = 8.dp, start = 16.dp, bottom = 8.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            text = "Ongoing challenges",
            fontFamily = appFontFamily,
            color = MaterialTheme.colors.Hyellow,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )

        LazyRow(modifier = Modifier
            .padding(bottom = 8.dp)
            .fillMaxWidth()
            .wrapContentWidth()){
            items(6){
                ChallengeCard(challenge = challenge, onClick = {
                    navController.navigate("ChallengeDetails")
                })
            }
        }

    }
}

@Composable
fun FinishedChallenges(navController: NavController){

    val coach = Coach("steven.morphy@mail.com", "steven morphy", "", "")
    val challenge = Challenge("10 days walk", "", ""
        , "20-05-2022", "30-05-2022", coach, 0.35F, true)


    Column(
        modifier = Modifier
            .padding(top = 8.dp, start = 16.dp, bottom = 16.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            text = "Finished challenges",
            fontFamily = appFontFamily,
            color = MaterialTheme.colors.Hyellow,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )

        LazyRow(modifier = Modifier
            .padding(bottom = 8.dp)
            .fillMaxWidth()
            .wrapContentWidth()){
            items(4){
                ChallengeCard(challenge = challenge, onClick =  {
                    navController.navigate("ChallengePerformance")
                })
            }
        }

    }
}

@Composable
fun TeeraParameter(title: String, value: String){

    Column(modifier = Modifier
        .padding(8.dp)
        .height(85.dp)
        .wrapContentWidth()
        .background(
            color = MaterialTheme.colors.RoyalBlack,
            shape = MaterialTheme.shapes.MediumRound
        )
        , horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = title
            , fontFamily = appFontFamily
            , color = MaterialTheme.colors.Hpink
            , fontWeight = FontWeight.Bold
            , fontSize = 16.sp
            , modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                .fillMaxWidth())

        Text(text = value
            , fontFamily = appFontFamily
            , color = Color.White
            , fontWeight = FontWeight.Bold
            , fontSize = 16.sp
            , modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth())
    }
}

@Composable
fun ChallengeCard(modifier: Modifier = Modifier.padding(8.dp).wrapContentWidth(),
                  challenge: Challenge, onClick: () -> Unit = {}){

    Column(modifier = modifier
        .heightIn(min = 180.dp)
        .background(
            color = MaterialTheme.colors.RoyalBlack,
            shape = MaterialTheme.shapes.MediumRound)
        .clickable {
            onClick()
        }
        .padding(16.dp),
        horizontalAlignment = Alignment.Start) {

        Text(text = challenge.title
            , color = Color.White
            , fontFamily = appFontFamily
            , fontWeight = FontWeight.Bold
            , fontSize = 16.sp
            , modifier = Modifier.padding(start = 8.dp,end= 4.dp,top = 4.dp, bottom = 8.dp))

        Row(verticalAlignment = Alignment.CenterVertically
            , modifier = Modifier.padding(start = 4.dp, end = 4.dp, bottom = 8.dp)) {

            Icon(painter = painterResource(id = R.drawable.ic_clock)
                , contentDescription = "icon"
                , tint = MaterialTheme.colors.Hpink
                , modifier = Modifier.padding(4.dp))

            Text(text = challenge.startDate
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

            Text(text = challenge.endDate
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

            Text(text = challenge.coach.name
                , color = Color.White
                , fontFamily = appFontFamily
                , fontWeight = FontWeight.Medium
                , fontSize = 14.sp
                , modifier = Modifier.padding(start = 4.dp))
        }

        if(challenge.isFinished){
            Hbutton(text = "Check performance"
                , modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp)
                    .fillMaxWidth()
                , onClick = {

                })
        }
    }
}