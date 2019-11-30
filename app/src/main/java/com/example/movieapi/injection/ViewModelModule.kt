package com.example.movieapi.injection

import androidx.lifecycle.ViewModel
import com.example.movieapi.ui.main.MainViewModel
import dagger.Binds
import dagger.multibindings.IntoMap

internal abstract class ViewModelModule {

    @Binds
    @IntoMap
    internal abstract fun bindMainActivityViewModel(mainActivityViewModel: MainViewModel) : ViewModel
}