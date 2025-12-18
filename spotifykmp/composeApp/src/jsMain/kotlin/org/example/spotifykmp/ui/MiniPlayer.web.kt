package org.example.spotifykmp

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import kotlinx.browser.document
import org.example.spotifykmp.model.Track
import org.w3c.dom.HTMLAudioElement

@Composable
fun MiniPlayer(track: Track?) {

    if (track == null) return

    var audio by remember { mutableStateOf<HTMLAudioElement?>(null) }
    var isPlaying by remember { mutableStateOf(true) }

    LaunchedEffect(track) {
        audio?.pause()
        audio = document.createElement("audio") as HTMLAudioElement
        audio!!.src = track.audio
        audio!!.play()
        isPlaying = true
    }

    Button(
        onClick = {
            if (isPlaying) audio?.pause() else audio?.play()
            isPlaying = !isPlaying
        }
    ) {
        Text(
            if (isPlaying) "Pause" else "Play"
        )
    }
}
