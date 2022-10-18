package com.uxstate.catfacts.presentation.screens.overview_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TopRow(modifier: Modifier = Modifier, onClick: ()-> Unit) {

    Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Button(onClick = onClick, shape = RoundedCornerShape()) {


        }

    }


}

@Preview
@Composable
fun TopRowPreview() {
    TopRow()
}