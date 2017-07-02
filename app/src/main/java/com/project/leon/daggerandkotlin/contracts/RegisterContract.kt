package com.project.leon.daggerandkotlin.contracts

import java.util.HashMap

/**
 * Created by Leon on 6.6.2017..
 */

interface RegisterContract {
    interface View {
        fun onValidationError(errorData: HashMap<String, String>)
        fun onRegistrationSuccess(message: String)
    }

    interface Presenter {
        fun register(data: HashMap<String, String>)
        fun valid(data: HashMap<String, String>): Boolean
    }
}
