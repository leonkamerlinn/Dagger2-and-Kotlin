package com.project.leon.daggerandkotlin

import android.content.Intent
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.multidex.MultiDex
import android.view.View
import android.widget.Button
import com.project.leon.daggerandkotlin.activities.LoginActivity
import com.project.leon.daggerandkotlin.activities.RegisterActivity
import com.project.leon.daggerandkotlin.di.DIApplication

import com.project.leon.kotlindagger2.DataManager
import com.project.leon.kotlindagger2.SharedPreferencesHelper
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val TAG = MainActivity::class.java.name


    @Inject
    lateinit var locationManager: LocationManager
    @Inject
    lateinit var sharedPrefHelper: SharedPreferencesHelper
    @Inject
    lateinit var dataManager: DataManager
    @field:[Inject Named("something")]
    lateinit var something: String
    @field:[Inject Named("somethingElse")]
    lateinit var somethingElse: String



    private var mLoginButton: Button? = null
    private var mRegisterButton: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MultiDex.install(this)
        DIApplication.graph.inject(this)

        mLoginButton = findViewById(R.id.loginButton) as Button
        mRegisterButton = findViewById(R.id.registerButton) as Button
        mLoginButton!!.setOnClickListener(this)
        mRegisterButton!!.setOnClickListener(this)



    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.loginButton -> {
                startActivity(Intent(this, LoginActivity::class.java))
            }

            R.id.registerButton -> {
                startActivity(Intent(this, RegisterActivity::class.java))
            }
        }
    }




}
