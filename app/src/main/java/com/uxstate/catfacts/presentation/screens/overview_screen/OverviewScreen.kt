package com.uxstate.catfacts.presentation.screens.overview_screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.uxstate.catfacts.presentation.screens.overview_screen.components.ErrorItem
import com.uxstate.catfacts.presentation.screens.overview_screen.components.FactRow
import com.uxstate.catfacts.presentation.screens.overview_screen.components.LoadingItem
import com.uxstate.catfacts.presentation.screens.overview_screen.components.TopRow

@Composable
fun OverviewScreen(viewModel: CatViewModel = hiltViewModel()) {


    //collect paging data from viewModel
    val facts = viewModel.pager.collectAsLazyPagingItems()

    //collect current page state
    val currentPage by viewModel.currentPage.collectAsState()
    val prevPage by viewModel.prevKey.collectAsState()
    val nextPage by viewModel.nextKey.collectAsState()

    Scaffold(topBar = {
        TopRow( modifier = Modifier.fillMaxWidth(), pos = currentPage, prev = prevPage, next= nextPage) {
            facts.refresh()
        }
    }) { values ->

        LazyColumn(contentPadding = values,
                content = {

                    //Refresh
                    when (facts.loadState.refresh) {
                        is LoadState.Loading -> loadingItemExtension()
                        is LoadState.NotLoading -> Unit
                        is LoadState.Error -> errorItemExtension()
                    }

                    //Prepend
                    when (facts.loadState.prepend) {
                        is LoadState.Loading -> loadingItemExtension()
                        is LoadState.NotLoading -> Unit
                        is LoadState.Error -> errorItemExtension()
                    }

                    //Append
                    when (facts.loadState.append) {
                        is LoadState.Loading -> loadingItemExtension()
                        is LoadState.NotLoading -> Unit
                        is LoadState.Error -> errorItemExtension()
                    }

                    items(facts) { fact ->

                        fact?.let {

                            FactRow(fact = it.fact)
                        }

                    }

                })


    }
}


fun LazyListScope.loadingItemExtension() {

    item {

        LoadingItem()
    }
}

fun LazyListScope.errorItemExtension() {

    item {

        ErrorItem()
    }
}
