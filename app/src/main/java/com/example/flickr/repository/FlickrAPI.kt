package com.example.flickr.repository


import retrofit2.http.GET
import retrofit2.http.Query
import com.example.flickr.model.SearchResult
import retrofit2.Call

interface FlickrAPI {

    @GET("/services/rest?format=json&nojsoncallback=1")
    fun getInterestingPhotos(
        @Query("method") method: String,
        @Query("api-key") key: String,
        @Query("per_page") perpage:String) : Call<SearchResult>
}