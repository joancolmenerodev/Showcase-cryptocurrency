package com.joancolmenerodev.showcase_kotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.joancolmenerodev.feature.crypto_list.presentation.CryptoListActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity(Intent(this, CryptoListActivity::class.java))
        finish()
    }

}

