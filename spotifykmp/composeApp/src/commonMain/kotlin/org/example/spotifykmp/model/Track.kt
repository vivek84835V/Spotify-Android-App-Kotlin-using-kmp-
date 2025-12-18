package org.example.spotifykmp.model
import kotlinx.serialization.Serializable

@Serializable
data class Track (
    val id: String,
    val name: String,
    val artist_name: String,
    val album_name: String,
    val image: String,
    val audio: String,
    val duration: Int
)