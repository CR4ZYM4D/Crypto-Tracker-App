package com.plcoding.cryptotracker.crytpo.presentation.coin_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.cryptotracker.crytpo.presentation.models.DisplayableNumber
import com.plcoding.cryptotracker.ui.theme.CryptoTrackerTheme
import com.plcoding.cryptotracker.ui.theme.greenBackground

@Composable
fun priceChange(change : DisplayableNumber , modifier: Modifier = Modifier){
    val contentColor = if(change.value >= 0.0f) {
        Color.Green
    }else{
        MaterialTheme.colorScheme.onErrorContainer
    }

    val backgroundColor = if(change.value >= 0.0f) {
        greenBackground
    }else{
        MaterialTheme.colorScheme.errorContainer
    }

    Row(modifier = modifier
        .clip(shape = RoundedCornerShape(100f))
        .background(backgroundColor)
        .padding(horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(imageVector = if(change.value >=0.0f){
                Icons.Default.KeyboardArrowUp }
                else{Icons.Default.KeyboardArrowDown},
            contentDescription = null,
            tint = contentColor,
            modifier = modifier.size(25.dp)
        )
        Text(text = "${change.formattedValue} %" ,
            color = contentColor,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
    }

}

@PreviewLightDark
@Composable
private fun priceChangePreview(){
    CryptoTrackerTheme {
        priceChange(change = DisplayableNumber(value = 10.0f ,
            formattedValue = "-10.0 %"))
    }
}