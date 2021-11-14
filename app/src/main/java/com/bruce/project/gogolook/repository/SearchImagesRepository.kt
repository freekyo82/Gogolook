package com.bruce.project.gogolook.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.bruce.project.gogolook.Api.PixabayApi
import com.bruce.project.gogolook.data.SearchImagesDataSource
import dagger.Reusable
import javax.inject.Inject

@Reusable
class SearchImagesRepository @Inject constructor(
    private val pixabayApi: PixabayApi
) {
    fun getSearchDataListPage(search: String) =
        Pager(PagingConfig(pageSize = 10)) {
            SearchImagesDataSource(search, pixabayApi)
        }.flow

}