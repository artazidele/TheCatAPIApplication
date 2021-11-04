package com.example.thecatapiapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.lang.StringBuilder

const val BASE_URL = "https://api.thecatapi.com/v1/"
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
class MainActivity : AppCompatActivity() {
    private val myStringBuilder = StringBuilder()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for (number in 1..20) {
            getMyData()
        }
//        getMyData()
    }
    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)
        val retrofitData = retrofitBuilder.getData()
        retrofitData.enqueue(object : Callback<List<MyDataItem>?>{
            override fun onResponse(
                call: Call<List<MyDataItem>?>,
                response: Response<List<MyDataItem>?>
            ) {
                val responseBody = response.body()!!
//                val myStringBuilder = StringBuilder()
                for (myData in responseBody) {
                    myStringBuilder.append(myData.url)
                    myStringBuilder.append("\n")
                }
                findViewById<TextView>(R.id.just_text).text = myStringBuilder
            }

            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
                Log.d("MainActivity", "onFailure: "+t.message)
            }
        })



    }
}