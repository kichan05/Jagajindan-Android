package com.heechan.jagajindan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.heechan.jagajindan.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    lateinit var binding : ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)


        with(binding){
            btnRegisterSubmit.setOnClickListener {
                val inputName = edtRegisterInputName.text.toString()

                val intent = Intent(this@RegisterActivity, MainActivity::class.java).apply {
                    putExtra("name", inputName)
                }

                startActivity(intent)
            }
        }
    }
}