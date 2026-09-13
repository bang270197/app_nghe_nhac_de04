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
        // Midnights - Taylor Swift
        Song("101", "Anti-Hero", "Taylor Swift", "Midnights", "https://picsum.photos/id/1/400/400", "21-10-2022", "3:20", true),
        Song("102", "Lavender Haze", "Taylor Swift", "Midnights", "https://picsum.photos/id/1/400/400", "21-10-2022", "3:22", false),
        Song("103", "Maroon", "Taylor Swift", "Midnights", "https://picsum.photos/id/1/400/400", "21-10-2022", "3:38", true),
        Song("104", "Snow On The Beach", "Taylor Swift ft. Lana Del Rey", "Midnights", "https://picsum.photos/id/1/400/400", "21-10-2022", "4:16", false),
        Song("105", "You're On Your Own, Kid", "Taylor Swift", "Midnights", "https://picsum.photos/id/1/400/400", "21-10-2022", "3:14", true),

        // Starboy - The Weeknd
        Song("201", "Starboy", "The Weeknd ft. Daft Punk", "Starboy", "https://picsum.photos/id/10/400/400", "25-11-2016", "3:50", true),
        Song("202", "I Feel It Coming", "The Weeknd ft. Daft Punk", "Starboy", "https://picsum.photos/id/10/400/400", "25-11-2016", "4:29", false),
        Song("203", "Reminder", "The Weeknd", "Starboy", "https://picsum.photos/id/10/400/400", "25-11-2016", "3:38", true),

        // Harry's House - Harry Styles
        Song("301", "As It Was", "Harry Styles", "Harry's House", "https://picsum.photos/id/20/400/400", "01-04-2022", "2:47", true),
        Song("302", "Late Night Talking", "Harry Styles", "Harry's House", "https://picsum.photos/id/20/400/400", "20-05-2022", "2:57", false),

        // Certified Lover Boy - Drake
        Song("401", "Way 2 Sexy", "Drake ft. Future & Young Thug", "Certified Lover Boy", "https://picsum.photos/id/30/400/400", "03-09-2021", "4:17", true),
        Song("402", "Girls Want Girls", "Drake ft. Lil Baby", "Certified Lover Boy", "https://picsum.photos/id/30/400/400", "03-09-2021", "3:41", false),
        Song("403", "Fair Trade", "Drake ft. Travis Scott", "Certified Lover Boy", "https://picsum.photos/id/30/400/400", "03-09-2021", "4:51", true),

        // Future Nostalgia - Dua Lipa
        Song("501", "Don't Start Now", "Dua Lipa", "Future Nostalgia", "https://picsum.photos/id/40/400/400", "31-10-2019", "3:03", true),
        Song("502", "Levitating", "Dua Lipa", "Future Nostalgia", "https://picsum.photos/id/40/400/400", "27-03-2020", "3:23", true),

        // After Hours - The Weeknd
        Song("601", "Blinding Lights", "The Weeknd", "After Hours", "https://picsum.photos/id/50/400/400", "29-11-2019", "3:20", true),
        Song("602", "Save Your Tears", "The Weeknd", "After Hours", "https://picsum.photos/id/50/400/400", "20-03-2020", "3:35", false),
        Song("603", "After Hours", "The Weeknd", "After Hours", "https://picsum.photos/id/50/400/400", "19-02-2020", "6:01", false),

        // Folklore - Taylor Swift
        Song("701", "cardigan", "Taylor Swift", "Folklore", "https://picsum.photos/id/60/400/400", "24-07-2020", "3:59", true),
        Song("702", "the 1", "Taylor Swift", "Folklore", "https://picsum.photos/id/60/400/400", "24-07-2020", "3:30", false),
        Song("703", "exile", "Taylor Swift ft. Bon Iver", "Folklore", "https://picsum.photos/id/60/400/400", "24-07-2020", "4:45", true),

        // Fine Line - Harry Styles
        Song("801", "Watermelon Sugar", "Harry Styles", "Fine Line", "https://picsum.photos/id/70/400/400", "16-11-2019", "2:54", true),
        Song("802", "Adore You", "Harry Styles", "Fine Line", "https://picsum.photos/id/70/400/400", "06-12-2019", "3:27", false),
        Song("803", "Falling", "Harry Styles", "Fine Line", "https://picsum.photos/id/70/400/400", "13-12-2019", "4:00", true),
        Song("804", "Lights Up", "Harry Styles", "Fine Line", "https://picsum.photos/id/70/400/400", "11-10-2019", "2:52", false),

        // Big Child - Sheck Wes
        Song("901", "Mo Bamba", "Sheck Wes", "Big Child", "https://picsum.photos/id/80/400/400", "16-06-2017", "3:03", true),
        Song("902", "Live Sheck Wes Die Sheck Wes", "Sheck Wes", "Big Child", "https://picsum.photos/id/80/400/400", "24-01-2018", "3:45", false)
    )

    val albums = listOf(
        Album("1", "Midnights", "Taylor Swift", 5, "https://picsum.photos/id/1/400/400"),
        Album("2", "Starboy", "The Weeknd", 3, "https://picsum.photos/id/10/400/400"),
        Album("3", "Harry's House", "Harry Styles", 2, "https://picsum.photos/id/20/400/400"),
        Album("4", "Certified Lover Boy", "Drake", 3, "https://picsum.photos/id/30/400/400"),
        Album("5", "Future Nostalgia", "Dua Lipa", 2, "https://picsum.photos/id/40/400/400"),
        Album("6", "After Hours", "The Weeknd", 3, "https://picsum.photos/id/50/400/400"),
        Album("7", "Folklore", "Taylor Swift", 3, "https://picsum.photos/id/60/400/400"),
        Album("8", "Fine Line", "Harry Styles", 4, "https://picsum.photos/id/70/400/400"),
        Album("9", "Big Child", "Sheck Wes", 2, "https://picsum.photos/id/80/400/400")
    )

    val categories = listOf(
        Category("1", "Recently Played", albums.subList(0, 3)),
        Category("2", "Recommended", albums.subList(3, 6)),
        Category("3", "Country", albums.subList(6, 9))
    )
}
