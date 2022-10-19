package com.uxstate.catfacts.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.uxstate.catfacts.domain.model.CatFact
import com.uxstate.catfacts.domain.repository.CatRepository
import com.uxstate.catfacts.util.CAT_FACTS_STARTING_PAGE_INDEX
import retrofit2.HttpException
import java.io.IOException

class CatPagingSource(
    private val repository: CatRepository,
    private val pageUpdater: (Int,Int?, Int?) -> Unit
) : PagingSource<Int, CatFact>() {


    /*takes a PagingState object as a parameter and returns
   the key to pass into the load() method when the data is
    refreshed or invalidated after the initial load. */

    override fun getRefreshKey(state: PagingState<Int, CatFact>): Int? {

        /*
       This will always start loading from the beginning.
       Same effect as return AT_FACTS_STARTING_PAGE_INDEX.
       */
       // return null
        //If you want the list to resume at page 5, return 5, etc..

        //get the anchor page from anchor position
        /*return state.anchorPosition?.let { anchorPosition ->

            //anchorPageState:LoadState.Page<Int,CatFact>?
            val anchorPageState = state.closestPageToPosition(anchorPosition)

            //anchorPage:Int?
            val anchorPage = anchorPageState?.prevKey?.plus(1)
                ?: anchorPageState?.nextKey?.minus(1)

            //return the anchor page now
            anchorPage
        }*/

       // return state.anchorPosition

        return null
    }

    //called by the Paging library to asynchronously fetch data to be displayed
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CatFact> {

        return try {
            /* params.key comes 4 different places */
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

            //update page
            pageUpdater(position,prevKey,nextKey)

            //construct and return the LoadResult.Page
            LoadResult.Page(
                    data = data,
                    prevKey = prevKey,
                    nextKey = nextKey
            )
        } catch (e: HttpException) {
            LoadResult.Error(throwable = e)

        } catch (e: IOException) {
            LoadResult.Error(throwable = e)
        }


    }
}