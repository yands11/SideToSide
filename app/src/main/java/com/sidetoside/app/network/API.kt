package com.sidetoside.app.network

import com.sidetoside.app.entity.Compare
import com.sidetoside.app.entity.ComparePayload
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface API {

    @GET("compares")
    fun getCompares(lastId: Long): Response<List<Compare>>

    @GET("compares/{id}")
    fun getCompare(
        @Path("id") id: Long
    ): Response<Compare>

    @POST("compares")
    fun createCompare(
        @Body payload: ComparePayload
    ): Response<Compare>

}