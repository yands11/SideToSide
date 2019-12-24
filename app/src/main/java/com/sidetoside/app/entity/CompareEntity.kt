package com.sidetoside.app.entity

import com.google.gson.annotations.SerializedName


data class Compare(
    val id: Long,
    val title: String,
    val user: User,
    @SerializedName("created_at") val createdAt: String,
    val left: Side,
    val right: Side
)

data class Side(
    val name: String,
    val image: String,
    val count: Int
)

data class User(
    val id: Long,
    val name: String,
    @SerializedName("photo_url") val photoUrl: String
)

data class Comment(
    val id: Long,
    val user: User,
    @SerializedName("side_type") val sideType: String,
    val contents: String,
    @SerializedName("created_at") val createdAt: String
)

data class ComparePayload(
    val title: String,
    @SerializedName("user_id") val userId: Long = 1, // temp
    val left: SidePayload,
    val right: SidePayload
)

data class SidePayload(
    val name: String,
    @SerializedName("photo_url") val photoUrl: String
)

data class VotePayload(
    @SerializedName("user_id") val userId: Long = 1, // temp
    @SerializedName("side_type") val sideType: String
)
