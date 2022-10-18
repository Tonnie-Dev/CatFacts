package com.uxstate.catfacts.presentation.screens.overview_screen.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.uxstate.catfacts.util.LocalSpacing

@Composable
fun FactRow(modifier: Modifier = Modifier, fact: String) {
    val spacing = LocalSpacing.current
    Row(
            modifier = modifier
                    .padding(spacing.spaceMedium)
                    .border(
                            width = spacing.spacingTwoDp,
                            color = MaterialTheme.colors.primary,
                            shape = CutCornerShape(spacing.spaceSmall)
                    )
    ) {
        Text(
                text = fact, modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        )
    }


}