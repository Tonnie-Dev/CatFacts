package com.uxstate.catfacts.util

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


//data class with the default values
data class Dimens(
    val spaceDefault: Dp = 0.dp,
    val spacingTwoDp:Dp = 2.dp,
    val spaceExtraSmall: Dp = 4.dp,
    val spaceSmall: Dp = 8.dp,
    val spaceMedium: Dp = 16.dp,
    val spaceLarge: Dp = 32.dp,
    val spaceExtraLarge: Dp = 64.dp,
    val spaceOneHundred: Dp = 100.dp,
    val spaceOneHundredFifty: Dp = 150.dp,
    val spaceTwoHundred: Dp = 200.dp

)


val LocalSpacing = compositionLocalOf { Dimens() }

