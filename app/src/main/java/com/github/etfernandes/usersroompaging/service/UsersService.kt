package com.github.etfernandes.usersroompaging.service

import com.github.etfernandes.usersroompaging.model.UsersResponse

interface UsersService {

    fun getUsers(page: Int, pageSize: Int): SimpleCall<UsersResponse>
}
