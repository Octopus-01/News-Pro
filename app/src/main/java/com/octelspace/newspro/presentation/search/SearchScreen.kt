package com.octelspace.newspro.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.octelspace.newspro.presentation.common.ArticleList
import com.octelspace.newspro.presentation.common.SearchBar
import com.octelspace.newspro.presentation.navgraph.Routs
import com.octelspace.newspro.presentation.onboarding.Dimention.MediumPadding1

@Composable
fun SearchScreen(
    state: SearchState,
    event: (SearchEvent) -> Unit,
    navigate:(String) -> Unit,

){
    Column(
        modifier = Modifier.padding(
            top = MediumPadding1,
            start = MediumPadding1,
            end = MediumPadding1
        )
            .statusBarsPadding()
            .fillMaxSize()
    ) {
        SearchBar(
            text = state.searchQuery,
            readOnly = false,
            onValueChange = {event(SearchEvent.UpdateSearchQuery(it))},
            onSearch = {event(SearchEvent.SearchNews)}
        )
        Spacer(modifier = Modifier.height(MediumPadding1))

        state.articles?.let {
            val articles = it.collectAsLazyPagingItems()
            ArticleList(
                articles = articles,
                onClick = {
                    navigate(Routs.DetailsScreen.routs)
                }
            )
        }
    }
}