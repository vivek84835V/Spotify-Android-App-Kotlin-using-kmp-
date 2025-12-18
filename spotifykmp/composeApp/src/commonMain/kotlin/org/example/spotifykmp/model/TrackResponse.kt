package org.example.spotifykmp.model
import kotlinx.serialization.Serializable

@Serializable
data class TrackResponse (
    val results : List<Track>
)