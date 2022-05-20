package com.heechan.jagajindan.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class DataStoreModule(private val context : Context) {
    private val Context.dataStore by preferencesDataStore(name = "dataStore")

    private val nameKey = stringPreferencesKey("username")

    val username : Flow<String> = context.dataStore.data
        .map {
            it[this.nameKey] ?: ""
        }

    suspend fun setName(context: Context, name : String) {
        context.dataStore.edit {
            it[nameKey] = name
        }
    }
}