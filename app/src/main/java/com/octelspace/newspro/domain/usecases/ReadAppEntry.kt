package com.octelspace.newspro.domain.usecases

import com.octelspace.newspro.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {
    operator fun invoke(): Flow<Boolean>{
        return localUserManager.readAppEntry()
    }
}