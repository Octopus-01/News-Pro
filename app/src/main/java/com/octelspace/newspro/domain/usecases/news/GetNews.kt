package com.octelspace.newspro.domain.usecases.news

import androidx.paging.PagingData
import com.octelspace.newspro.domain.model.Article
import com.octelspace.newspro.domain.repository.NewsRepositroy
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepositroy: NewsRepositroy
    //private val appEntryUseCases: AppEntryUseCases

) {
    operator fun invoke(sources: List<String>) : Flow<PagingData<Article>>{
        return newsRepositroy.getNews(sources = sources)

    }
}