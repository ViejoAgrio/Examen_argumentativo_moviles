package com.data.network.model

data class ModelCovid(
    val country: String,
    val region: String,
    val cases: Map<String, CaseDetails>
)
