package com.example.movieapi.injection

import com.example.movieapi.base.ViewModelActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BaseModule {

    @ContributesAndroidInjector
    internal abstract fun contributeViewModelActivity(): ViewModelActivity
}