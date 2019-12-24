package com.sidetoside.app.network

import com.sidetoside.app.entity.Comment
import com.sidetoside.app.entity.Compare
import com.sidetoside.app.entity.ComparePayload
import com.sidetoside.app.entity.VotePayload
import retrofit2.Response
import retrofit2.http.*


interface CompareAPI {

    @GET("compares")
    suspend fun getCompares(
        @Query("last_id") lastId: Long? = null
    ): Response<List<Compare>>

    @POST("compares")
    suspend fun createCompare(
        @Body payload: ComparePayload
    ): Response<Compare>

    @GET("compares/{compare_id}")
    suspend fun getCompare(
        @Path("compare_id") id: Long
    ): Response<Compare>

    @GET("compares/{compare_id}/comments")
    suspend fun getComments(
        @Path("compare_id") id: Long
    ): Response<List<Comment>>

    @POST("compares/{compare_id}/comments")
    suspend fun submitComment(
        @Path("compare_id") id: Long
    ): Response<Unit>

    @POST("compares/{compare_id}/votes")
    suspend fun voteSide(
        @Path("compare_id") id: Long,
        @Body payload: VotePayload
    ): Response<Unit>

}