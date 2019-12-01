package com.example.movieapi.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapi.models.Resource
import com.example.movieapi.models.Show
import com.example.movieapi.ui.main.list.PopularShowsListAdapter

@BindingAdapter("adapterPopularShows")
fun bindPopularShowsRecylcerView(view: RecyclerView, shows: Resource<List<Show>>?) {

    shows?.data?.let {
        val adapter = view.adapter as? PopularShowsListAdapter
        adapter?.addShows(it)
    }
}