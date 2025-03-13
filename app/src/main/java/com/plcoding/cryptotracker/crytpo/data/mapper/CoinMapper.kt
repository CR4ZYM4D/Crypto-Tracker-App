package com.plcoding.cryptotracker.crytpo.data.mapper

import com.plcoding.cryptotracker.crytpo.data.dto.CoinDTO
import com.plcoding.cryptotracker.crytpo.domain.Coin

fun CoinDTO.toCoin() :Coin{

    return Coin(
        id = id,
        name = name,
        symbol = symbol,
        rank = rank,
        marketCapUSD = marketCapUsd.toFloat(),
        priceUSD = priceUsd.toFloat(),
        changePercent24Hr = changePercent24Hr.toFloat()
    )

}