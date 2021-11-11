package com.example.flickr.ui.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.flickr.model.Photo
import com.example.flickr.model.SearchResult
import com.example.flickr.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel : ViewModel() {

    val photos = MutableLiveData<Photo>()
    val photosList = ArrayList<Photo>()

    init {
        val repository = Repository()
        repository.getPhotos(object : Callback<SearchResult>{
            override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>) {

                val res = response.body()?.photos?.photo
                res?.forEach{photos ->
                    photosList.add(photos)
                }

                nextPhoto()
            }

            override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                TODO("Not yet implemented")
                print("ça a fail")
            }
        })
    }

    fun nextPhoto(){
        var i = photosList.indexOf(photos.value)

        if(i == photosList.size - 1) {
            i = 0
        }
        else {
            i ++
        }

        photos.value = photosList[i]
    }
}