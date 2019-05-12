package com.example.loginapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var usernameInput: String = ""
    private var passwordInput: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener{
            cekData()
        }
    }

    private fun cekData(){
        usernameInput = txt2.text.toString()
        passwordInput = txt3.text.toString()

        when{
            usernameInput.isEmpty() -> txt2.error ="Username tidak boleh kosong"
            passwordInput.isEmpty() -> txt3.error ="Password tidak boleh kosong"

            else -> {
                ToastNotif("ok")

                NavigasiPage2()
            }
        }
    }

    private fun NavigasiPage2(){
        val intent = Intent(this,activity_page2::class.java)

        val bundle = Bundle()
        bundle.putString("Username", usernameInput)
        bundle.putString("Password", passwordInput)

        intent.putExtras(bundle)

        startActivity(intent)

    }

    private fun ToastNotif(message: String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
}
