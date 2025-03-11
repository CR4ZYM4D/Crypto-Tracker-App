package com.plcoding.cryptotracker.crytpo.domain

data class Coin(

    val id : String,
    val name:String,
    val symbol:String,
    val rank: Int,
    val marketCapUSD: Float,
    val priceUSD: Float,
    val changePercent24Hr: Float

)
