package com.example.movieapi.injection

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class,
    BaseModule::class,
    ActivityModule::class,
    ViewModelModule::class,
    NetworkingModule::class
])
interface AppComponent: AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(instance: DaggerApplication)
}