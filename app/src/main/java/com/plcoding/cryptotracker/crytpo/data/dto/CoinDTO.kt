package com.plcoding.cryptotracker.crytpo.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class CoinDTO(

    val id:String,
    val name:String,
    val rank:Int,
    val symbol:String,
    val marketCapUsd:Double,
    val priceUsd:Double,
    val changePercent24Hr:Double

)
