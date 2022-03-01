package com.example.moyaysarapp.activities

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moyaysarapp.DB.MoyasarDatabase
import com.example.moyaysarapp.DB.Payments
import com.example.moyaysarapp.R
import com.example.moyaysarapp.classes.PaymentsAdapter

class PaymentActivity : AppCompatActivity() {
    lateinit var rvPayments: RecyclerView
    lateinit var lsPayment: List<Payments>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        MoyasarDatabase.getInstance(applicationContext)

        rvPayments=findViewById(R.id.rvPayments)
        lsPayment= listOf()
        updtRC()
    } // End of onCreate func

    fun updtRC(){
        lsPayment=MoyasarDatabase.getInstance(applicationContext).PaymentsDao().getAllPayments()
        rvPayments.adapter = PaymentsAdapter(this,lsPayment)
        rvPayments.layoutManager = LinearLayoutManager(this)
    }

    fun delPayment(payment : Payments){
        MoyasarDatabase.getInstance(applicationContext).PaymentsDao().deletePayment(payment)
        updtRC()
        Toast.makeText(this, "deleted payment successfully!", Toast.LENGTH_SHORT).show()
    }


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