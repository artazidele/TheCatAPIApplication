package com.example.thecatapiapplication

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("images/search")
    fun getData(): Call<List<MyDataItem>>
}