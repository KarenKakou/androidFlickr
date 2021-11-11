package com.example.flickr.ui.ui.full

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.flickr.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FullFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FullFragment : Fragment() {
// TODO: Rename and change types of parameters
private var param1: String? = null
private var param2: String? = null

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        param1 = it.getString(ARG_PARAM1)
        param2 = it.getString(ARG_PARAM2)
        }
        }

        companion object {
/**
 * Use this factory method to create a new instance of
 * this fragment using the provided parameters.
 *
 * @param param1 Parameter 1.
 * @param param2 Parameter 2.
 * @return A new instance of fragment FullFragment.
 */
// TODO: Rename and change types and number of parameters
@JvmStatic
        fun newInstance(param1: String, param2: String) =
                FullFragment().apply {
                arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
                putString(ARG_PARAM2, param2)
                }
                }
                }

private lateinit var viewModel: FullViewModel


        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View? {
        val layout = inflater.inflate(R.layout.full_fragment, container, false)
        val imageView = layout.findViewById<ImageView>(R.id.imageView)
        val url = FullFragmentArgs.fromBundle(requireArguments()).url
        Glide.with(layout).load(url).into(imageView)
        return layout
        }

        override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FullViewModel::class.java)
        // TODO: Use the ViewModel
        }

}