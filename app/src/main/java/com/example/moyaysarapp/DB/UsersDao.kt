package com.example.moyaysarapp.DB
import androidx.lifecycle.LiveData
import androidx.room.*

interface UsersDao {
    @Query("SELECT * FROM Users ORDER BY id ")
    fun getAllUsers(): List<Users>
    @Insert
    fun insertUser(user: Users)
    @Update
    fun updateUser(user: Users)
    @Delete
    fun deleteUser(user: Users)
}