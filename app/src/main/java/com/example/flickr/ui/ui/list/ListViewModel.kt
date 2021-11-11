package com.example.flickr.ui.ui.list

import androidx.lifecycle.MutableLiveData
import com.example.flickr.model.Photo
import com.example.flickr.model.SearchResult
import com.example.flickr.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListViewModel {
    val photos = MutableLiveData<List<Photo>>()
    val photosList = ArrayList<Photo>()

    init {
        val repository = Repository()
        repository.getPhotos(object : Callback<SearchResult> {
            override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>) {

                val res = response.body()?.photos?.photo
                res?.forEach{photos ->
                    photosList.add(photos)
                }

                photos.value = photosList
            }

            override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                TODO("Not yet implemented")
                print("ça a fail")
            }
        })
    }
}