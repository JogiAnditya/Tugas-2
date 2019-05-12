package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.login.*

class activity_page2 : AppCompatActivity (){

    var usernameInput : String = ""
    var passwordInput : String = ""
    var username: String? = null
    var password: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        btn2.setOnClickListener{
            validasi()
        }
    }

    private fun validasi(){
        usernameInput = txt4.text.toString()
        passwordInput = txt5.text.toString()
        ambilData()

        when{
            usernameInput.isEmpty() -> txt4.error = "Username tidak boleh kosong"
            passwordInput.isEmpty() -> txt5.error = "Password tidak boeh kosong"

            else -> {
                if (usernameInput.equals(username) && passwordInput.equals(password)) {
                    navigasiPage3()
                }
            }
        }
    }

    private fun ambilData(){
        val bundle: Bundle? = intent.extras

        username = bundle?.getString("Username")
        password = bundle?.getString("Password")

    }

    private fun navigasiPage3(){
        val intent = Intent(this,activity_page3::class.java)

        val bundle = Bundle()
        bundle.putString("Username", usernameInput)
        bundle.putString("Password", passwordInput)

        intent.putExtras(bundle)

        startActivity(intent)
    }
}