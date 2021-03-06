package com.example.moyaysarapp.DB


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface PaymentsDao {
    @Query("SELECT * FROM Payments ORDER BY id ")
    fun getAllPayments(): List<Payments>
    @Insert
    fun insertPayment(payment: Payments)
    @Delete
    fun deletePayment(payment: Payments)
}