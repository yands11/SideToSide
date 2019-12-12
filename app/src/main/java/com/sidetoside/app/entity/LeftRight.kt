package com.sidetoside.app.entity


data class Compare(
    val id: Long,
    val title: String,
    val user: User,
    val createdAt: String,
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
    val photoUrl: String
)

data class ComparePayload(
    val title: String,
    val left: SidePayload,
    val right: SidePayload
)

data class SidePayload(
    val name: String,
    val photoUrl: String
)
