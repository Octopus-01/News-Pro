package com.octelspace.newspro.di

import android.app.Application
import com.octelspace.newspro.data.mamager.LocalUserManagerImp
import com.octelspace.newspro.domain.manager.LocalUserManager
import com.octelspace.newspro.domain.usecases.app_entry.AppEntryUseCases
import com.octelspace.newspro.domain.usecases.app_entry.ReadAppEntry
import com.octelspace.newspro.domain.usecases.app_entry.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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


}