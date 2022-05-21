package com.heechan.jagajindan.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import com.heechan.jagajindan.R
import com.heechan.jagajindan.data.DataStoreModule
import com.heechan.jagajindan.databinding.ActivityRegisterBinding
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {
    lateinit var binding : ActivityRegisterBinding
    lateinit var dataStore : DataStoreModule

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)

        dataStore = DataStoreModule(this)

        lifecycleScope.launch {
            dataStore.username.asLiveData().observe(this@RegisterActivity){
                if(it.isNotEmpty()) gotoMain(it, true)
            }
        }

        with(binding){
            btnRegisterSubmit.setOnClickListener {
                gotoMain(edtRegisterInputName.text.toString(), false)
            }
        }
    }

    private fun gotoMain(name : String, isSave : Boolean){
        val intent = Intent(this@RegisterActivity, MainActivity::class.java).apply {
            putExtra("username", name)
        }
        startActivity(intent)
        overridePendingTransition(R.anim.anim_side_right, R.anim.anim_fade_out);

        if(!isSave)
            lifecycleScope.launch {
                dataStore.setName(this@RegisterActivity, name)
                finish()
            }
        else
            finish()
    }
}