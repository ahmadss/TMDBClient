package com.example.tmdbclient.data.repository.artist.datasource

import com.example.tmdbclient.data.model.artis.Artist

interface ArtistLocalDataSource {

    suspend fun getArtistsFromDB() : List<Artist>

    suspend fun saveArtistToDB(artist: List<Artist>)

    suspend fun clearAll()
}