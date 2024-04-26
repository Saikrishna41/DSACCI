package com.dev.ojamee

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import gr.net.maroulis.library.EasySplashScreen

class SplashScreen : AppCompatActivity() {

    private val SPLASH_TIME_OUT : Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler().postDelayed({
            movetoNextSection()
        },SPLASH_TIME_OUT)
    }


    fun movetoNextSection() {
//        val config = EasySplashScreen(this)
//            .withFullScreen()
//            .withTargetActivity(MainActivity::class.java)
//            .withSplashTimeOut(3000)
//            .withBackgroundColor(Color.parseColor("#FFFFFF"))
//            .withHeaderText("Ojamee")
//            .withLogo(R.drawable.truck)
//
//        config.headerTextView.setTextColor(Color.BLUE)
//
//
//
//        val easySplashScreen : View = config.create()

        val mainActIntent = Intent(this,LoginRegisterActivity::class.java)
        startActivity(mainActIntent)
        this.finish()

    }
}