package com.akash.edvora.rides

import com.google.gson.annotations.SerializedName



data class Responses (

	@SerializedName("id") val id : Int,
	@SerializedName("origin_station_code") val origin_station_code : Int,
	@SerializedName("station_path") val station_path : List<Int>,
	@SerializedName("destination_station_code") val destination_station_code : Int,
	@SerializedName("date") val date : String,
	@SerializedName("map_url") val map_url : String,
	@SerializedName("state") val state : String,
	@SerializedName("city") val city : String
)