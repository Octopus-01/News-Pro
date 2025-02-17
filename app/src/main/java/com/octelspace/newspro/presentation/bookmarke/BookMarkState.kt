package com.octelspace.newspro.presentation.bookmarke

import com.octelspace.newspro.domain.model.Article

data class BookMarkState(
    val articles: List<Article> = emptyList(),
)
