package com.plcoding.cryptotracker.crytpo.presentation.coin_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.plcoding.cryptotracker.crytpo.presentation.coin_list.components.coinListItem
import com.plcoding.cryptotracker.crytpo.presentation.coin_list.components.previewCoin
import com.plcoding.cryptotracker.crytpo.presentation.models.toCoinUi
import com.plcoding.cryptotracker.ui.theme.CryptoTrackerTheme

@Composable
fun coinListScreen(modifier :Modifier = Modifier , state: CoinListState){

    if(state.isLoading){
        Box(modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
    else{
        LazyColumn (modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)){
            items(state.coin){
                coinUi ->
                coinListItem(coinUI = coinUi ,
                    onclick={} ,
                    modifier = Modifier.fillMaxWidth()
                )
                HorizontalDivider()
            }
        }
    }

}


@PreviewLightDark
@Composable
private fun coinListScreenPreview(){
    CryptoTrackerTheme {
        coinListScreen(state = CoinListState
            (coin = (1..50)
                .map{ previewCoin.toCoinUi()
                    .copy(id = it.toString())
                }
            ),
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        )
    }
}