package com.example.movieapi.injection

import androidx.lifecycle.ViewModel
import com.example.movieapi.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindMainActivityViewModel(mainActivityViewModel: MainViewModel) : ViewModel
}