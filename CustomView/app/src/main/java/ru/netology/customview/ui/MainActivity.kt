package ru.netology.customview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.netology.customview.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<StatsView>(R.id.stats).data = listOf(500f, 500f, 500f, 500f)
    }
}