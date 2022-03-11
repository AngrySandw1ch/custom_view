package ru.netology.singlealbumapp.repository

import ru.netology.singlealbumapp.dto.Track

interface TrackRepository {
    fun getTracks(callback: GetTracksCallBack){}

    interface GetTracksCallBack {
        fun onSuccess(tracks: List<Track>) {}
        fun onError(e: Exception) {}
    }
}