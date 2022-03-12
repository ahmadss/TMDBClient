package com.example.tmdbclient.presentation.di.tvshow

import com.example.tmdbclient.presentation.artist.ArtistActivity
import com.example.tmdbclient.presentation.movie.MovieActivity
import com.example.tmdbclient.presentation.tv.TvShowActivity
import dagger.Subcomponent
@TvScope
@Subcomponent(modules = [
    TvScope::class
])
interface TvSubComponent {
    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():TvSubComponent
    }
}