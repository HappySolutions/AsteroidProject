package com.udacity.asteroidradar.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.PictureOfDay
import com.udacity.asteroidradar.network.NasaApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private var _imgOfDay = MutableLiveData<PictureOfDay>()
    val imgOfDay: LiveData<PictureOfDay> = _imgOfDay

    var astList = mutableListOf<Asteroid>()
    var nasaImage = mutableListOf<PictureOfDay>()

    private var _astroidList = MutableLiveData<List<Asteroid>>()
    val astroidLite: LiveData<List<Asteroid>> = _astroidList

    init{
        getAstroidsList()
        getPicOfDay()
    }

     fun getPicOfDay(){
        nasaImage.add(
            PictureOfDay("","","")
        )
        nasaImage.add(
            PictureOfDay("","","")
        )
        nasaImage.add(
            PictureOfDay("","","")
        )

        NasaApi.retrofitService.getNasaImage().enqueue(object: Callback<PictureOfDay> {
            override fun onResponse(call: Call<PictureOfDay>, response: Response<PictureOfDay>) {
                _imgOfDay.value = response.body()
            }

            override fun onFailure(call: Call<PictureOfDay>, t: Throwable) {
                //_imgOfDay.value = nasaImage

            }


        })

    }

     fun getAstroidsList(){
        astList.add(
            Asteroid(
                4, "codename1", " closeApproachDate1",
                2.0, 1.0, 3.0, 4.0, true
            )
        )
        astList.add(
            Asteroid(
                2, "codename2", " closeApproachDate2",
                2.0, 1.0, 3.0, 4.0, false
            )
        )
        astList.add(
            Asteroid(
                3, "codename3", " closeApproachDate3",
                2.0, 1.0, 3.0, 4.0, true
            )
        )
        astList.add(
            Asteroid(
                4, "codename4", " closeApproachDate4",
                2.0, 1.0, 3.0, 4.0, false
            )
        )

        NasaApi.retrofitService.getAstroids().enqueue(object: Callback<List<Asteroid>> {
            override fun onResponse(
                call: Call<List<Asteroid>>,
                response: Response<List<Asteroid>>
            ) {
                _astroidList.value = response.body()
            }

            override fun onFailure(call: Call<List<Asteroid>>, t: Throwable) {
                _astroidList.value = astList
            }

        })


    }

}