package com.plcoding.cryptotracker.di

import com.plcoding.cryptotracker.crytpo.core.data.networking.HTTPClientFactory
import com.plcoding.cryptotracker.crytpo.data.networking.RemoteCoinDataSource
import com.plcoding.cryptotracker.crytpo.domain.CoinDataSource
import com.plcoding.cryptotracker.crytpo.presentation.coin_list.CoinListViewModel

import io.ktor.client.engine.cio.CIO
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {

    single { HTTPClientFactory.createHTTPClient(CIO.create()) }
    singleOf(::RemoteCoinDataSource).bind<CoinDataSource>()

    viewModelOf(::CoinListViewModel)
}