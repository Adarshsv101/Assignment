package com.adarshsv.assignment

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class SignUp : AppCompatActivity() {
    lateinit var username : EditText
    lateinit var password : EditText
    lateinit var cnfpassword : EditText
    lateinit var signup : Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_sign_up)

        username = findViewById(R.id.etUsername1)
        password = findViewById(R.id.etPassword1)
        cnfpassword= findViewById(R.id.etConfirmPassword)
        signup = findViewById(R.id.btnSignUp)

        var helper = MyDBHelper(applicationContext)
        var db = helper.readableDatabase
        db.rawQuery("SELECT * FROM USERS",null)



        signup.setOnClickListener {
            var cv = ContentValues()

            if(password.text.toString() == cnfpassword.text.toString()) {
                cv.put("UNAME", username.text.toString())
                cv.put("PASSWORD", cnfpassword.text.toString())
                db.insert("USERS",null ,cv)

                username.setText("")
                password.setText("")
                cnfpassword.setText("")
                username.requestFocus()

              val intent = Intent(this@SignUp,SignIn::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this@SignUp,"Make sure the username is valid and the passowrd matches",LENGTH_SHORT).show()
            }
        }




    }
    override fun onPause() {
        super.onPause()
        finish()
    }
}