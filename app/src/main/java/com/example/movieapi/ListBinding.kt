package com.example.movieapi

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapi.models.Show
import com.example.movieapi.ui.main.list.PopularShowsListAdapter

@BindingAdapter("adapterPopularShows")
fun bindPopularShowsRecylcerView(view: RecyclerView, shows: List<Show>?) {

    shows?.let {showsList ->
        val adapter = view.adapter as? PopularShowsListAdapter
        adapter?.addShows(showsList)
    }

}