package com.uxstate.catfacts.data.remote.dto


import com.squareup.moshi.Json

data class Data(
    @Json(name = "fact")
    val fact: String,
    @Json(name = "length")
    val length: Int
)