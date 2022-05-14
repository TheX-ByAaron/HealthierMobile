package com.tech.phantoms.healthier.ui.composables

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tech.phantoms.healthier.ui.theme.FullRounded
import com.tech.phantoms.healthier.ui.theme.Hyellow
import com.tech.phantoms.healthier.ui.theme.RoyalBlack
import com.tech.phantoms.healthier.ui.theme.appFontFamily


@Composable
fun HealthChip(modifier: Modifier = Modifier
               , name: String
               , isSelected: Boolean
               , setIsSelected: (Boolean) -> Unit){

    var isChipSelected by remember { mutableStateOf(isSelected) }
    val backgroundColor = animateColorAsState(targetValue = if(isChipSelected)
        MaterialTheme.colors.Hyellow else MaterialTheme.colors.RoyalBlack)

    val textColor = animateColorAsState(targetValue = if (isChipSelected) MaterialTheme.colors.RoyalBlack
        else MaterialTheme.colors.Hyellow)

    Box(modifier = modifier
        .height(50.dp)
        .background(
            color = backgroundColor.value,
            shape = MaterialTheme.shapes.FullRounded
        )
        .clip(
            shape = MaterialTheme.shapes.FullRounded
        )
        .clickable {
            setIsSelected(!isSelected)
            isChipSelected = !isChipSelected
        }
        , contentAlignment = Alignment.Center){

        Text(text = name
            , color = textColor.value
            , fontFamily = appFontFamily
            , fontWeight = FontWeight.Bold
            , fontSize = 16.sp
            , modifier = Modifier.padding(horizontal = 16.dp, 8.dp))
    }
}