package com.tech.phantoms.healthier.ui.composables

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import com.tech.phantoms.healthier.R
import com.tech.phantoms.healthier.ui.theme.appFontFamily

@Composable
fun TextInput(modifier: Modifier = Modifier
              , input:String
              , onInputChange: (String) -> Unit
              , type: KeyboardType = KeyboardType.Text
              , hint: String){

    TextField(value = input
        , onValueChange = { onInputChange(it) }
        , modifier = modifier
        , placeholder = { Text(text = hint, color = Color.Gray , fontFamily = appFontFamily) }
        , keyboardOptions = KeyboardOptions(
            keyboardType = type
        )
        , shape = MaterialTheme.shapes.medium
        , singleLine = true
        , maxLines = 1
        , colors = ComposableConstants.textFieldColors())
}

@Composable
fun PasswordInput(modifier: Modifier = Modifier
                  , input:String
                  , onInputChange: (String) -> Unit
                  , hint: String){

    var passwordVisibility by remember { mutableStateOf(false) }
    val passwordIcon = painterResource(id = if(passwordVisibility) R.drawable.ic_eye_slash
    else R.drawable.ic_eye)

    TextField(value = input
        , trailingIcon = {
            IconButton(onClick = {
                passwordVisibility = !passwordVisibility
            }) {
                Icon(painter =passwordIcon
                    , contentDescription = "password icon"
                    , tint = Color.Gray)
            }
        }
        , onValueChange = { onInputChange(it) }
        , modifier = modifier
        , placeholder = { Text(text = hint, color = Color.Gray, fontFamily = appFontFamily) }
        , keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        )
        , visualTransformation = ComposableConstants
            .passwordTransformation(visibility = passwordVisibility)
        , shape = MaterialTheme.shapes.medium
        , singleLine = true
        , maxLines = 1
        , colors = ComposableConstants.textFieldColors())
}