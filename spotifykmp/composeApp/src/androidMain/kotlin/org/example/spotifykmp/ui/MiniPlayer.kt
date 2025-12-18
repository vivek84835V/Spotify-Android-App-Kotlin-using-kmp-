import android.media.MediaPlayer
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.example.spotifykmp.R
import org.example.spotifykmp.model.Track
import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp

@Composable
fun MiniPlayer(
    track: Track?,
    isLoading: Boolean,
    modifier: Modifier = Modifier
) {
    if (track == null) return

    val context = LocalContext.current
    var isPlaying by remember { mutableStateOf(false) }
    var isPreparing by remember { mutableStateOf(true) }
    var mediaPlayer by remember { mutableStateOf<MediaPlayer?>(null) }

    LaunchedEffect(track) {
        mediaPlayer?.release()
        isPreparing = true
        mediaPlayer = MediaPlayer().apply {
            setDataSource(track.audio)
            prepareAsync()
            setOnPreparedListener {
                start()
                isPlaying = true
                isPreparing = false
            }
            setOnCompletionListener { isPlaying = false }
        }
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(Color(0xFF121212))
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        AsyncImage(
            model = track.image,
            contentDescription = null,
            modifier = Modifier.size(50.dp),
            contentScale = ContentScale.Crop
        )


        Text(
            text = track.name,
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(start = 10.dp)
                .weight(1f)
        )


        Box(contentAlignment = Alignment.Center) {
            if (isPreparing) {
                CircularProgressIndicator(
                    color = Color.White,
                    strokeWidth = 2.dp,
                    modifier = Modifier.size(30.dp)
                )
            } else {
                IconButton(
                    onClick = {
                        if (isPlaying) {
                            mediaPlayer?.pause()
                            isPlaying = false
                        } else {
                            mediaPlayer?.start()
                            isPlaying = true
                        }
                    }
                ) {
                    Image(
                        painter = painterResource(
                            id = if (isPlaying) R.drawable.btnpause else R.drawable.btnplay
                        ),
                        contentDescription = "Play/Pause",
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        }
    }
}
