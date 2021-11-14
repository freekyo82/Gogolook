package com.bruce.project.gogolook.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bruce.project.gogolook.Api.PixabayApi
import com.bruce.project.gogolook.entity.HitsItems
import retrofit2.HttpException
import java.io.IOException

class SearchImagesDataSource constructor(
    private val search: String,
    private val pixabayApi: PixabayApi

) : PagingSource<Int, HitsItems>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, HitsItems> {
        return try {
            val page = params.key ?: 1
            val result = pixabayApi.getSearchImage(
                key = "24287546-f57c28b604e7ad45c1ec4872a",
                query = search,
                perPage = params.loadSize,
                page = page
            )

            LoadResult.Page(
                prevKey = null,
                nextKey = if (result.totalCount <= params.loadSize) null else page + 1,
                data = result.hits
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, HitsItems>): Int? {
        return null
    }
}