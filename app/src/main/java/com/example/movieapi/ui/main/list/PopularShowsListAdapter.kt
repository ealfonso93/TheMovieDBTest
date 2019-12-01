package com.example.movieapi.ui.main.list

import android.view.View
import com.example.movieapi.R
import com.example.movieapi.models.Show
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.baserecyclerviewadapter.SectionRow

class PopularShowsListAdapter(private val onClickListener: PopularShowViewHolder.OnClickListener):
    BaseAdapter() {

    init {
        //This is mandatory otherwise you get a nice NPE
        addSection(ArrayList<Show>())
    }

    fun addShows(shows: List<Show>) {
        val firstNewItemPosition = sections()[0].size
        sections()[0].addAll(shows)
        notifyItemRangeInserted(firstNewItemPosition, shows.size)
    }

    override fun layout(sectionRow: SectionRow) = R.layout.item_show

    override fun viewHolder(layout: Int, view: View) = PopularShowViewHolder(view, onClickListener)


}
