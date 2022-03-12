package com.example.tmdbclient.presentation.di.core

import android.content.Context
import com.example.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.example.tmdbclient.presentation.di.movie.MovieSubComponent
import com.example.tmdbclient.presentation.di.tvshow.TvSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class, TvSubComponent::class, ArtistSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideAppicationContext():Context{
        return context.applicationContext
    }
}