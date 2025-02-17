package com.octelspace.newspro.di

import android.app.Application
import androidx.room.Room
import com.octelspace.newspro.data.local.NewsDao
import com.octelspace.newspro.data.local.NewsDatabase
import com.octelspace.newspro.data.local.NewsTypeConvertor
import com.octelspace.newspro.data.mamager.LocalUserManagerImp
import com.octelspace.newspro.data.remote.NewsApi
import com.octelspace.newspro.data.remote.repository.NewsRepositoryimpl
import com.octelspace.newspro.domain.manager.LocalUserManager
import com.octelspace.newspro.domain.repository.NewsRepositroy
import com.octelspace.newspro.domain.usecases.app_entry.AppEntryUseCases
import com.octelspace.newspro.domain.usecases.app_entry.ReadAppEntry
import com.octelspace.newspro.domain.usecases.app_entry.SaveAppEntry
import com.octelspace.newspro.domain.usecases.news.DeleteArticle
import com.octelspace.newspro.domain.usecases.news.GetNews
import com.octelspace.newspro.domain.usecases.news.NewsUseCases
import com.octelspace.newspro.domain.usecases.news.SearchNews
import com.octelspace.newspro.domain.usecases.news.SelectArticle
import com.octelspace.newspro.domain.usecases.news.UpsertArticle
import com.octelspace.newspro.utils.Constants.BASE_URL
import com.octelspace.newspro.utils.Constants.NEWS_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImp(application)


    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localeManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localeManager),
        saveAppEntry = SaveAppEntry(localeManager)
    )

    @Provides
    @Singleton
    fun provideNewsApi() : NewsApi {
        return  Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ) : NewsRepositroy = NewsRepositoryimpl(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepositroy: NewsRepositroy,
        newsDao: NewsDao
    ) : NewsUseCases{
        return NewsUseCases(
            getNews = GetNews(newsRepositroy),
            searchNews = SearchNews(newsRepositroy),
            upsertArticle = UpsertArticle(newsDao),
            deleteArticle = DeleteArticle(newsDao),
            selectArticle = SelectArticle(newsDao)
        )

    }

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ) : NewsDatabase{
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = NEWS_DATABASE_NAME
        ).addTypeConverter(
            NewsTypeConvertor()
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ):NewsDao = newsDatabase.newsDao

}