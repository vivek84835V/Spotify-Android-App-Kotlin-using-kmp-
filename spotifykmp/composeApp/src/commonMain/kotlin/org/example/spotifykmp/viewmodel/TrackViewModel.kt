package org.example.spotifykmp.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import org.example.spotifykmp.model.Track
import org.example.spotifykmp.repository.TrackRepository

class TrackViewModel(
    private val repository: TrackRepository = TrackRepository()
) {

    private val _tracks = mutableStateOf<List<Track>>(emptyList())
    val tracks: State<List<Track>> = _tracks

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    suspend fun loadTracks(): List<Track> {
        _isLoading.value = true

        val result = repository.fetchTracks()

        _tracks.value = result
        _isLoading.value = false

        return result
    }
}
