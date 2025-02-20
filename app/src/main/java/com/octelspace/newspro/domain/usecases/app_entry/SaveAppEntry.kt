package com.octelspace.newspro.domain.usecases.app_entry

import com.octelspace.newspro.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()

    }
}