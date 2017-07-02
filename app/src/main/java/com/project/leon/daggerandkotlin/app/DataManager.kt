package com.project.leon.kotlindagger2

import android.content.Context
import com.project.leon.daggerandkotlin.di.ForApplication


import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class DataManager @Inject
constructor(@param:ForApplication private val mContext: Context, private val mSharedPrefsHelper: SharedPreferencesHelper) {

    fun saveAccessToken(accessToken: String) {
        mSharedPrefsHelper.put(SharedPreferencesHelper.PREF_KEY_ACCESS_TOKEN, accessToken)
    }

    val accessToken: String
        get() = mSharedPrefsHelper.get(SharedPreferencesHelper.PREF_KEY_ACCESS_TOKEN, "null")
}
