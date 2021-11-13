package fr.ccm.m1.android.tp_android.dog.remote

import fr.ccm.m1.android.tp_android.dog.model.DogRetrofit
import retrofit2.http.GET

interface DogEndPoint {
    @GET(".")
    suspend fun getRandomPhrase() : DogRetrofit

}