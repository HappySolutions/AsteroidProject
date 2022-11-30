package com.udacity.asteroidradar.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.Constants
import com.udacity.asteroidradar.PictureOfDay
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(Constants.BASE_URL)
    .build()

interface NasaApiService{
@GET("/neo/rest/v1/feed")
fun getAstroids():
        Call<List<Asteroid>>

@GET("/planetary/apod")
fun getNasaImage():
        Call<PictureOfDay>
}

object NasaApi{
    val retrofitService : NasaApiService by lazy{
        retrofit.create(NasaApiService::class.java)
    }
}