package com.heechan.jagajindan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import androidx.databinding.DataBindingUtil
import com.heechan.jagajindan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding;

    var BASE_URL = "https://jagajindan.netlify.app/?username=박희찬"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.wvMain.apply {
            settings.javaScriptEnabled = true
            loadUrl(BASE_URL)
//            webChromeClient = WebChromeClient()
        }

    }
}