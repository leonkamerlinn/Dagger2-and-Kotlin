package com.project.leon.daggerandkotlin.di

/**
 * Created by Leon on 30.5.2017..
 */
@dagger.Module
class ApplicationModule(private val application: android.app.Application) {

    /**
     * Allow the application context to be injected but require that it be annotated with [ ][ForApplication] to explicitly differentiate it from an activity context.
     */
    @dagger.Provides
    @javax.inject.Singleton
    @ForApplication
    fun provideApplicationContext(): android.content.Context {
        return application as android.content.Context
    }

    @dagger.Provides
    @javax.inject.Singleton
    fun provideLocationManager(): android.location.LocationManager {
        return application.getSystemService(android.content.Context.LOCATION_SERVICE) as android.location.LocationManager
    }

    @dagger.Provides
    @javax.inject.Singleton
    @javax.inject.Named("something")
    fun provideSomething(): String {
        return "something hello"
    }

    @dagger.Provides
    @javax.inject.Singleton
    @javax.inject.Named("somethingElse")
    fun provideSomethingElse(): String {
        return "somethingElse hello else!!!"
    }

    @dagger.Provides
    @javax.inject.Singleton
    fun provideSharedPrefHelper(): com.project.leon.kotlindagger2.SharedPreferencesHelper {
        val sharedPreferences = application.getSharedPreferences("default", android.content.Context.MODE_PRIVATE)
        val sharedPrefsHelper = com.project.leon.kotlindagger2.SharedPreferencesHelper(sharedPreferences)

        return sharedPrefsHelper
    }



}