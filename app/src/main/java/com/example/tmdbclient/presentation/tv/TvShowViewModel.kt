package com.example.tmdbclient.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.data.model.tvshow.TvShow
import com.example.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.example.tmdbclient.domain.usecase.UpdateTvShowsUseCase

class TvShowViewModel(private val getTvShowsUseCase: GetTvShowsUseCase, private val updateTvShowsUseCase: UpdateTvShowsUseCase): ViewModel() {

    fun getTvShow() = liveData {
        val tvShowList:List<TvShow>?  = getTvShowsUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShow() = liveData {
        val tvShowList:List<TvShow>? = updateTvShowsUseCase.execute()
        emit(tvShowList)
    }
}