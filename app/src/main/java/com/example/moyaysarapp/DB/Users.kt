package com.example.moyaysarapp.DB
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
data class Users(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id : Int = 0, // this is how can include id if needed
    @ColumnInfo(name = "User") val username: String,
    @ColumnInfo(name = "Password") val password: String,
)
