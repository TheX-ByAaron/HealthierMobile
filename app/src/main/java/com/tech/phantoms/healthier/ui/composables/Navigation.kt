package com.tech.phantoms.healthier.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tech.phantoms.healthier.R
import com.tech.phantoms.healthier.ui.theme.Hpink
import com.tech.phantoms.healthier.ui.theme.MediumRound


@Composable
fun TopBar(){

    Row(verticalAlignment = Alignment.CenterVertically
        ,modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)){

        Image(painter = painterResource(id = R.drawable.ic_logo_stripped)
            , contentDescription = "App logo"
            , modifier = Modifier
                .padding(start = 16.dp)
                .size(50.dp))

        Spacer(modifier = Modifier
            .height(50.dp)
            .weight(1F))

        Icon(painter = painterResource(id = R.drawable.ic_notification)
            , contentDescription = "Action Notification"
            , tint = MaterialTheme.colors.Hpink
            , modifier = Modifier
                .padding(start = 8.dp, end = 4.dp, top = 8.dp, bottom = 8.dp)
                .size(30.dp)
                .clip(MaterialTheme.shapes.MediumRound)
                .clickable {  })

        Icon(painter = painterResource(id = R.drawable.ic_settings)
            , contentDescription = "Action Settings"
            , tint = MaterialTheme.colors.Hpink
            , modifier = Modifier
                .padding(start = 8.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
                .size(30.dp)
                .clip(MaterialTheme.shapes.MediumRound)
                .clickable {  })
    }
}