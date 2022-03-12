package ru.netology.singlealbumapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.netology.singlealbumapp.dto.Track
import ru.netology.singlealbumapp.repository.TrackRepository
import ru.netology.singlealbumapp.repository.TrackRepositoryImpl

class TrackViewModel: ViewModel() {
    private val repository: TrackRepository = TrackRepositoryImpl()
    private val _data = MutableLiveData<List<Track>>()
    val data: LiveData<List<Track>>
        get() = _data

    init {
        getTracks()
    }

    private fun getTracks() {
        repository.getTracks(object: TrackRepository.GetTracksCallBack{
            override fun onSuccess(tracks: List<Track>) {
                _data.postValue(tracks)
            }
        })
    }
}