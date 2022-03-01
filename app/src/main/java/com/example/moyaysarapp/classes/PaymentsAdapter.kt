package com.example.moyaysarapp.classes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moyaysarapp.DB.Payments
import com.example.moyaysarapp.activities.PaymentActivity
import com.example.moyaysarapp.databinding.PaymentRowBinding

class PaymentsAdapter(val activity: PaymentActivity , var paymentsList: List<Payments>) : RecyclerView.Adapter<PaymentsAdapter.ItemViewHolder>() {
        class ItemViewHolder(var binding: PaymentRowBinding): RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
            return ItemViewHolder(
                PaymentRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }

        override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
            val aPayment = paymentsList[position]

            holder.binding.apply {
                delete.setOnClickListener{
                    activity.DialogDel(aPayment)
                }
            }
        }

        override fun getItemCount(): Int = paymentsList.size
} // End of class


