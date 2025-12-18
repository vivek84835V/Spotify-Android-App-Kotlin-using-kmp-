package org.example.spotifykmp.network

import io.ktor.client.call.*
import io.ktor.client.request.*
import org.example.spotifykmp.model.Track
import org.example.spotifykmp.model.TrackResponse

class TrackApi {

    suspend fun getsongs(): List<Track> {
        val response: TrackResponse =
            KtorClient.client.get("https://api.jamendo.com/v3.0/tracks/") {
                parameter("client_id", "ef4e030c")
                parameter("format", "json")
                parameter("limit", 20)
            }.body()
        return response.results
    }
}