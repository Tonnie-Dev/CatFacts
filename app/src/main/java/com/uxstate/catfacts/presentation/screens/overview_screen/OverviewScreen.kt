package com.uxstate.catfacts.presentation.screens.overview_screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.uxstate.catfacts.presentation.screens.overview_screen.components.LoadingItem
import com.uxstate.catfacts.presentation.screens.overview_screen.components.TopRow

@Composable
fun OverviewScreen(viewModel: CatViewModel = hiltViewModel()) {


    //collect paging data from viewModel
    val facts = viewModel.pager.collectAsLazyPagingItems()

    Scaffold(topBar = {
        TopRow(lastPage = 3, modifier = Modifier.fillMaxWidth()) {

        }
    }) { values ->

        LazyColumn(contentPadding = values,
                content = {
                    when(facts.loadState.refresh){

                        is LoadState.Loading -> {}
                        is LoadState.NotLoading -> {}
                        is LoadState.Error -> {}
                    }



                })


    }
}


fun LazyListScope.LoadItemExtension(){

  item {

      LoadingItem()
  }
}
