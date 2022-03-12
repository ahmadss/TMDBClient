package com.example.tmdbclient.data.repository.tvshow

import android.util.Log
import com.example.tmdbclient.data.model.tvshow.TvShow
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.tmdbclient.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepository {

    override suspend fun getTvShows(): List<TvShow> {
       return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow> {
        val newtvShowList = getTvShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowFromDB(newtvShowList)
        tvShowCacheDataSource.saveTvShowToCache(newtvShowList)
        return newtvShowList
    }

    suspend fun getTvShowsFromAPI():List<TvShow>{
        lateinit var tvShowList : List<TvShow>
        try {
            val response = tvShowRemoteDataSource.getTvShow()
            var body = response.body()
            if(body!=null){
               tvShowList = body.tvShows
            }
        }catch (exception:Exception){
            Log.i("MyTag", exception.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowsFromDB():List<TvShow>{
        lateinit var tvShowList : List<TvShow>
        try {
           tvShowList = tvShowLocalDataSource.getTvShowFromDB()
        }catch (exception:Exception){
            Log.i("MyTag", exception.toString())
        }
        if(tvShowList.size > 0){
            return tvShowList;
        } else {
            tvShowList = getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowFromDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowsFromCache():List<TvShow>{
        lateinit var tvShowList : List<TvShow>
        try {
            tvShowList = tvShowCacheDataSource.getTvShowFromCache()
        }catch (exception:Exception){
            Log.i("MyTag", exception.toString())
        }
        if(tvShowList.size > 0){
            return tvShowList;
        } else {
            tvShowList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowToCache(tvShowList)
        }
        return tvShowList
    }
}