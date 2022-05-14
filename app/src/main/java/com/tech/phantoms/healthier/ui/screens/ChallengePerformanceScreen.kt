package com.tech.phantoms.healthier.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.madrapps.plot.line.DataPoint
import com.madrapps.plot.line.LineGraph
import com.madrapps.plot.line.LinePlot
import com.tech.phantoms.healthier.R
import com.tech.phantoms.healthier.models.Challenge
import com.tech.phantoms.healthier.models.Coach
import com.tech.phantoms.healthier.models.DataPoints
import com.tech.phantoms.healthier.ui.composables.Hbutton
import com.tech.phantoms.healthier.ui.dialogs.RequestCoachDialog
import com.tech.phantoms.healthier.ui.theme.*

@Composable
fun ChallengePerformanceScreen(){

    val coach = Coach("steven.morphy@mail.com", "steven morphy", "", "")
    val challenge = Challenge("10 days walk"
        , "Training makes wonders, start small, take a walk for 20 minutes each day for 10 days"
        , "This challenge is for people who struggle"
        , "20-05-2022", "30-05-2022"
        , coach, 0.35F, false)

    var isDialogOpen by remember{ mutableStateOf(false)}
    var setIsDialogOpen : (Boolean) -> Unit = {
        isDialogOpen = it
    }

    if(isDialogOpen){
        RequestCoachDialog(setIsOpen = setIsDialogOpen)
    }

    LazyColumn(modifier = Modifier.fillMaxSize()){

        item {
            Column(modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .heightIn(min = 180.dp)
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
            }
        }

        item {
            Text(
                text = "Performance",
                fontFamily = appFontFamily,
                color = MaterialTheme.colors.Hyellow,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
        }

        item {
            Chart(lines = DataPoints.dataPoints1)
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
                        , onClick = {
                            setIsDialogOpen(true)
                        })

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
fun Chart(lines: List<DataPoint>){
    Box(modifier = Modifier
        .padding(8.dp)
        .wrapContentSize()
        .clip(MaterialTheme.shapes.MediumRound)) {

        LineGraph(
            plot = LinePlot(
                listOf(
                    LinePlot.Line(
                        lines,
                        LinePlot.Connection(color = MaterialTheme.colors.Hpink),
                        LinePlot.Intersection(color = MaterialTheme.colors.Hpink),
                        LinePlot.Highlight(color = MaterialTheme.colors.Hpink),
                    )
                ),
                grid = LinePlot.Grid(MaterialTheme.colors.Hpink, steps = 4),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(MaterialTheme.colors.HBlack),
            onSelection = { xLine, points ->
                // Do whatever you want here
            }
        )
    }
}