 package com.octelspace.newspro.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.octelspace.newspro.domain.model.Article
import com.octelspace.newspro.domain.model.Source

class NewPagingSource(
    private val newsApi : NewApi,
    private val source : String
) : PagingSource<Int, Article>(){
    private var totalNewsCount = 0
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorePosition ->
            val anchorePage = state.closestPageToPosition(anchorePosition)
            anchorePage?.prevKey?.plus(1) ?: anchorePage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?: 1
        return try {
            val newsResponse = newsApi.getNews(
                sources = source, page = page,
            )
            totalNewsCount += newsResponse.articles.size
            val articles = newsResponse.articles.distinctBy { it.title }
            LoadResult.Page(
                data = articles,
                nextKey = if (totalNewsCount == newsResponse.totalResults) null else page + 1,
                prevKey = null
            )
        }catch (e : Exception){
            e.printStackTrace()
            LoadResult.Error(
                throwable = e
            )
        }
    }

}