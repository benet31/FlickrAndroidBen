package com.example.flickr.ui.ui.main

import android.provider.ContactsContract
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.flickr.model.Photo
import com.example.flickr.model.SearchResult
import com.example.flickr.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

     var photo: MutableLiveData<Photo> = MutableLiveData()
    init {
        Repository().getPhotos(object: Callback<SearchResult> {
            override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                Log.v("Fail", "message")
            }

            override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>) {
                val photos  = response.body()?.photos?.photo
                if (photos != null && photos.size != 0) {
                    photo.value = photos[0]
                }
            }

        })
    }
  }