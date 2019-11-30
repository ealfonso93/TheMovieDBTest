package com.example.movieapi.ui.main

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movieapi.R
import com.example.movieapi.base.ViewModelActivity
import com.example.movieapi.databinding.MainActivityBinding
import com.example.movieapi.models.Show
import com.example.movieapi.ui.main.list.PopularShowViewHolder
import com.example.movieapi.ui.main.list.PopularShowsListAdapter
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity: ViewModelActivity(), PopularShowViewHolder.OnClickListener{


    private val vm by viewModel<MainViewModel>()
    private val binding by binding<MainActivityBinding>(R.layout.main_activity)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(binding) {
            lifecycleOwner = this@MainActivity
            viewModel = vm
        }

        recyclerView.adapter = PopularShowsListAdapter(this)
        recyclerView.layoutManager = GridLayoutManager(applicationContext, 2)
    }

    override fun onItemClick(show: Show) {
        //Do nothing
    }
}
