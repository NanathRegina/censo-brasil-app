package com.censobrasilapp.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



private const val BASE_URL = "https://censo-backend-f9dc3fb9183b.herokuapp.com/"

class NetworkUtils {

    companion object {

        fun getRetrofitInstance() : Retrofit {
            return Retrofit.Builder()
                .baseUrl("$BASE_URL")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}