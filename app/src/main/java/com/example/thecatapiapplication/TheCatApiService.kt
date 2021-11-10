package com.example.thecatapiapplication

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val API_URL = "https://api.thecatapi.com/v1/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(API_URL)
    .build()
interface TheCatApiService {
    @GET("images/search")
    suspend fun getPhotos(): List<CatPhoto>
}
object CatApi {
    val retrofitService: TheCatApiService by lazy { retrofit.create(TheCatApiService::class.java) }
}