package com.mironk.starwarsfilms.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mironk.starwarsfilms.api.ApiService
import com.mironk.starwarsfilms.model.StarWars


class StarWarsPagingSource(
    private val apiService: ApiService
) : PagingSource<Int, StarWars>() {
    override fun getRefreshKey(state: PagingState<Int, StarWars>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, StarWars> {

        return try {
            val currentPage = params.key ?: 1
            val response = apiService.getAllCharacters(currentPage)
            val data = response.body()?.results?: emptyList()
            val responseData = mutableListOf<StarWars>()
            responseData.addAll(data)

            LoadResult.Page(
                data = responseData,
                prevKey = if(currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )

        }catch (e:Exception) {
            LoadResult.Error(e)
        }
    }


}