package com.github.etfernandes.usersroompaging.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.github.etfernandes.usersroompaging.model.User

interface UsersRepository {

    fun getUsers(): LiveData<PagedList<User>>
}
