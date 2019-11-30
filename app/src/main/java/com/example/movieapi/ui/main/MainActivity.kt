package com.example.movieapi.ui.main

import android.os.Bundle
import com.example.movieapi.R
import com.example.movieapi.base.ViewModelActivity
import com.example.movieapi.databinding.MainActivityBinding
import dagger.android.support.DaggerAppCompatActivity

class MainActivity: ViewModelActivity(){

    private val vm by viewModel<MainViewModel>()
    private val binding by binding<MainActivityBinding>(R.layout.main_activity)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(binding) {
            lifecycleOwner = this@MainActivity
            viewModel = vm
        }
    }

}
