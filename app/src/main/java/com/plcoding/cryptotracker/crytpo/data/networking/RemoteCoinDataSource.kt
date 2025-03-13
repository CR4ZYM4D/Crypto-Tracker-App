package com.plcoding.cryptotracker.crytpo.data.networking

import com.plcoding.cryptotracker.crytpo.core.data.networking.constructURL
import com.plcoding.cryptotracker.crytpo.core.data.networking.safeCall
import com.plcoding.cryptotracker.crytpo.core.domain.util.NetworkError
import com.plcoding.cryptotracker.crytpo.core.domain.util.Result
import com.plcoding.cryptotracker.crytpo.core.domain.util.map
import com.plcoding.cryptotracker.crytpo.data.dto.CoinResponseDTO
import com.plcoding.cryptotracker.crytpo.data.mapper.toCoin
import com.plcoding.cryptotracker.crytpo.domain.Coin
import com.plcoding.cryptotracker.crytpo.domain.CoinDataSource
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class RemoteCoinDataSource(

    private val httpClient: HttpClient

) :CoinDataSource{

    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinResponseDTO> {
            httpClient.get(urlString = constructURL("/assets"))
        }
         .map{response -> response.data.map{it.toCoin()}}
    }

}