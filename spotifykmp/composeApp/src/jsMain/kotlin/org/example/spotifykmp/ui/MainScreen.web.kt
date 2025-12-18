package org.example.spotifykmp

import androidx.compose.runtime.*
import org.example.spotifykmp.model.Track
import org.example.spotifykmp.ui.Header
import org.example.spotifykmp.ui.LoadingView
import org.example.spotifykmp.ui.TrackList
import org.example.spotifykmp.viewmodel.TrackViewModel

@Composable
fun MainScreen() {

    val viewModel = remember { TrackViewModel() }

    val tracks by viewModel.tracks
    val isLoading by viewModel.isLoading
    var selectedTrack by remember { mutableStateOf<Track?>(null) }

    LaunchedEffect(Unit) {
        viewModel.loadTracks()
    }

    Header(
        isChecked = false,
        onCheckedChange = {}
    )

    if (isLoading) {
        LoadingView()
    } else {
        TrackList(
            tracks = tracks,
            playingTrack = selectedTrack,
            onClick = { selectedTrack = it }
        )
    }

    MiniPlayer(track = selectedTrack)
}
