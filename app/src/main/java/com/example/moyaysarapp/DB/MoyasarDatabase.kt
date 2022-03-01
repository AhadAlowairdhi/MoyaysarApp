package com.example.moyaysarapp.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Users::class, Payments::class],version = 1,exportSchema = false)
abstract class MoyasarDatabase: RoomDatabase() {

    companion object{
        var instance:MoyasarDatabase?=null
        fun getInstance(ctx: Context):MoyasarDatabase
        {
            if(instance!=null)
            {
                return  instance as MoyasarDatabase
            }
            instance= Room.databaseBuilder(ctx,MoyasarDatabase::class.java,"MoyasarDB").run { allowMainThreadQueries() }.build();
            return instance as MoyasarDatabase
        }
    }
    abstract fun PaymentsDao(): PaymentsDao
    abstract fun UsersDao(): UsersDao
}