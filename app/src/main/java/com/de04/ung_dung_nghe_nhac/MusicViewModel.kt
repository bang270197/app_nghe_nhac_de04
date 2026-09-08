package com.de04.ung_dung_nghe_nhac

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MusicViewModel : ViewModel() {

    private val _songs = MutableStateFlow(MockData.songs)
    val songs: StateFlow<List<Song>> = _songs.asStateFlow()

    private val _currentSong = MutableStateFlow<Song?>(null)
    val currentSong: StateFlow<Song?> = _currentSong.asStateFlow()

    private val _isPlaying = MutableStateFlow(false)
    val isPlaying: StateFlow<Boolean> = _isPlaying.asStateFlow()

    private val _progress = MutableStateFlow(0f)
    val progress: StateFlow<Float> = _progress.asStateFlow()

    fun selectSong(song: Song) {
        _currentSong.value = song
        _isPlaying.value = true
        _progress.value = 0f
    }

    fun togglePlayPause() {
        _isPlaying.value = !_isPlaying.value
    }

    fun playNext() {
        val current = _currentSong.value
        val currentIndex = MockData.songs.indexOf(current)
        if (currentIndex != -1 && currentIndex < MockData.songs.size - 1) {
            selectSong(MockData.songs[currentIndex + 1])
        }
    }

    fun playPrevious() {
        val current = _currentSong.value
        val currentIndex = MockData.songs.indexOf(current)
        if (currentIndex > 0) {
            selectSong(MockData.songs[currentIndex - 1])
        }
    }

    fun seekTo(position: Float) {
        _progress.value = position
    }

    fun toggleFavorite(songId: String) {
        _songs.value = _songs.value.map {
            if (it.id == songId) it.copy(isFavorite = !it.isFavorite) else it
        }
        if (_currentSong.value?.id == songId) {
            _currentSong.value = _currentSong.value?.copy(isFavorite = !(_currentSong.value?.isFavorite ?: false))
        }
    }
}
