package com.uxstate.catfacts.presentation.screens.overview_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.uxstate.catfacts.R
import com.uxstate.catfacts.util.LocalSpacing

@Composable
fun ErrorItem() {

    val spacing = LocalSpacing.current
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Image(
                painter = painterResource(id = R.drawable.ic_error),

                modifier = Modifier
                        .size(spacing.spaceLarge)
                        .padding(spacing.spaceSmall),
                contentDescription = stringResource(
                        R.string.error_message
                )
        )

    }
}