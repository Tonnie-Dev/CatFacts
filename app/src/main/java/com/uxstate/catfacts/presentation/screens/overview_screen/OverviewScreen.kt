package com.uxstate.catfacts.presentation.screens.overview_screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.uxstate.catfacts.presentation.screens.overview_screen.components.TopRow

@Composable
fun OverviewScreen(viewModel: CatViewModel = hiltViewModel()) {


    //collect paging data from viewModel
    val facts = viewModel.pager.collectAsLazyPagingItems()

    Scaffold(topBar = {
        TopRow(lastPage = 3, modifier = Modifier.fillMaxWidth()) {

        }
    }) {



    }
}