package com.octelspace.newspro.domain.usecases

import android.app.LocaleManager

class SaveAppEntry(
    private val localUserManager: LocaleManager
) {
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()

    }
}