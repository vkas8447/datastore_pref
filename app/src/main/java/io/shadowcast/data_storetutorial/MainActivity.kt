package io.shadowcast.data_storetutorial

import android.app.appsearch.GlobalSearchSession
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.UserData
import android.widget.Toast
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

import io.shadowcast.data_storetutorial.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var dataStore: DataStorePreferenceHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataStore = DataStorePreferenceHelper(this)


        binding.button.setOnClickListener{
            val name = "kumar"
            val value = "value"


            GlobalScope.launch(Dispatchers.Main) {
                dataStore.putKey("username",true)
                dataStore.putKey("name","vikas")
                dataStore.putKey("number",8447)
                Toast.makeText(applicationContext,"saved",Toast.LENGTH_SHORT).show()
            }

        }

        binding.button2.setOnClickListener{
            GlobalScope.launch(Dispatchers.Main) {
                Toast.makeText(applicationContext, dataStore.getIntKey("number"),Toast.LENGTH_SHORT).show()
            }
        }
    }



}