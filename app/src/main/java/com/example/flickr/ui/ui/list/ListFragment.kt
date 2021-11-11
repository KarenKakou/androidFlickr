package com.example.flickr.ui.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.flickr.R
import com.example.flickr.model.Photo

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {

    companion object {
        fun newInstance() = ListFragment()
    }

    private lateinit var viewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val layout = inflater.inflate(R.layout.fragment_list, container, false)
        viewModel = ListViewModel()

        viewModel.photos.observe(this, Observer { photos ->
            run {
                val recycler = layout.findViewById<RecyclerView>(R.id.recycleView)
                recycler.layoutManager = GridLayoutManager(requireActivity(), 2)
                recycler.adapter = MyAdapter(photos)
            }
        })

        return layout
    }


}