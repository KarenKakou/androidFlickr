package com.example.flickr.ui.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.flickr.R
import com.example.flickr.model.Photo
import com.example.flickr.ui.ui.list.ListFragmentDirections


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val layout = inflater.inflate(R.layout.main_fragment, container, false)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val nextBtn = layout.findViewById<Button>(R.id.next)
        val allImgBtn = layout.findViewById<Button>(R.id.allImage)
        val titre = layout.findViewById<TextView>(R.id.titre)
        val photoVue = layout.findViewById<ImageView>(R.id.imageView2)

        viewModel.photos.observe(this, Observer<Photo>{ photo ->
            val url = "https://farm" + photo.farm + ".staticflickr.com/" +
                    photo.server + "/" + photo.id+"_"+photo.secret + ".jpg"

            titre.text = photo.title

            Glide.with(layout).load(url).into(photoVue)

            photoVue.setOnClickListener{
                val action = ListFragmentDirections.versFullFragment(url)
                Navigation.findNavController(layout).navigate(action)
            }

        })


        allImgBtn.setOnClickListener{
            Navigation.findNavController(allImgBtn).navigate(R.id.versListFragment)
        }

        nextBtn.setOnClickListener {
            viewModel.nextPhoto()
        }

        return layout
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

}