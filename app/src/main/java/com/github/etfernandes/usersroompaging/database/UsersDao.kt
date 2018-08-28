package com.github.etfernandes.usersroompaging.database

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.github.etfernandes.usersroompaging.model.User

@Dao
interface UsersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: List<User>)

    @Query("SELECT * FROM users ORDER BY _ROWID_ ASC")
    fun getUsers(): DataSource.Factory<Int, User>
}
