package com.de04.ung_dung_nghe_nhac

data class Song(
    val id: String,
    val title: String,
    val artist: String,
    val albumTitle: String,
    val imageUrl: String,
    val releaseDate: String,
    val durationText: String,
    var isFavorite: Boolean = false
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
        // Album 1: MURDER ON MY MIND
        Song("101", "YNW MELLY - MURDER O", "Ynw Melly", "MURDER ON MY MIND", "https://picsum.photos/seed/m1/400/400", "04-03-2017", "4:27", true),
        Song("102", "Robbery", "Juice WRLD", "MURDER ON MY MIND", "https://picsum.photos/seed/m2/400/400", "08-03-2019", "4:00", false),
        Song("103", "WORTH IT", "YK Osiris", "MURDER ON MY MIND", "https://picsum.photos/seed/m3/400/400", "01-02-2019", "3:09", true),
        Song("104", "Swervin feat. 6ix9in", "A BOOGIE WIT DA HOODIE", "MURDER ON MY MIND", "https://picsum.photos/seed/m4/400/400", "19-12-2018", "3:08", true),
        Song("105", "Mixed Personalities", "Ynw Melly", "MURDER ON MY MIND", "https://picsum.photos/seed/m5/400/400", "17-01-2019", "3:50", false),

        // Album 2: WORTH IT
        Song("201", "Worth It", "YK Osiris", "WORTH IT", "https://picsum.photos/seed/w1/400/400", "01-02-2019", "3:11", false),
        Song("202", "Valentine", "YK Osiris", "WORTH IT", "https://picsum.photos/seed/w2/400/400", "20-04-2018", "3:25", true),
        Song("203", "Run It Up", "YK Osiris", "WORTH IT", "https://picsum.photos/seed/w3/400/400", "15-06-2018", "2:58", false),

        // Album 3: Haunt u w/lil p...
        Song("301", "Haunt u", "Lil Peep", "Haunt u w/lil p...", "https://picsum.photos/seed/h1/400/400", "12-10-2016", "2:56", true),
        Song("302", "Star Shopping", "Lil Peep", "Haunt u w/lil p...", "https://picsum.photos/seed/h2/400/400", "17-08-2015", "2:22", false),

        // Album 4: Falling Down
        Song("401", "Falling Down", "Lil Peep & XXXTENTACION", "Falling Down", "https://picsum.photos/seed/f1/400/400", "19-09-2018", "3:16", true),
        Song("402", "SAD!", "XXXTENTACION", "Falling Down", "https://picsum.photos/seed/f2/400/400", "02-03-2018", "2:46", false),
        Song("403", "Moonlight", "XXXTENTACION", "Falling Down", "https://picsum.photos/seed/f3/400/400", "02-03-2018", "2:15", true),

        // Album 5: Sunlight On Your Skin
        Song("501", "Sunlight On Your Skin", "Lil Peep & ILoveMakonnen", "Sunlight On Your Skin", "https://picsum.photos/seed/s1/400/400", "27-09-2018", "3:18", false),
        Song("502", "I've Been Waiting", "Lil Peep & ILoveMakonnen", "Sunlight On Your Skin", "https://picsum.photos/seed/s2/400/400", "31-01-2019", "3:39", true),

        // Album 6: Cavetown
        Song("601", "Boys Will Be Bugs", "cavetown", "Cavetown", "https://picsum.photos/seed/c1/400/400", "14-12-2018", "3:27", true),
        Song("602", "Devil Town", "cavetown", "Cavetown", "https://picsum.photos/seed/c2/400/400", "23-01-2015", "3:01", false),
        Song("603", "Lemon Boy", "cavetown", "Cavetown", "https://picsum.photos/seed/c3/400/400", "15-12-2017", "4:32", false),

        // Album 7: Old Town Road
        Song("701", "Old Town Road", "Lil Nas X", "Old Town Road", "https://picsum.photos/seed/o1/400/400", "03-12-2018", "1:53", true),
        Song("702", "Panini", "Lil Nas X", "Old Town Road", "https://picsum.photos/seed/o2/400/400", "20-06-2019", "1:55", false),
        Song("703", "Rodeo", "Lil Nas X & Cardi B", "Old Town Road", "https://picsum.photos/seed/o3/400/400", "21-06-2019", "2:39", true),

        // Album 8: Robbery
        Song("801", "Robbery", "Juice WRLD", "Robbery", "https://picsum.photos/seed/r1/400/400", "08-03-2019", "4:00", true),
        Song("802", "Lucid Dreams", "Juice WRLD", "Robbery", "https://picsum.photos/seed/r2/400/400", "04-05-2018", "3:59", false),
        Song("803", "All Girls Are The Same", "Juice WRLD", "Robbery", "https://picsum.photos/seed/r3/400/400", "13-04-2018", "2:45", true),
        Song("804", "Lean Wit Me", "Juice WRLD", "Robbery", "https://picsum.photos/seed/r4/400/400", "02-08-2018", "2:55", false),

        // Album 9: BIG CHILD
        Song("901", "MO BAMBA", "Sheck Wes", "BIG CHILD", "https://picsum.photos/seed/b1/400/400", "16-06-2017", "3:03", true),
        Song("902", "Live Sheck Wes Die Sheck Wes", "Sheck Wes", "BIG CHILD", "https://picsum.photos/seed/b2/400/400", "24-01-2018", "3:45", false)
    )

    val albums = listOf(
        Album("1", "MURDER ON MY MIND", "Ynw Melly", 5, "https://picsum.photos/seed/m1/400/400"),
        Album("2", "WORTH IT", "YK Osiris", 3, "https://picsum.photos/seed/w1/400/400"),
        Album("3", "Haunt u w/lil p...", "Lil Peep", 2, "https://picsum.photos/seed/h1/400/400"),
        Album("4", "Falling Down", "Lil Peep & XXXTENTACION", 3, "https://picsum.photos/seed/f1/400/400"),
        Album("5", "Sunlight On Your Skin", "Lil Peep & ILoveMakonnen", 2, "https://picsum.photos/seed/s1/400/400"),
        Album("6", "Cavetown", "cavetown", 3, "https://picsum.photos/seed/c1/400/400"),
        Album("7", "Old Town Road", "Lil Nas X", 3, "https://picsum.photos/seed/o1/400/400"),
        Album("8", "Robbery", "Juice WRLD", 4, "https://picsum.photos/seed/r1/400/400"),
        Album("9", "BIG CHILD", "Sheck Wes", 2, "https://picsum.photos/seed/b1/400/400")
    )

    val categories = listOf(
        Category("1", "Recently Played", albums.subList(0, 3)),
        Category("2", "Recommended", albums.subList(3, 6)),
        Category("3", "Country", albums.subList(6, 9))
    )
}
