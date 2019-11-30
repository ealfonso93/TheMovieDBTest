package com.example.movieapi.injection

import com.example.movieapi.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainAcitivtyFragmentModule {

    @ContributesAndroidInjector
    abstract fun MainFragment(): MainFragment
}