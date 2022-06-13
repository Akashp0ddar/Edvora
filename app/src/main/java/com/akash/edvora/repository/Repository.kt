package com.akash.edvora.repository

import com.akash.edvora.api.RetroFitInstance
import com.akash.edvora.rides.Responses
import retrofit2.Response

class Repository {
    suspend fun getCustomRide(
        city: String,
        date: String,
        originStationCode: Int,
        id: Int,
        destinationStationCode: Int,
    ):Response<ArrayList<Responses>> {
        return RetroFitInstance.api.getCustomRides(
            city,
            date,
            originStationCode,
            id,
            destinationStationCode,
            )
    }
}