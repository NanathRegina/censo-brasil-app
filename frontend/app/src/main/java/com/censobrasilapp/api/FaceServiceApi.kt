package com.censobrasilapp.api

import com.censobrasilapp.model.Face
import com.censobrasilapp.model.Pesquisa
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface FaceServiceApi {

    @GET("api/v1/faces/")
    fun getFaces() : Call<List<Face>>

    @POST("api/v1/faces/face")
    fun createFace(@Body face: Face) : Call<Face>

}
