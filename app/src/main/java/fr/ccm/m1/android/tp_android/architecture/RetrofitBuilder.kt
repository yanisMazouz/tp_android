package fr.ccm.m1.android.tp_android.architecture

import com.google.gson.GsonBuilder
import fr.ccm.m1.android.tp_android.chuckNorris.remote.ChuckNorrisQuoteEndpoint
import fr.ccm.m1.android.tp_android.dog.remote.DogEndPoint
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.chucknorris.io/jokes/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()))
        .build()

    fun getChuckNorrisQuote(): ChuckNorrisQuoteEndpoint = retrofit.create(ChuckNorrisQuoteEndpoint::class.java)

    private val retrofitDog: Retrofit = Retrofit.Builder()
        .baseUrl("https://some-random-api.ml/animal/dog/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()))
        .build()




    fun getDogPhrase(): DogEndPoint = retrofitDog.create(DogEndPoint::class.java)


}