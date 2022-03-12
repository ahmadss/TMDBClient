package com.example.tmdbclient.data.repository.tvshow.datasource

import com.example.tmdbclient.data.model.tvshow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowFromDB():List<TvShow>
    suspend fun saveTvShowFromDB(tvShows:List<TvShow>)
    suspend fun clearAll()
}