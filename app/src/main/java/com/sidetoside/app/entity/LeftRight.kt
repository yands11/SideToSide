package com.sidetoside.app.entity


data class LeftRight(
    val id: Long,
    val title: String,
    val left: Side,
    val right: Side
)

data class Side(
    val name: String,
    val image: String,
    val count: Int
)
