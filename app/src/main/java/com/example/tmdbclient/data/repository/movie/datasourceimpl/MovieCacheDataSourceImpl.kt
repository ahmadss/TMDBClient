package com.example.tmdbclient.data.repository.movie.datasourceimpl

import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import kotlin.collections.ArrayList

class MovieCacheDataSourceImpl : MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMovieToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}