package com.example.flickr.ui.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.flickr.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val layout = inflater.inflate(R.layout.main_fragment, container, false)
        val imageview = layout.findViewById<ImageView>(R.id.imageView2)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.photo.observe(requireActivity(), Observer { photo ->
            val url =
                "https://farm" + photo.farm + ".staticflickr.com" + photo.server + "/ " + photo.id + "_" + photo.secret + ".jpg"
            Glide.with(requireActivity()).load(url).into(imageView2)
        })
       return layout
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}