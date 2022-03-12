package com.example.tmdbclient.presentation.di.tvshow

import com.example.tmdbclient.domain.usecase.*
import com.example.tmdbclient.presentation.artist.ArtistViewModelFactory
import com.example.tmdbclient.presentation.movie.MovieViewModelFactory
import com.example.tmdbclient.presentation.tv.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvModule {
    @TvScope
    @Provides
    fun provideTvViewModelFactory(getTvShowsUseCase: GetTvShowsUseCase, updateTvShowsUseCase: UpdateTvShowsUseCase):TvShowViewModelFactory{
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }
}