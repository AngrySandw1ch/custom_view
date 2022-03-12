package ru.netology.singlealbumapp.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.netology.singlealbumapp.R
import ru.netology.singlealbumapp.adapter.TrackAdapter
import ru.netology.singlealbumapp.databinding.ActivityAppBinding
import ru.netology.singlealbumapp.viewmodel.TrackViewModel

class AppActivity : AppCompatActivity() {
    lateinit var binding: ActivityAppBinding
    lateinit var viewModel: TrackViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
        binding = ActivityAppBinding.inflate(layoutInflater)
        viewModel = defaultViewModelProviderFactory.create(TrackViewModel::class.java)

       // findViewById<MaterialButton>(R.id.button).setOnClickListener {
      //      MediaPlayer.create(this, Uri.parse("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3")).start()
      //  }
        val adapter = TrackAdapter()
        binding.recycler.adapter = adapter
        adapter.submitList(viewModel.data.value)
        viewModel.data.observe(this) {
            adapter.submitList(it)
        }
    }
}