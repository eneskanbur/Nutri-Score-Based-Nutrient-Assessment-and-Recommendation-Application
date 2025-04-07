package com.knbrgns.nutriscoreapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {
    private var keepSplashScreen = true

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition { keepSplashScreen }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        splashHandler()
    }

    private fun splashHandler(){
        Handler(Looper.getMainLooper()).postDelayed({
            keepSplashScreen = false
        }, 2500)
    }
}