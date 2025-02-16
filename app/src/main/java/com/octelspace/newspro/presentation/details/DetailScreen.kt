package com.octelspace.newspro.presentation.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.octelspace.newspro.domain.model.Article
import com.octelspace.newspro.presentation.details.component.DetailTopBar

@Composable
fun DetailScreen(
    article: Article,
    event: (DetailEvent) -> Unit,
    navigateup : () -> Unit
){
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        DetailTopBar(
            onBrowseClick = { /*TODO*/ },
            onBackClick = { navigateup() },
            onShareClick = { /*TODO*/ },
            onBookMarkClick = { /*TODO*/ }
        )
    }

}