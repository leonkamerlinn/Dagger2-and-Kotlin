package com.project.leon.daggerandkotlin.presenters

import com.project.leon.daggerandkotlin.MainActivity
import com.project.leon.daggerandkotlin.activities.RegisterActivity
import com.project.leon.daggerandkotlin.contracts.RegisterContract
import java.util.HashMap

/**
 * Created by Leon on 6.6.2017..
 */

class RegisterPresenter(private val mView: RegisterContract.View) : RegisterContract.Presenter {
    override fun valid(data: HashMap<String, String>): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun register(data: HashMap<String, String>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
