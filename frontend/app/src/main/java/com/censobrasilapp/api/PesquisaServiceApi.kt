package com.censobrasilapp.api

import com.censobrasilapp.model.Pesquisa
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

private const val BASE_URL = "https://censo-backend-f9dc3fb9183b.herokuapp.com"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface PesquisaService {
    @GET("/api/v1/pesquisas/1")
    suspend fun getPesquisas() : Pesquisa
}

object PesquisaApi{
    val retrofitService : PesquisaService by lazy {
        retrofit.create(PesquisaService::class.java)
    }
}