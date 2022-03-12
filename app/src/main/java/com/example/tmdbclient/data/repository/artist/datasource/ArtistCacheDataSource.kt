package com.example.tmdbclient.data.repository.artist.datasource

import com.example.tmdbclient.data.model.artis.Artist

interface ArtistCacheDataSource {

    suspend fun getArtistsFromCache():List<Artist>
    suspend fun saveArtistToCache(artists:List<Artist>)
}