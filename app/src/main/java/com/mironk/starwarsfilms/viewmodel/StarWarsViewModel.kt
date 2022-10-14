package com.mironk.starwarsfilms.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.mironk.starwarsfilms.api.ApiService
import com.mironk.starwarsfilms.paging.StarWarsPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel()
class StarWarsViewModel
@Inject constructor(private val apiService: ApiService) : ViewModel() {

    val listData = Pager(PagingConfig(pageSize = 1)) {
        StarWarsPagingSource(apiService)
    }.flow.cachedIn(viewModelScope)

}