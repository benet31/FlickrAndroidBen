package com.example.flickr.ui.ui.main

import android.provider.ContactsContract
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.flickr.model.Photo

class MainViewModel : ViewModel() {

    lateinit var photo: MutableLiveData<Photo>
    val url = "https://farm"+ photo.farm + ".staticflickr.com"+ photo.server + "/ " + photo.id+"_"+photo.secret+".jpg"
}