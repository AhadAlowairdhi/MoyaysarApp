package com.example.moyaysarapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.moyaysarapp.DB.MoyasarDatabase
import com.example.moyaysarapp.DB.Users
import com.example.moyaysarapp.R
import com.example.moyaysarapp.classes.PaymentsAdapter
import java.lang.Exception

class SignupActivity : AppCompatActivity() {
    // declare UI
    lateinit var edtName1 : EditText
    lateinit var edtMobnum : EditText
    lateinit var edtLoc : EditText
    lateinit var edPassword : EditText
    lateinit var submtBtn : Button
    var username = ""
    var umobile = ""
    var ulocation = ""
    var upasswrd = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        MoyasarDatabase.getInstance(applicationContext) // declare DB
        // init UI
        initsignUp()

        submtBtn.setOnClickListener {
            submitdata()
        } // End of submit button listener

        } // End of onCreate func

    // init Function
    fun initsignUp(){
        edtName1=findViewById(R.id.edtName1)
        edtMobnum=findViewById(R.id.edtMob1)
        edtLoc=findViewById(R.id.edtLoc1)
        edPassword=findViewById(R.id.edPass)
        submtBtn=findViewById(R.id.btnSub)
    }

    // submitted fun
    fun submitdata(){

        try {
            username=edtName1.text.toString()
            umobile=edtMobnum.text.toString()
            ulocation=edtLoc.text.toString()
            upasswrd=edPassword.text.toString()
            // save data to DB
            val save = Users(0,username,upasswrd)
            MoyasarDatabase.getInstance(applicationContext).UsersDao().insertUser(save)

            // Check if fields is empty or not
            if (username.isNotEmpty() &&
                umobile.isNotEmpty() &&
                ulocation.isNotEmpty() &&
                upasswrd.isNotEmpty()){

                Toast.makeText(applicationContext, "data submitted successfully! $save", Toast.LENGTH_LONG).show()
                // after save data in DB go to Payment activity
                var intent = Intent(this, PaymentActivity::class.java)
                startActivity(intent)
                finish() // to avoid back button work
            }

        }catch (e: Exception){
            Toast.makeText(applicationContext, "data not submitted!", Toast.LENGTH_LONG).show()
        }
    }
}//End of class