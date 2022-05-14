package com.tech.phantoms.healthier.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tech.phantoms.healthier.R
import com.tech.phantoms.healthier.models.Challenge
import com.tech.phantoms.healthier.models.Coach
import com.tech.phantoms.healthier.ui.composables.Hbutton
import com.tech.phantoms.healthier.ui.theme.Hyellow
import com.tech.phantoms.healthier.ui.theme.MediumRound
import com.tech.phantoms.healthier.ui.theme.RoyalBlack
import com.tech.phantoms.healthier.ui.theme.appFontFamily

@Composable
fun ChallengeDetailsScreen(){

    val coach = Coach("steven.morphy@mail.com", "steven morphy", "", "")
    val challenge = Challenge("10 days walk"
        , "Training makes wonders, start small, take a walk for 20 minutes each day for 10 days"
        , "This challenge is for people who struggle"
        , "20-05-2022", "30-05-2022"
        , coach, 0.35F, false)

    LazyColumn(modifier = Modifier.fillMaxSize()){

        item {
            ChallengeCard(challenge = challenge)
        }

        item {
            DescriptionCard(title = "Description", text = challenge.description)
        }

        item {
            DescriptionCard(title = "Objectives", text = challenge.goal)
        }

        item {
            Column(modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentHeight()
                , horizontalAlignment = Alignment.CenterHorizontally) {

                Text(text = stringResource(R.string.challenge_question)
                    , color = Color.White
                    , fontFamily = appFontFamily
                    , fontWeight = FontWeight.Medium
                    , fontSize = 16.sp
                    , textAlign = TextAlign.Center
                    , modifier = Modifier.padding(16.dp))

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    , horizontalArrangement = Arrangement.SpaceEvenly) {

                    Hbutton(modifier = Modifier
                        .padding(8.dp)
                        .widthIn(min = 120.dp)
                        , text = "Yes"
                        , onClick = {})

                    Hbutton(modifier = Modifier
                        .padding(8.dp)
                        .widthIn(min = 120.dp)
                        , text = "No"
                        , onClick = {})

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
fun DescriptionCard(title: String, text: String){

    Column(modifier = Modifier
        .padding(8.dp)
        .background(
            color = MaterialTheme.colors.RoyalBlack,
            shape = MaterialTheme.shapes.MediumRound
        )
    ){
        Text(
            text = title,
            fontFamily = appFontFamily,
            color = MaterialTheme.colors.Hyellow,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )

        Text(text = text
            , color = Color.White
            , fontFamily = appFontFamily
            , fontWeight = FontWeight.Medium
            , fontSize = 16.sp
            , textAlign = TextAlign.Center
            , modifier = Modifier.padding(16.dp))

    }
}

