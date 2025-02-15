package com.octelspace.newspro.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.octelspace.newspro.data.remote.NewsApi
import com.octelspace.newspro.data.remote.NewPagingSource
import com.octelspace.newspro.domain.model.Article
import com.octelspace.newspro.domain.repository.NewsRepositroy
import kotlinx.coroutines.flow.Flow

class NewsRepositoryimpl(
    private val newsApi: NewsApi
): NewsRepositroy
{
    override fun getNews(sources: List<String>): Flow<PagingData<Article>>   {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewPagingSource(
                    newsApi = newsApi,
                    source = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }
}