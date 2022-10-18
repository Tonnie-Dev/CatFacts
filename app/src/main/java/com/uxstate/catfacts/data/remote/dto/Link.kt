package com.uxstate.catfacts.data.remote.dto


import com.squareup.moshi.Json

data class Link(
    @Json(name = "active")
    val active: Boolean,
    @Json(name = "label")
    val label: String,
    @Json(name = "url")
    val url: String?
)