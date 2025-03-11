package com.plcoding.cryptotracker.crytpo.presentation.coin_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.cryptotracker.crytpo.domain.Coin
import com.plcoding.cryptotracker.crytpo.presentation.models.CoinUi
import com.plcoding.cryptotracker.crytpo.presentation.models.toCoinUi
import com.plcoding.cryptotracker.ui.theme.CryptoTrackerTheme

@Composable
fun coinListItem(
        coinUI: CoinUi,
        onclick:()->Unit,
        modifier:Modifier = Modifier
    )
{

    Row (modifier = modifier
        .clickable(onClick = onclick)
        .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){

        Icon( imageVector = ImageVector.vectorResource(id= coinUI.iconResource),
            contentDescription = coinUI.name,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(85.dp)
        )

        Column (
            modifier = Modifier.weight(1f) // provides the row column the entire remaining row
        ){
            Text(text = coinUI.symbol ,
                color = MaterialTheme.colorScheme.onSurface ,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = coinUI.name ,
                color = MaterialTheme.colorScheme.onSurface ,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )
        }
        Column (
            horizontalAlignment = Alignment.End
        ){
            Text(text = "$ ${ coinUI.priceUSD.formattedValue }",
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            priceChange(change = coinUI.changePercent24Hr)
        }
    }
}

@PreviewLightDark
@Composable
private fun coinListItemPreview(){
    CryptoTrackerTheme {
        coinListItem(coinUI = previewCoin.toCoinUi() , onclick = {} ,
            modifier = Modifier.background(MaterialTheme.colorScheme.background))
    }
}

internal val previewCoin = Coin(

    id= "bitcoin",
    symbol="BTC",
    name="Bitcoin",
    rank =1,
    marketCapUSD = 100.0f,
    priceUSD = 100.0f,
    changePercent24Hr = 0.0f

)