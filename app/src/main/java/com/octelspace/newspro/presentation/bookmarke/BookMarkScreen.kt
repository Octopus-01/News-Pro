package com.octelspace.newspro.presentation.bookmarke

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import com.octelspace.newspro.R
import com.octelspace.newspro.presentation.common.ArticleList
import com.octelspace.newspro.presentation.navgraph.Routs
import com.octelspace.newspro.presentation.onboarding.Dimention.MediumPadding1

@Composable
fun BookMarkScreen(
    state: BookMarkState,
    navigate :(String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(top = MediumPadding1, start = MediumPadding1, end = MediumPadding1)
    ) {
        Text(
            text = "BookMark",
            style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.text_title)
        )

        Spacer(modifier = Modifier.height(MediumPadding1))

        ArticleList(articles = state.articles, onClick = {navigate(Routs.DetailsScreen.routs)})
    }
}