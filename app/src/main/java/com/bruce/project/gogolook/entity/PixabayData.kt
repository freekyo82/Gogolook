package com.bruce.project.gogolook.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PixabayData(
    @Json(name = "total") val totalCount: Int,
    @Json(name = "totalHits") val totalHits: Int,
    @Json(name = "hits") val hits: List<HitsItems>
)

@JsonClass(generateAdapter = true)
data class HitsItems(
    @Json(name = "id") val id: Int,
    @Json(name = "largeImageURL") val largeImageURL: String,
)
