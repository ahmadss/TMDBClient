package com.example.tmdbclient.presentation.di

import com.example.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.example.tmdbclient.presentation.di.movie.MovieSubComponent
import com.example.tmdbclient.presentation.di.tvshow.TvSubComponent

interface Injector {
    fun createMovieSubComponent():MovieSubComponent
    fun tvShowSubComponent():TvSubComponent
    fun createArtistSubComponent():ArtistSubComponent
}