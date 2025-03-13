package com.plcoding.cryptotracker.crytpo.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class CoinResponseDTO(
    val data:List<CoinDTO>
)
