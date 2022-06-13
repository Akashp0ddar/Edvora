package com.akash.edvora.repository

import com.akash.edvora.api.RetroFitInstance

class Repository {
    suspend fun getCustomRide(
        city: String,
        date: String,
        originStationCode: Int,
        id: Int,
        destinationStationCode: Int,
    ) {
        return RetroFitInstance.api.getCustomRides(
            city,
            date,
            originStationCode,
            id,
            destinationStationCode,
            )
    }
}