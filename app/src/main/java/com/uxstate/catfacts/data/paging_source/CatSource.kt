package com.uxstate.catfacts.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.uxstate.catfacts.domain.model.ApiResponse

class CatSource: PagingSource<Int, ApiResponse>() {
    override fun getRefreshKey(state: PagingState<Int, ApiResponse>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ApiResponse> {

    }
}