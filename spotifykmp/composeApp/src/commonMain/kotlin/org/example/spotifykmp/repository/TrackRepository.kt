package org.example.spotifykmp.repository


import org.example.spotifykmp.model.Track
import org.example.spotifykmp.network.TrackApi

class TrackRepository(private val api: TrackApi = TrackApi()){

        suspend fun fetchTracks(): List<Track> {
            return api.getsongs()
        }
}