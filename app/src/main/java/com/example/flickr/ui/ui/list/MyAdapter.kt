package com.example.flickr.ui.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flickr.R
import com.example.flickr.model.Photo

class MyAdapter(val photos : List<Photo>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(val v: GridLayout) : RecyclerView.ViewHolder(v)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.photo, parent, false)
        return MyViewHolder(layout as GridLayout)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position:Int) {
        val imageView = holder.v.findViewById<ImageView>(R.id.imageView)

        val photo = photos[position]
        val url = "https://farm" + photo.farm + ".staticflickr.com/" +
                photo.server + "/" + photo.id+"_"+photo.secret + ".jpg"

        Glide.with(holder.v).load(url).into(imageView)

        imageView.setOnClickListener{
            val action = ListFragmentDirections.versFullFragment(url)
            Navigation.findNavController(holder.v).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return photos.size
    }

}