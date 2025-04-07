package com.knbrgns.nutriscoreapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.databinding.DataBindingUtil
import com.knbrgns.nutriscoreapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var keepSplashScreen = true
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition { keepSplashScreen }

        super.onCreate(savedInstanceState)

        inflateActivity()
        splashHandler()
    }

    private fun inflateActivity(){
        val view = R.layout.activity_main
        binding = DataBindingUtil.setContentView(this, view)
    }

    private fun splashHandler(){
        Handler(Looper.getMainLooper()).postDelayed({
            keepSplashScreen = false
        }, 2500)
    }
}