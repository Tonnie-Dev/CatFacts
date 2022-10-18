package com.uxstate.catfacts.presentation.screens.overview_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.uxstate.catfacts.data.paging_source.CatPagingSource
import com.uxstate.catfacts.domain.repository.CatRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CatViewModel @Inject constructor(private val repository: CatRepository) : ViewModel() {

    /*Pager is responsible for incrementally pulling chunks of data
    from the PagingSource as requested by the UI.*/


    //instantiate a Pager instance
    val pager =
        Pager(config = PagingConfig(pageSize = 1)) //1st Arg
        { CatPagingSource(repository) } // 2nd Arg - PagingSource
                .flow                   //access flow property
                .cachedIn(viewModelScope)//cache loaded data in VM

}