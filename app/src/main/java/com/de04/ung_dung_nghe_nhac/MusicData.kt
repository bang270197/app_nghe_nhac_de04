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
    val songCount: Int,
    val imageUrl: String
)

data class Category(
    val id: String,
    val name: String,
    val albums: List<Album>
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
        Album("1", "Chúng Ta Của Tương Lai", "Sơn Tùng M-TP", 2, "https://picsum.photos/seed/1/400/400"),
        Album("2", "Lạc Trôi", "Sơn Tùng M-TP", 2, "https://picsum.photos/seed/2/400/400"),
        Album("3", "Hãy Trao Cho Anh", "Sơn Tùng M-TP", 1, "https://picsum.photos/seed/3/400/400"),
        Album("4", "Falling Down", "Lil Peep & XXXTENTACION", 1, "https://picsum.photos/seed/4/400/400"),
        Album("5", "Sunlight On Your Skin", "Lil Peep & ILoveMakonnen", 1, "https://picsum.photos/seed/5/400/400"),
        Album("6", "Cavetown", "cavetown", 1, "https://picsum.photos/seed/6/400/400"),
        Album("7", "Old Town Road", "Lil Nas X", 1, "https://picsum.photos/seed/7/400/400"),
        Album("8", "Haunt u w/lil p...", "Lil Peep", 1, "https://picsum.photos/seed/8/400/400"),
        Album("9", "BIG CHILD", "MO BAMBA C", 1, "https://picsum.photos/seed/9/400/400")
    )

    val categories = listOf(
        Category("1", "Recently Played", albums.subList(0, 3)),
        Category("2", "Recommended", albums.subList(3, 6)),
        Category("3", "Country", albums.subList(6, 9))
    )
}
