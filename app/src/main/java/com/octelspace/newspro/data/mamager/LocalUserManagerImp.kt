package com.octelspace.newspro.data.mamager

import android.content.Context
import androidx.datastore.dataStoreFile
import com.octelspace.newspro.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class LocalUserManagerImp(
    private val context: Context) :LocalUserManager{
    override suspend fun saveAppEntry() {
        TODO("Not yet implemented")
    }

    override suspend fun readAppEntry(): Flow<Boolean> {
        TODO("Not yet implemented")
    }

}