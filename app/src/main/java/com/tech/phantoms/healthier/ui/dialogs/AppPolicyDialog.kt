package com.tech.phantoms.healthier.ui.dialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.tech.phantoms.healthier.R
import com.tech.phantoms.healthier.ui.theme.MediumRound
import com.tech.phantoms.healthier.ui.theme.RoyalBlack
import com.tech.phantoms.healthier.ui.theme.appFontFamily


@Composable
fun AppPolicyDialog(isOpen: Boolean, setIsOpen : (Boolean) -> Unit){

    Dialog(onDismissRequest = { setIsOpen(false) },
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)) {

        Column(modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .background(
                color = MaterialTheme.colors.RoyalBlack,
                shape = MaterialTheme.shapes.MediumRound
            )
            , horizontalAlignment = Alignment.CenterHorizontally) {

            Text(text ="Our data policy"
                , color = Color.White
                , fontFamily = appFontFamily
                , fontSize = 20.sp
                , fontWeight = FontWeight.Bold
                , modifier = Modifier.padding(top = 30.dp, bottom = 16.dp, start = 16.dp, end = 16.dp))

            Text(text = stringResource(R.string.policy_description)
                , color = Color.White
                , fontFamily = appFontFamily
                , fontSize = 16.sp
                , fontWeight = FontWeight.Medium
                , textAlign = TextAlign.Center
                , modifier = Modifier.padding(start = 24.dp, end = 24.dp, bottom = 24.dp)
                    .fillMaxWidth()
                    .wrapContentHeight())
        }
    }
}

@Preview
@Composable
fun AppPolicyDialogPreview(){
    AppPolicyDialog(true, {})
}