package com.uxstate.catfacts.data.mapper

import com.uxstate.catfacts.data.remote.dto.ApiResponseDTO
import com.uxstate.catfacts.domain.model.ApiResponse


//from dto to model
fun ApiResponseDTO.toModel():ApiResponse {


    return ApiResponse(data = this.data, currentPage = this.currentPage, lastPage = this.lastPage)
}

//from model to dto