package com.uxstate.catfacts.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.uxstate.catfacts.domain.model.CatFact
import com.uxstate.catfacts.domain.repository.CatRepository
import com.uxstate.catfacts.util.CAT_FACTS_STARTING_PAGE_INDEX
import retrofit2.HttpException
import java.io.IOException

class CatPagingSource(private val repository: CatRepository) : PagingSource<Int, CatFact>() {
    override fun getRefreshKey(state: PagingState<Int, CatFact>): Int? {
        TODO("Not yet implemented")
    }

    //called by the Paging library to asynchronously fetch data to be displayed
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CatFact> {

        return try {
            /* this is not the page number, it is inherited from
               getRefreshKey() - if null the position is set to 1*/
            val position = params.key ?: CAT_FACTS_STARTING_PAGE_INDEX
            val response = repository.getCatFacts(page = position)
            val data = response.data

            val prevKey = if (position == CAT_FACTS_STARTING_PAGE_INDEX)
                null
            else
                position.minus(1)

            val nextKey = if (data.isEmpty())
                null
            else
                position.plus(1)

            //construct and return the LoadResult.Page
            LoadResult.Page(
                    data = data,
                    prevKey = prevKey,
                    nextKey = nextKey
            )
        } catch (e: HttpException) {
            LoadResult.Error(throwable = e)

        }catch (e: IOException) {
            LoadResult.Error(throwable = e)
        }


    }
}