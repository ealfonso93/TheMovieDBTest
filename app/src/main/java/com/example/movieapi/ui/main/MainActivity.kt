package com.example.movieapi.ui.main

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.movieapi.R
import com.example.movieapi.base.ViewModelActivity
import com.example.movieapi.databinding.MainActivityBinding
import com.example.movieapi.models.Show
import com.example.movieapi.models.Status
import com.example.movieapi.ui.main.list.PopularShowViewHolder
import com.example.movieapi.ui.main.list.PopularShowsListAdapter
import com.skydoves.baserecyclerviewadapter.RecyclerViewPaginator
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity: ViewModelActivity(), PopularShowViewHolder.OnClickListener,
    SwipeRefreshLayout.OnRefreshListener {

    private var paginator: RecyclerViewPaginator? = null

    private val vm by viewModel<MainViewModel>()
    private val binding by binding<MainActivityBinding>(R.layout.main_activity)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(binding) {
            lifecycleOwner = this@MainActivity
            viewModel = vm
        }
        swipeRefreshLayout.setOnRefreshListener(this)
        recyclerView.adapter = PopularShowsListAdapter(this)
        recyclerView.layoutManager = GridLayoutManager(applicationContext, 2)
        paginator = RecyclerViewPaginator(
            recyclerView = recyclerView,
            isLoading = { vm.getShowListValues()?.status == Status.LOADING },
            loadMore = { loadMore(it) },
            onLast = { vm.getShowListValues()?.onLastPage ?: false }
        )
        paginator?.currentPage = 1
        paginator?.threshold = 3
        loadMore(1)
    }

    override fun onItemClick(show: Show) {
        //Do nothing
    }

    fun loadMore(page: Int) {
        vm.loadShowsPage(page)
    }

    override fun onRefresh() {
        paginator?.resetCurrentPage()
        swipeRefreshLayout.isRefreshing = vm.getShowListValues()?.status == Status.LOADING
        loadMore(1)
    }
}
