package com.example.emtwnty

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        iv_logo_splash.animate()
            .alpha(1f)
            .setDuration(1500)
            .setListener( object : AnimatorListenerAdapter(){
                override fun onAnimationEnd(animation: Animator?) {
                    tv_greeting_splash.animate()
                        .alpha(1f)
                        .setDuration(2500)
                        .setListener(object : AnimatorListenerAdapter(){
                            override fun onAnimationEnd(animation: Animator?) {
                                delay()
                            }
                        })
                }
            })
    }
    fun delay(){
        val handle = Handler()
        handle.postDelayed({
            val intent = Intent(this, WalkthrougActivity::class.java)
            startActivity(intent)
            finish()
        },1000)
    }
}
