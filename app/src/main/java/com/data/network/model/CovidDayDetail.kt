package com.data.network.model

data class CovidDayDetails(
    val country: String,
    val date: String,
    val total: Int,
    val new: Int
)

