package com.de04.ung_dung_nghe_nhac

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

sealed class Screen(val route: String) {
    object AlbumList : Screen("album_list")
    object SongList : Screen("song_list/{albumId}") {
        fun createRoute(albumId: String) = "song_list/$albumId"
    }
    object Player : Screen("player")
}

@Composable
fun MusicNavigation() {
    val navController = rememberNavController()
    val viewModel: MusicViewModel = viewModel()

    NavHost(navController = navController, startDestination = Screen.AlbumList.route) {
        composable(Screen.AlbumList.route) {
            AlbumListScreen(onAlbumClick = { album ->
                navController.navigate(Screen.SongList.createRoute(album.id))
            })
        }
        composable(
            route = Screen.SongList.route,
            arguments = listOf(navArgument("albumId") { type = NavType.StringType })
        ) { backStackEntry ->
            val albumId = backStackEntry.arguments?.getString("albumId")
            val album = MockData.albums.find { it.id == albumId }
            if (album != null) {
                SongListScreen(
                    album = album,
                    onSongClick = { song ->
                        viewModel.selectSong(song)
                        navController.navigate(Screen.Player.route)
                    },
                    onBack = { navController.popBackStack() }
                )
            }
        }
        composable(Screen.Player.route) {
            PlayerScreen(
                viewModel = viewModel,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
