package com.example.movieapi.injection

import com.example.movieapi.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [MainAcitivtyFragmentModule::class])
    internal abstract fun contributeMainActivity(): MainActivity
}