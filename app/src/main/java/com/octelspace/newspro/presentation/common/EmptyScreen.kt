package com.octelspace.newspro.presentation.common

import android.os.Message
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import com.octelspace.newspro.R
import java.net.ConnectException
import java.net.SocketTimeoutException

@Composable
fun EmptyScreen(error : LoadState.Error? = null){
    var message by remember {
        mutableStateOf(parseErrorMessage(error = error))
    }

    var icon by remember {
        mutableStateOf(R.drawable.ic_network_error)
    }

    if (error == null){
        message = "You have not save news so far !"
        icon = R.drawable.ic_network_error
    }

    var startAnimation by remember {
        mutableStateOf(false)
    }

    val alphaAnimation by animateFloatAsState(
        targetValue = if(startAnimation) 0.3f else 0f,
        animationSpec = tween(durationMillis = 1000)
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
    }

    EmptyContent(alphaanim = alphaAnimation, message = message, iconid = icon)

}

@Composable
fun EmptyContent(alphaanim : Float, message: String, iconid: Int){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = iconid),
            contentDescription = null,
            tint = if(isSystemInDarkTheme()) LightGray else DarkGray,
            modifier = Modifier
                .size(120.dp)
                .alpha(alphaanim)
        )

        Text(
            modifier = Modifier
                .padding(10.dp)
                .alpha(alphaanim),
            text = message,
            style = MaterialTheme.typography.bodyMedium,
            color = if(isSystemInDarkTheme()) LightGray else DarkGray
        )
    }
}



fun parseErrorMessage(error: LoadState.Error?): String {
    return when (error?.error) {
        is SocketTimeoutException ->{
            "Server is not responding"
        }

        is ConnectException -> {
            "Internet is not available"
        }

        else ->{
            "Unknown Error"
        }
    }
}
