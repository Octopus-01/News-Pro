package com.octelspace.newspro.data.remote.dto

import com.octelspace.newspro.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)