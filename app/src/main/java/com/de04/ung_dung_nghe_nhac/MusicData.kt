package com.de04.ung_dung_nghe_nhac

data class Song(
    val id: String,
    val title: String,
    val artist: String,
    val duration: Long,
    val albumTitle: String
)

data class Album(
    val id: String,
    val title: String,
    val artist: String,
    val songCount: Int
)

object MockData {
    val songs = listOf(
        Song("1", "Chúng Ta Của Tương Lai", "Sơn Tùng M-TP", 240000, "Album 1"),
        Song("2", "Nơi Này Có Anh", "Sơn Tùng M-TP", 200000, "Album 1"),
        Song("3", "Lạc Trôi", "Sơn Tùng M-TP", 230000, "Album 2"),
        Song("4", "Em Của Ngày Hôm Qua", "Sơn Tùng M-TP", 220000, "Album 2"),
        Song("5", "Hãy Trao Cho Anh", "Sơn Tùng M-TP", 250000, "Album 3")
    )

    val albums = listOf(
        Album("1", "Album 1", "Sơn Tùng M-TP", 2),
        Album("2", "Album 2", "Sơn Tùng M-TP", 2),
        Album("3", "Album 3", "Sơn Tùng M-TP", 1)
    )
}
