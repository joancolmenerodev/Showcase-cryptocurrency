package com.joancolmenerodev.showcase_kotlin

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.joancolmenerodev.crypto_list.CryptoListActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        makeFullScreen()

        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            startActivity(Intent(this, CryptoListActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }, TIME_TO_WAIT_SPLASH_SCREEN)
    }

    private fun makeFullScreen() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        supportActionBar?.hide()
    }
}

private const val TIME_TO_WAIT_SPLASH_SCREEN = 2000L
