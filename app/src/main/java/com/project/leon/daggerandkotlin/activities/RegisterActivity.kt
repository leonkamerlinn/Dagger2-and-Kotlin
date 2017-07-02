package com.project.leon.daggerandkotlin.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.project.leon.daggerandkotlin.BuildConfig
import com.project.leon.daggerandkotlin.MainActivity

import com.project.leon.daggerandkotlin.R
import com.project.leon.daggerandkotlin.contracts.RegisterContract
import com.project.leon.daggerandkotlin.presenters.RegisterPresenter
import kotlinx.android.synthetic.main.activity_register.*
import java.util.HashMap

class RegisterActivity : AppCompatActivity(), View.OnClickListener, RegisterContract.View {

    companion object {
        val FIRST_NAME = "first_name"
        val LAST_NAME = "last_name"
        val EMAIL = "email"
        val PASSWORD = "password"
        val REPEAT_PASSWORD = "repeat_password"
    }



    private var mRegisterButton: Button? = null
    private var mPresenter: RegisterPresenter? = null

    private var mData: HashMap<String, String>? = null
    private var mEditTexts: HashMap<String, EditText>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        mPresenter = RegisterPresenter(this)



        mData = HashMap<String, String>()
        mEditTexts = HashMap<String, EditText>()

        mEditTexts!!.put(FIRST_NAME, findViewById(R.id.firstNameEditText) as EditText)
        mEditTexts!!.put(LAST_NAME, findViewById(R.id.lastNameEditText) as EditText)
        mEditTexts!!.put(EMAIL, findViewById(R.id.emailEditText) as EditText)
        mEditTexts!!.put(PASSWORD, findViewById(R.id.emailEditText) as EditText)
        mEditTexts!!.put(REPEAT_PASSWORD, findViewById(R.id.repeatPasswordEditText) as EditText)

        mRegisterButton = findViewById(R.id.registerButton) as Button
        mRegisterButton!!.setOnClickListener(this)

        registerButton.setOnClickListener {

        }


        val apiKey = BuildConfig.OPEN_WEATHER_MAP_API_KEY

        Toast.makeText(this, apiKey, Toast.LENGTH_LONG).show()
    }





    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.registerButton -> {

                mData!!.put(FIRST_NAME, mEditTexts!!.get(FIRST_NAME)!!.text.toString())
                mData!!.put(LAST_NAME, mEditTexts!!.get(LAST_NAME)!!.text.toString())
                mData!!.put(EMAIL, mEditTexts!!.get(EMAIL)!!.text.toString())
                mData!!.put(PASSWORD, mEditTexts!!.get(PASSWORD)!!.text.toString())
                mData!!.put(REPEAT_PASSWORD, mEditTexts!!.get(REPEAT_PASSWORD)!!.text.toString())

               mPresenter!!.register(mData!!)


            }
        }
    }

    override fun onValidationError(errorData: HashMap<String, String>) {

    }


    override fun onRegistrationSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        finish()
        startActivity(Intent(this, MainActivity::class.java))
    }


}
