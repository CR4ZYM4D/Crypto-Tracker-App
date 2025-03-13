package com.plcoding.cryptotracker.crytpo.domain

import com.plcoding.cryptotracker.crytpo.core.domain.util.NetworkError
import com.plcoding.cryptotracker.crytpo.core.domain.util.Result

interface CoinDataSource {

    suspend fun getCoins(): Result<List<Coin> , NetworkError>

}