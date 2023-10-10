package com.csarjz.yape.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.csarjz.yape.ui.base.AppNavigation
import com.csarjz.yape.ui.base.BaseScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            BaseScreen {
                AppNavigation()
            }
        }
    }
}
