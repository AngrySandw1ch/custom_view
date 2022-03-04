package ru.netology.customview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import ru.netology.customview.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val view = findViewById<StatsView>(R.id.stats)
        view.postDelayed({
            view.data = listOf(
                500f,
                500f,
                500f,
                500f
            )

                view.animate()
                .rotation(360F)
                .setDuration(2100)
                .start()
        },3000L)
    }
}