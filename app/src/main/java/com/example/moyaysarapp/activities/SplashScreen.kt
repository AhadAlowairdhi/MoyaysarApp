package com.example.moyaysarapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.moyaysarapp.R
import com.example.moyaysarapp.classes.PaymentsAdapter

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar?.hide()

        Handler().postDelayed({
            val intent = Intent(this, SigninActivity::class.java)
            startActivity(intent)
            finish() // to avoid back button work
        },3000)
    }
}