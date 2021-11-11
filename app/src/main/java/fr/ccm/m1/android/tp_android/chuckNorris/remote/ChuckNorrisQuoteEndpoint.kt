package fr.ccm.m1.android.tp_android.chuckNorris.remote

import fr.ccm.m1.android.tp_android.chuckNorris.model.ChuckNorrisRetrofit
import retrofit2.http.GET

interface  ChuckNorrisQuoteEndpoint {
    @GET("random")
    suspend fun getRandomQuote() : ChuckNorrisRetrofit

}