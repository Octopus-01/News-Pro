package com.octelspace.newspro.domain.repository

import androidx.paging.PagingData
import com.octelspace.newspro.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepositroy {
    fun getNews(sources: List<String>): Flow<PagingData<Article>>
}