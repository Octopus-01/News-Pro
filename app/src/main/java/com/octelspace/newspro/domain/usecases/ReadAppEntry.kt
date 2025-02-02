package com.octelspace.newspro.domain.usecases

import android.app.LocaleManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManager: LocaleManager
) {
    suspend operator fun invoke(): Flow<Boolean>{
        return localUserManager.readAppEntry()

    }
}