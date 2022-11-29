package com.udacity.asteroidradar.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.PictureOfDay

class MainViewModel : ViewModel() {

    private var _imgOfDay = MutableLiveData<PictureOfDay>()
    val imgOfDay: LiveData<PictureOfDay> = _imgOfDay

    private var _astroidList = MutableLiveData<List<Asteroid>>()
    val astroidLite: LiveData<List<Asteroid>> = _astroidList

    fun getPicOfDay(){
//        var imgName =
//        _imgOfDay.value =
    }

    fun getAstroidsList(){
        val astList = mutableListOf<Asteroid>()
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
        _astroidList.value = astList
    }
}