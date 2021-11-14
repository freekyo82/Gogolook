package com.bruce.project.gogolook.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.bruce.project.gogolook.repository.SearchImagesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchImagesRepository: SearchImagesRepository
) : ViewModel() {

    fun getSearchDataList(search: String) =
        searchImagesRepository.getSearchDataListPage(search)
            .cachedIn(viewModelScope)
}