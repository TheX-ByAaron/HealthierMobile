package com.tech.phantoms.healthier.ui.screens

import androidx.compose.foundation.layout.*
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
import com.tech.phantoms.healthier.models.DataPoints
import com.tech.phantoms.healthier.ui.theme.Hyellow
import com.tech.phantoms.healthier.ui.theme.appFontFamily


@Composable
fun ChallengerPerformanceCoach(){

    Column(modifier = Modifier.fillMaxSize()) {

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

            Text(text = "Challenger's performance"
                , color = MaterialTheme.colors.Hyellow
                , fontFamily = appFontFamily
                , fontWeight = FontWeight.Bold
                , fontSize = 18.sp
                , modifier = Modifier.padding(bottom = 2.dp))
        }

        Chart(lines = DataPoints.dataPoints1)
    }
}