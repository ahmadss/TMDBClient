package com.example.tmdbclient.data.repository.artist.datasourceimpl

import com.example.tmdbclient.data.model.artis.Artist
import com.example.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl: ArtistCacheDataSource {
    private var artistsList = ArrayList<Artist>()

    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistsList
    }

    override suspend fun saveArtistToCache(artists: List<Artist>) {
        artistsList.clear()
        artistsList = ArrayList(artists)
    }
}