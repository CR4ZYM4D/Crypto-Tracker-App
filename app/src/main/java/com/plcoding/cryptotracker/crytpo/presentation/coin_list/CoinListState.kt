package com.plcoding.cryptotracker.crytpo.presentation.coin_list

import androidx.compose.runtime.Immutable
import com.plcoding.cryptotracker.crytpo.presentation.models.CoinUi


@Immutable
data class CoinListState(

    val isLoading :Boolean = false,
    val coin : List<CoinUi> = emptyList(),
    val selectedCoin : CoinUi? = null

)
