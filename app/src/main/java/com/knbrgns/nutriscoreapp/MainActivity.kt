package com.knbrgns.nutriscoreapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.knbrgns.nutriscoreapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var keepSplashScreen = true
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition { keepSplashScreen }

        super.onCreate(savedInstanceState)

        inflateActivity()
        navigationSetup()
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

    private fun navigationSetup(){
        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}