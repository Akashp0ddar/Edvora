package com.akash.edvora

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akash.edvora.repository.Repository
import com.akash.edvora.rides.RidesItem
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {
    val myCustomRides: MutableLiveData<Response<List<RidesItem>>> = MutableLiveData()


    fun getCustomRides(
        city: String,
        date: String,
        originStationCode: Int,
        id: Int,
        destinationStaionCode: Int,
    ) {
        viewModelScope.launch {
            val response =
                repository.getCustomRide(city, date, originStationCode, id, destinationStaionCode)
        }
    }
}