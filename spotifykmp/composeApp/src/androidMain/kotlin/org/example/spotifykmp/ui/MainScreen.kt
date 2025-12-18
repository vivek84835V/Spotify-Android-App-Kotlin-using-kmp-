package org.example.spotifykmp.ui

import MiniPlayer
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.imageResource
import org.example.spotifykmp.R
import org.example.spotifykmp.model.Track
import org.example.spotifykmp.viewmodel.TrackViewModel

import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale


@Composable
fun MainScreen() {

    val viewModel = remember { TrackViewModel() }

    val tracks by viewModel.tracks
    val isLoading by viewModel.isLoading
    var selectedTrack by remember { mutableStateOf<Track?>(null) }
    var sortByDuration by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        viewModel.loadTracks()
    }

    val sortedTracks = if (sortByDuration) {
        tracks.sortedBy { it.duration }
    } else {
        tracks.sortedByDescending { it.duration }
    }

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(modifier = Modifier.fillMaxSize()) {
            Header(
                isChecked = sortByDuration,
                onCheckedChange = { sortByDuration = it }
            )

            if (isLoading) {
                LoadingView()
            } else {
                TrackList(
                    tracks = sortedTracks,
                    playingTrack = selectedTrack,
                    onClick = { selectedTrack = it },
                    modifier = Modifier.weight(1f)
                )
            }
        }

        MiniPlayer(
            track = selectedTrack,
            isLoading = isLoading,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}
