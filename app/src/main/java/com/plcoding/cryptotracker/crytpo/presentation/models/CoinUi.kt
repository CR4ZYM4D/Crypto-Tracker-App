package com.plcoding.cryptotracker.crytpo.presentation.models

import android.icu.number.NumberFormatter
import android.icu.text.NumberFormat
import androidx.annotation.DrawableRes
import com.plcoding.cryptotracker.crytpo.domain.Coin
import com.plcoding.cryptotracker.util.getDrawableIdForCoin
import java.util.Locale

data class CoinUi(

    val name: String,
    val id: String,
    val symbol: String,
    val rank: Int,
    val marketCapUSD: DisplayableNumber,
    val priceUSD: DisplayableNumber,
    val changePercent24Hr: DisplayableNumber,
    @DrawableRes val iconResource: Int

)

data class DisplayableNumber(

    val value: Float,
    val formattedValue: String

)

fun Coin.toCoinUi() : CoinUi{
    return CoinUi(

        id = id,
        name = name,
        symbol = symbol,
        rank = rank,
        marketCapUSD = marketCapUSD.toDisplayableNumber(),
        priceUSD = priceUSD.toDisplayableNumber(),
        changePercent24Hr = changePercent24Hr.toDisplayableNumber(),
        iconResource = getDrawableIdForCoin(symbol)
    )
}

fun Float.toDisplayableNumber() :DisplayableNumber{
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault()).apply{
        minimumFractionDigits = 2
        maximumFractionDigits = 2
    }
    return DisplayableNumber(
        value = this,
        formattedValue = formatter.format(this)
    )
}
