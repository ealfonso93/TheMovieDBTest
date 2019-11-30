package com.example.movieapi.ui.main

import android.os.Bundle
import com.example.movieapi.R
import com.example.movieapi.base.ViewModelActivity
import dagger.android.support.DaggerAppCompatActivity

class MainActivity: ViewModelActivity(){

    private val vm by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }

}
