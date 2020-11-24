package com.example.flickr.repository

import com.example.flickr.model.SearchResult
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class Repository {
    fun getPhotos(callback: Callback<SearchResult>) {

        val url = "https://www.flickr.com"
        val retrofit = Retrofit.Builder().baseUrl(url).addConverterFactory(MoshiConverterFactory.create()).build()

        val service = retrofit.create(FlickrAPI::class.java)

        service.getInterestingPhotos(
            "flickr.interestingness.getList",
            "f7c9553c65bdd078",
            "20"
        ).enqueue(callback)

    }
}