package com.plcoding.cryptotracker.crytpo.presentation.coin_list

import com.plcoding.cryptotracker.crytpo.presentation.models.CoinUi

interface CoinListAction {

    data class OnCoinClick(
        val coinUI:CoinUi
    ):CoinListAction

    data object onRefresh:CoinListAction
}