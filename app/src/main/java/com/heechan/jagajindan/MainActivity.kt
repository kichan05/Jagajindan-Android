package com.heechan.jagajindan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import androidx.databinding.DataBindingUtil
import com.heechan.jagajindan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val URL = "https://jagajindan.netlify.app/?username=${intent.getStringExtra("name")}"

        binding.wvMain.apply {
            settings.javaScriptEnabled = true
            loadUrl(URL)
            webChromeClient = WebChromeClient()
        }

    }
}