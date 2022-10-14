package com.mironk.starwarsfilms.api

import com.mironk.starwarsfilms.model.ResponseApi
import com.mironk.starwarsfilms.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getAllCharacters(
        @Query("page") page:Int
    ) : Response<ResponseApi>
}