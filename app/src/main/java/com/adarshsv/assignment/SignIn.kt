package com.adarshsv.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class SignIn : AppCompatActivity() {
    lateinit var username : EditText
    lateinit var password : EditText
    lateinit var signin : Button
    lateinit var signup : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashscreen= installSplashScreen() //splashscreen implementation
        super.onCreate(savedInstanceState)
        Thread.sleep(2000)// for 2 seconds
        setContentView(R.layout.activity_sign_in)

        username = findViewById(R.id.etUsername)
        password = findViewById(R.id.etPassword)
        signin = findViewById(R.id.btnSignIn)
        signup = findViewById(R.id.btnSignUp)

        var helper = MyDBHelper(applicationContext)
        var db = helper.readableDatabase

        signup.setOnClickListener {
            //signup button on click
            val intent = Intent(this@SignIn,SignUp::class.java)
            startActivity(intent)
        }

        signin.setOnClickListener {
            var args = listOf<String>(username.text.toString(),password.text.toString()).toTypedArray()
            var rs = db.rawQuery("SELECT * FROM USERS WHERE UNAME=? AND PASSWORD =? ",args)

                //once the credentials match  next activity starts
            if (rs.moveToNext()){
                val intent = Intent(this@SignIn,MainActivity::class.java)
                startActivity(intent)
            }
            else
                Toast.makeText(this@SignIn,"INVALID CREDENTIALS!!",LENGTH_LONG).show()

        }

    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}