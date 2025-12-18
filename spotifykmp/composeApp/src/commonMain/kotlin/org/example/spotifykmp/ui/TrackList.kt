package org.example.spotifykmp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.unit.dp
import org.example.spotifykmp.model.Track

@Composable
fun TrackList(
    tracks: List<Track>,
    playingTrack: Track?,
    onClick: (Track) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.padding(8.dp)
    ) {
        items(tracks) { track ->
            TrackItem(
                track = track,
                isPlaying = track == playingTrack,
                onClick = { onClick(track) }
            )
        }
    }
}

