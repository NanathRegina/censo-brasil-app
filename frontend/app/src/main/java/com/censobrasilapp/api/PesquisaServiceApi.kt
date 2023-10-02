package com.censobrasilapp.api

import com.censobrasilapp.model.Pesquisa
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface PesquisaServiceApi {

    @GET("api/v1/pesquisas/1/")
    fun getPesquisa() : Call<Pesquisa>

    @POST("api/v1/pesquisas/pesquisa/")
    fun createPesquisa(@Body pesquisa: Pesquisa) : Call<Pesquisa>
}
