package ru.netology.singlealbumapp

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton
import okhttp3.*
import java.io.IOException
import java.lang.Exception
import java.util.concurrent.TimeUnit

class AppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)

        findViewById<MaterialButton>(R.id.button).setOnClickListener {
            MediaPlayer.create(this, Uri.parse("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3")).start()
        }

        val client = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()

        val request = Request.Builder()
            .url("https://raw.githubusercontent.com/netology-code/andad-homeworks/master/09_multimedia/data/album.json")
            .build()

        client.newCall(request)
            .enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    throw IOException(e)
                }

                override fun onResponse(call: Call, response: Response) {
                    if (!response.isSuccessful) {
                        throw IOException("Api error")
                    }
                    val body = response.body?.string() ?: throw Exception("body is null")
                }

            })

    }
}