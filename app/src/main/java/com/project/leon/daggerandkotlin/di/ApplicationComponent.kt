package com.project.leon.daggerandkotlin.di

/**
 * Created by Leon on 30.5.2017..
 */
@javax.inject.Singleton
@dagger.Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun inject(application: DIApplication)

    fun inject(mainActivity: com.project.leon.daggerandkotlin.MainActivity)
}