package com.tech.phantoms.healthier.ui.theme


import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)

val Shapes.FullRounded : Shape
    get() = RoundedCornerShape(size = 1000.dp)

val Shapes.MediumRound: Shape
    get() = RoundedCornerShape(size = 20.dp)