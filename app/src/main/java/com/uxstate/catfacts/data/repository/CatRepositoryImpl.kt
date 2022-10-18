package com.uxstate.catfacts.data.repository

import com.uxstate.catfacts.data.remote.CatAPI
import com.uxstate.catfacts.domain.model.ApiResponse
import com.uxstate.catfacts.domain.repository.CatRepository
import javax.inject.Inject

class CatRepositoryImp @Inject constructor( val api:CatAPI) :CatRepository{


    override suspend fun getCatFacts(page:Int): ApiResponse {
        return api.getCatFacts(page = page)
    }
}