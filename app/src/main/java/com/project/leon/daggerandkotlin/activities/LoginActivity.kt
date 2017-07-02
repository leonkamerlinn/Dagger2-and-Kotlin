package com.project.leon.daggerandkotlin.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

import com.project.leon.daggerandkotlin.R

class LoginActivity : AppCompatActivity() {

    private var mEmailEditText: EditText? = null
    private var mPasswordEditText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mEmailEditText = findViewById(R.id.emailEditText) as EditText
        mPasswordEditText = findViewById(R.id.passwordEditText) as EditText


    }
}
