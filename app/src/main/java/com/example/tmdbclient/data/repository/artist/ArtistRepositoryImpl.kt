package com.example.tmdbclient.data.repository.artist

import android.util.Log
import com.example.tmdbclient.data.model.artis.Artist
import com.example.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdbclient.domain.repository.ArtistRepository
import java.lang.Exception

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {

    override suspend fun getArtist(): List<Artist> {
        return getArtistFromCache()
    }

    override suspend fun updateArtist(): List<Artist> {
        val newListArtists = getArtistFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistToDB(newListArtists)
        artistCacheDataSource.saveArtistToCache(newListArtists)
        return newListArtists
    }

    suspend fun getArtistFromAPI():List<Artist>{
        lateinit var artistList:List<Artist>
        try {
            val response = artistRemoteDataSource.getArtists()
            var body = response.body()
            if(body!=null) {
                artistList = body.artists
            }
        }catch (exception:Exception){
            Log.i("MyTag", exception.toString())
        }
        return artistList;
    }

    suspend fun getArtistFromDB():List<Artist>{
        lateinit var artistList:List<Artist>
        try {
           artistList = artistLocalDataSource.getArtistsFromDB()

        }catch (exception:Exception){
            Log.i("MyTag", exception.toString())
        }
        if(artistList.size > 0){
            return artistList
        } else {
            artistList = getArtistFromAPI()
            artistLocalDataSource.saveArtistToDB(artistList)
        }
        return artistList;
    }

    suspend fun getArtistFromCache():List<Artist>{
        lateinit var artistList:List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistsFromCache()

        }catch (exception:Exception){
            Log.i("MyTag", exception.toString())
        }
        if(artistList.size > 0){
            return artistList
        } else {
            artistList = getArtistFromDB()
            artistCacheDataSource.saveArtistToCache(artistList)
        }
        return artistList;
    }


}