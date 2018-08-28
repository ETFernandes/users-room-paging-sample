package com.github.etfernandes.usersroompaging.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.github.etfernandes.usersroompaging.model.User

@Database(
    entities = [(User::class)],
    version = 1,
    exportSchema = false
)
abstract class UsersDatabase : RoomDatabase() {

    abstract fun users(): UsersDao

    companion object {

        private const val DATABASE_NAME = "users.db"

        fun create(context: Context) =
            Room.databaseBuilder(context, UsersDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }
}
