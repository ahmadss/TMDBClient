package com.example.tmdbclient.domain.usecase

import com.example.tmdbclient.domain.repository.ArtistRepository
import com.example.tmdbclient.data.model.artis.Artist

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute():List<Artist>? = artistRepository.getArtist()
}