package fr.ccm.m1.android.tp_android.architecture

import com.google.gson.GsonBuilder
import fr.ccm.m1.android.tp_android.chuckNorris.remote.ChuckNorrisQuoteEndpoint
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.chucknorris.io/jokes/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()))
        .build()




    fun getChuckNorrisQuote(): ChuckNorrisQuoteEndpoint = retrofit.create(ChuckNorrisQuoteEndpoint::class.java)

}