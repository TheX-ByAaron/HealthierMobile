package com.tech.phantoms.healthier.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tech.phantoms.healthier.ui.theme.FullRounded
import com.tech.phantoms.healthier.ui.theme.HealthierTheme
import com.tech.phantoms.healthier.ui.theme.Hpink
import com.tech.phantoms.healthier.ui.theme.appFontFamily


@Composable
fun Hbutton(modifier: Modifier = Modifier
            , text: String = ""
            , onClick: () -> Unit = {}){

    Box(modifier = modifier
        .height(50.dp)
        .wrapContentWidth()
        .background(
            color = MaterialTheme.colors.Hpink,
            shape = MaterialTheme.shapes.FullRounded)
        .clip(shape = MaterialTheme.shapes.FullRounded)
        .clickable { onClick() }
        .padding(horizontal = 24.dp, vertical = 8.dp)

        , contentAlignment = Alignment.Center){

        Text(text = text
            , fontSize = 16.sp
            , fontFamily = appFontFamily
            , fontWeight = FontWeight.Bold
            , color = Color.White)
    }
}

@Composable
fun HTextButton(modifier: Modifier = Modifier
                , text: String = ""
                , onClick: () -> Unit = {}
                , tint: Color){

    Box(modifier = modifier
        .height(50.dp)
        .wrapContentWidth()
        .clip(shape = MaterialTheme.shapes.FullRounded)
        .clickable { onClick() }
        .padding(horizontal = 24.dp, vertical = 8.dp)
        , contentAlignment = Alignment.Center){

        Text(text = text
            , fontSize = 16.sp
            , fontFamily = appFontFamily
            , fontWeight = FontWeight.Bold
            , color = tint)
    }
}

@Preview
@Composable
fun mainPreview(){
    HealthierTheme {
        HTextButton(text = "Live preview", tint = MaterialTheme.colors.Hpink)
    }
}