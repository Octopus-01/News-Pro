package com.octelspace.newspro.domain.usecases

import android.app.LocaleManager
import com.octelspace.newspro.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()

    }
}