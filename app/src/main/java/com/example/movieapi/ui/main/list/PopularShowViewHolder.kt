package com.example.movieapi.ui.main.list

import android.view.View
import com.bumptech.glide.Glide
import com.example.movieapi.models.ApiUtils
import com.example.movieapi.models.Show
import com.skydoves.baserecyclerviewadapter.BaseViewHolder
import kotlinx.android.synthetic.main.item_show.view.*

class PopularShowViewHolder(val view: View, private val listener: OnClickListener): BaseViewHolder(view) {
    override fun onClick(p0: View?) = listener.onItemClick(show)

    override fun onLongClick(p0: View?) = false

    interface OnClickListener {
        fun onItemClick(show: Show)
    }

    private lateinit var show: Show

    override fun bindData(data: Any) {
        if (data is Show) {
            show = data
            itemView.run {
                show_title.text = show.name
                show_rating.text = show.vote_average.toString()
                Glide.with(context)
                    .load(ApiUtils.getPosterUrl(show.poster_path))
                    .into(show_image)
            }
        }
    }
}