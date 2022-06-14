package io.shadowcast.data_storetutorial

import android.content.Context
import android.service.autofill.UserData
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore


import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlin.contracts.contract


class DataStorePreferenceHelper(context: Context) {
    private val applicationContext = context.applicationContext

    val Context.dataStore: DataStore<Preferences> by preferencesDataStore("user_preferences")

    suspend fun getKey(key:String): String {
        val key = stringPreferencesKey(key)
        return applicationContext.dataStore.data.first()[key].toString()
    }

    suspend fun getIntKey(key:String): Int {
        val key = stringPreferencesKey(key)
        val data: Int = Integer.parseInt(applicationContext.dataStore.data.first()[key])
        return data
    }

    suspend fun putKey(key:String, value:String){
        val key = stringPreferencesKey(key)
        applicationContext.dataStore.edit {
            it[key] = value
        }
    }

    suspend fun putKey(key:String, value:Boolean){
        val key = stringPreferencesKey(key)
        applicationContext.dataStore.edit {
            it[key] = value.toString()
        }
    }

    suspend fun putKey(key:String, value:Int){
        val key = stringPreferencesKey(key)
        applicationContext.dataStore.edit {
            it[key] = value.toString()
        }
    }

   /* suspend fun putKey(userData:User){
        applicationContext.dataStore.edit {
            it[NAME] = userData.name
            it[VALUE] = userData.value
        }
    }*/


}