package com.example.littlelemon.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple700 = Color(0xFFEE9972)

private val LightColorPalette = lightColors(
    primary = LittleLemonColors.yellow,
    secondary = LittleLemonColors.pink

)
object LittleLemonColors {
    val yellow = Color(0xFFFFEB3B) // Example yellow
    val pink = Color(0xFFE91E63)   // Example pink
}



@Composable
fun LittleLemonTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    MaterialTheme(
        colors = LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
