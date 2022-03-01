package com.example.moyaysarapp.activities

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moyaysarapp.DB.MoyasarDatabase
import com.example.moyaysarapp.DB.Payments
import com.example.moyaysarapp.R
import com.example.moyaysarapp.classes.PaymentsAdapter

class PaymentActivity : AppCompatActivity() {
    // declare UI
    lateinit var rvPayments: RecyclerView
    //lateinit var lsPayment: List<Payments>
    lateinit var lsPayment: ArrayList<Payments>
    lateinit var signOut : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        MoyasarDatabase.getInstance(applicationContext)

        // init UI
        rvPayments=findViewById(R.id.rvPayments)
        signOut=findViewById(R.id.Signoutbtn)
        signOut.setOnClickListener {
                var usrname = Intent(this, MainActivity::class.java)
                startActivity(usrname)
                finish()
            }

        lsPayment= arrayListOf()
        lsPayment.add(Payments(0,5))
        updtRC()

    } // End of onCreate fun

    // fun to update Recycler View
    fun updtRC(){
        fun updtRC(){
           // lsPayment= MoyasarDatabase.getInstance(applicationContext).PaymentsDao().getAllPayments()
            rvPayments.adapter = PaymentsAdapter(this,lsPayment)
            rvPayments.layoutManager = GridLayoutManager(this,2)
        }
    }

    // fun to delete payment
    fun delPayment(payment : Payments){
        MoyasarDatabase.getInstance(applicationContext).PaymentsDao().deletePayment(payment)
        updtRC()
        Toast.makeText(this, "deleted payment successfully!", Toast.LENGTH_SHORT).show()
    }

    // alert dialog to confirm delete
    fun DialogDel(payment : Payments ){
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setMessage("Are you sure?")
        dialogBuilder
            .setCancelable(false)
            .setPositiveButton("Yes", DialogInterface.OnClickListener {
                    dialog, id-> delPayment(payment)
            })
            .setNegativeButton("No", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
        val alert = dialogBuilder.create()
        alert.setTitle("Delete Payment")
        alert.show()
    }

} // End of class