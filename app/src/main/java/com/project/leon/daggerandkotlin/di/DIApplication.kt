package com.project.leon.daggerandkotlin.di

import android.app.Application
import android.location.LocationManager
import com.project.leon.daggerandkotlin.di.DaggerApplicationComponent
import javax.inject.Inject

/**
 * Created by Leon on 30.5.2017..
 */
class DIApplication : Application() {

    companion object {
        //platformStatic allow access it from java code
        @JvmStatic lateinit var graph: ApplicationComponent
    }

    @Inject
    lateinit var locationManager: LocationManager

    override fun onCreate() {
        super.onCreate()
        graph = DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
        graph.inject(this)

        println("Tools: $locationManager")
        //TODO do some other cool stuff here
    }
}