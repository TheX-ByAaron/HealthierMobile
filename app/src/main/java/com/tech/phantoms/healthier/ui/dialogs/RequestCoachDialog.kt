package com.tech.phantoms.healthier.ui.dialogs

import android.content.Intent
import androidx.compose.foundation.background
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.tech.phantoms.healthier.R
import com.tech.phantoms.healthier.activities.HomeCoachActivity
import com.tech.phantoms.healthier.ui.composables.Hbutton
import com.tech.phantoms.healthier.ui.theme.HealthierTheme
import com.tech.phantoms.healthier.ui.theme.MediumRound
import com.tech.phantoms.healthier.ui.theme.RoyalBlack
import com.tech.phantoms.healthier.ui.theme.appFontFamily


@Composable
fun RequestCoachDialog(setIsOpen: (Boolean) -> Unit){

    Dialog(onDismissRequest = { setIsOpen(false) },
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)) {

        Column(modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .background(
                color = MaterialTheme.colors.RoyalBlack,
                shape = MaterialTheme.shapes.MediumRound
            )
            , horizontalAlignment = Alignment.CenterHorizontally) {

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
                    .size(60.dp)
                    .clip(CircleShape))


            Text(text = "Eithen fall"
                , color = Color.White
                , fontFamily = appFontFamily
                , fontWeight = FontWeight.Bold
                , fontSize = 18.sp
                , modifier = Modifier.padding(bottom = 8.dp))

            Hbutton(text = "Request Coach"
                , modifier = Modifier
                    .padding(top = 8.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth()
                , onClick = {})
        }
    }
}

@Preview
@Composable
fun DialogPreview(){
    HealthierTheme {
        RequestCoachDialog(setIsOpen = {})
    }
}