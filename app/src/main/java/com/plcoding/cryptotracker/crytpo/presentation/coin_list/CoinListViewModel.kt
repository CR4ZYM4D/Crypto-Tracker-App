package com.plcoding.cryptotracker.crytpo.presentation.coin_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.cryptotracker.crytpo.core.domain.util.onError
import com.plcoding.cryptotracker.crytpo.core.domain.util.onSuccess
import com.plcoding.cryptotracker.crytpo.domain.CoinDataSource
import com.plcoding.cryptotracker.crytpo.presentation.models.toCoinUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CoinListViewModel(private val coinDataSource: CoinDataSource):ViewModel() {
    private val _state = MutableStateFlow(CoinListState())
    val state = _state
        .onStart { loadCoins() }
        .stateIn(viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            CoinListState()
        )

    private fun loadCoins(){
        viewModelScope.launch{
            _state.update { it.copy(isLoading = true) }

            coinDataSource.getCoins()
                .onSuccess { coins-> _state.update{it.copy(
                        isLoading = false,
                        coin = coins.map {it.toCoinUi()}
                    )}
                }
                .onError { error-> _state.update{it.copy(isLoading=false)}
                }
        }
    }

    fun onAction(action : CoinListAction){

        when(action){
            is CoinListAction.OnCoinClick->{}
            CoinListAction.onRefresh->{
                loadCoins()
            }
        }

    }
}