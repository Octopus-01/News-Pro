package com.octelspace.newspro.data.mamager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStoreFile
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.octelspace.newspro.domain.manager.LocalUserManager
import com.octelspace.newspro.utils.Constants.APP_ENTRY
import com.octelspace.newspro.utils.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserManagerImp(
    private val context: Context) :LocalUserManager{
    override suspend fun saveAppEntry() {
        context.dataStore.edit {
            settings ->
            settings[PreferencesKeys.App_Enrty] = true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map {
            preferences ->
            preferences[PreferencesKeys.App_Enrty] ?: false
        }
    }

}

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)
private object PreferencesKeys{
    val App_Enrty = booleanPreferencesKey(name = APP_ENTRY)
}