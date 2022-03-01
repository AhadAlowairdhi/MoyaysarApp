package com.example.moyaysarapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.moyaysarapp.DB.MoyasarDatabase
import com.example.moyaysarapp.R

class MainActivity : AppCompatActivity() {
    // declare UI
    lateinit var edtSignin : EditText
    lateinit var edsigninPass : EditText
    lateinit var signinBtn : Button
    lateinit var registrBtn : Button
    var usrnam = ""
    var paswrd = ""
    var valid = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        MoyasarDatabase.getInstance(applicationContext) // declare DB
        // init UI
        initSignin()

        signinBtn.setOnClickListener {
            usrnam=edtSignin.text.toString()
            paswrd=edsigninPass.text.toString()

            val users = MoyasarDatabase.getInstance(applicationContext).UsersDao().getAllUsers() // save data to DB

            // check if fields is empty or not
            if (usrnam.isNotEmpty() && paswrd.isNotEmpty()){
                for (user in users) {
                    if (usrnam == user.username && paswrd == user.password) {
                        valid = true
                    }
                }
                if (valid){
                    Toast.makeText(this, "sign in success", Toast.LENGTH_LONG).show()
                    moveto()

                }else{
                    Toast.makeText(this, "Wrong password, try again", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this, "username & password must not empty", Toast.LENGTH_LONG).show()
            }

        }
         // End of sign in button listener

        // move to Register Activity
        registrBtn.setOnClickListener {
            var intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    } // End of onCreate func

    // fun to init UI
    fun initSignin(){
        edtSignin=findViewById(R.id.edSigninN)
        edsigninPass=findViewById(R.id.edSigninPas)
        signinBtn=findViewById(R.id.signNbtn)
        registrBtn=findViewById(R.id.registrBtn)
    }

    // move to Payment activity
    fun moveto(){
        var intent = Intent(this, PaymentActivity::class.java)
        startActivity(intent)
    }

} //End of Class
