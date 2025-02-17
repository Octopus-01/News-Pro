package com.octelspace.newspro.domain.usecases.news

import com.octelspace.newspro.data.local.NewsDao
import com.octelspace.newspro.domain.model.Article
import kotlinx.coroutines.flow.Flow

class SelectArticle(
    private val newsDao: NewsDao
) {
     operator fun invoke(): Flow<List<Article>>{
        return newsDao.getArticles()
    }
}