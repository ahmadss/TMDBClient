package com.example.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.data.model.artis.Artist
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.domain.usecase.GetArtistsUseCase
import com.example.tmdbclient.domain.usecase.UpdateArtistsUseCase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModel() {

    fun getArtists() = liveData {
        val artistList: List<Artist>? = getArtistsUseCase.execute()
        emit(artistList)
    }

    fun updateArtist() = liveData {
        val artistList:List<Artist>? = updateArtistsUseCase.execute()
        emit(artistList)
    }
}