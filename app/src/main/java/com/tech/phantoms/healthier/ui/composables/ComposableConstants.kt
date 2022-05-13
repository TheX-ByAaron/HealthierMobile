package com.tech.phantoms.healthier.ui.composables

import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

object ComposableConstants {

    @Composable
    fun textFieldColors() = TextFieldDefaults.textFieldColors(
    backgroundColor = Color.Transparent,
    textColor = Color.White,
    focusedLabelColor = Color.Transparent,
    disabledIndicatorColor = Color.Transparent,
    errorIndicatorColor = Color.Transparent,
    focusedIndicatorColor = Color.Transparent,
    unfocusedIndicatorColor = Color.Transparent)

    @Composable
    fun passwordTransformation(visibility: Boolean): VisualTransformation{
        return if(visibility) VisualTransformation.None
        else PasswordVisualTransformation()
    }
}