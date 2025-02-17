package com.octelspace.newspro.domain.usecases.news

import com.octelspace.newspro.data.local.NewsDao
import com.octelspace.newspro.domain.model.Article

class DeleteArticle(
    private val newsDao: NewsDao
) {
    suspend operator fun invoke(article: Article){
        newsDao.delete(article)
    }
}