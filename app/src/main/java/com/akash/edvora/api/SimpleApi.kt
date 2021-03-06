package com.akash.edvora.api

import com.akash.edvora.rides.Responses
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SimpleApi {
    @GET("rides")
    suspend fun getCustomRides(
        @Query("city") city: String,
        @Query("date")date: String,
        @Query("stationPath") stationPath: Int,
        @Query("userId") userId: Int,
        @Query("destinationStationCode")destinationStationCode: Int,
        ): Response<ArrayList<Responses>>
}