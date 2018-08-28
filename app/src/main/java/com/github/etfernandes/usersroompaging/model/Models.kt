package com.github.etfernandes.usersroompaging.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Info(val page: Int, val seed: String)

data class NetworkUser(val gender: String, val name: Name)

data class Name(val title: String, val first: String, val last: String)

data class UsersResponse(val results: List<NetworkUser>, val info: Info)

@Entity(tableName = "users")
data class User(
    val gender: String,
    @Embedded val name: Name,
    @Embedded val info: Info,
    @PrimaryKey(autoGenerate = true) val id: Int? = null
)
