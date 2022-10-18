package com.uxstate.catfacts.data.remote.dto


import com.squareup.moshi.Json

data class ApiResponseDTO(
    @Json(name = "current_page")
    val currentPage: Int,
    @Json(name = "data")
    val data: List<Data>,
    @Json(name = "last_page")
    val lastPage: Int,

)