package com.de04.ung_dung_nghe_nhac

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SoundCloudTopBar() {
    TopAppBar(
        title = {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    "SoundCloud",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = { /* TODO */ }) {
                Icon(Icons.Default.Menu, contentDescription = "Menu", tint = Color.White)
            }
        },
        actions = {
            IconButton(onClick = { /* TODO */ }) {
                Icon(Icons.Default.Person, contentDescription = "Profile", tint = Color.White)
            }
            IconButton(onClick = { /* TODO */ }) {
                Icon(Icons.Default.Notifications, contentDescription = "Notifications", tint = Color.White)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFFB0B0C0) // Grayish blue from image
        )
    )
}

@Composable
fun AlbumItem(album: Album, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .width(140.dp)
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        AsyncImage(
            model = album.imageUrl,
            contentDescription = album.title,
            modifier = Modifier
                .size(120.dp)
                .clip(RoundedCornerShape(4.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = album.title,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = album.artist,
            color = Color.Gray,
            fontSize = 12.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun CategoryRow(category: Category, onAlbumClick: (Album) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(4.dp)
    ) {
        Column(modifier = Modifier.padding(vertical = 8.dp)) {
            Text(
                text = "${category.name} >>",
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )
            LazyRow(
                contentPadding = PaddingValues(horizontal = 8.dp)
            ) {
                items(category.albums) { album ->
                    AlbumItem(album = album, onClick = { onAlbumClick(album) })
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AlbumListScreenPreview() {
    AlbumListScreen(onAlbumClick = {})
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlbumListScreen(onAlbumClick: (Album) -> Unit) {
    Scaffold(
        topBar = { SoundCloudTopBar() }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(MockData.categories) { category ->
                CategoryRow(category = category, onAlbumClick = onAlbumClick)
            }
        }
    }
}

@Composable
fun SongItem(
    song: Song,
    isSelected: Boolean,
    onSongClick: () -> Unit,
    onFavoriteClick: () -> Unit
) {
    val tintColor = if (isSelected) Color(0xFFFF5722) else Color.Black
    val dateColor = Color.Gray

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onSongClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = song.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(4.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = song.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = tintColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = song.artist,
                fontSize = 16.sp,
                color = tintColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = song.releaseDate,
                fontSize = 14.sp,
                color = dateColor
            )
        }

        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.height(100.dp)
        ) {
            Text(
                text = song.durationText,
                fontSize = 14.sp,
                color = dateColor
            )
            IconButton(onClick = onFavoriteClick) {
                Icon(
                    imageVector = if (song.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "Favorite",
                    tint = if (song.isFavorite) Color(0xFFFF5722) else Color(0xFFFF5722) // Both orange/red in image
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SongListScreen(
    album: Album,
    viewModel: MusicViewModel,
    onSongClick: (Song) -> Unit,
    onBack: () -> Unit
) {
    val songs by viewModel.songs.collectAsState()
    val albumSongs = songs.filter { it.albumTitle == album.title }
    val currentSong by viewModel.currentSong.collectAsState()

    Scaffold(
        topBar = {
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(
                        onClick = onBack,
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 8.dp)
                    ) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.Gray
                        )
                    }
                    Text(
                        album.artist,
                        color = Color(0xFFB39DDB), // Light purple color from top of image
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                HorizontalDivider(thickness = 1.dp, color = Color.LightGray)
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            items(albumSongs) { song ->
                SongItem(
                    song = song,
                    isSelected = song.id == currentSong?.id,
                    onSongClick = { onSongClick(song) },
                    onFavoriteClick = { viewModel.toggleFavorite(song.id) }
                )
                HorizontalDivider(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    thickness = 0.5.dp,
                    color = Color.LightGray
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayerScreen(
    viewModel: MusicViewModel,
    onBack: () -> Unit
) {
    val currentSong by viewModel.currentSong.collectAsState()
    val isPlaying by viewModel.isPlaying.collectAsState()
    val progress by viewModel.progress.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Now Playing") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            currentSong?.let { song ->
                Text(song.title, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Text(song.artist, fontSize = 18.sp, color = MaterialTheme.colorScheme.secondary)
                
                Spacer(modifier = Modifier.height(48.dp))
                
                Slider(
                    value = progress,
                    onValueChange = { viewModel.seekTo(it) },
                    modifier = Modifier.fillMaxWidth()
                )
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { viewModel.playPrevious() }) {
                        Icon(Icons.Default.SkipPrevious, contentDescription = "Previous", modifier = Modifier.size(48.dp))
                    }
                    IconButton(onClick = { viewModel.togglePlayPause() }) {
                        Icon(
                            if (isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                            contentDescription = "Play/Pause",
                            modifier = Modifier.size(64.dp)
                        )
                    }
                    IconButton(onClick = { viewModel.playNext() }) {
                        Icon(Icons.Default.SkipNext, contentDescription = "Next", modifier = Modifier.size(48.dp))
                    }
                }
            } ?: Text("No song selected")
        }
    }
}
