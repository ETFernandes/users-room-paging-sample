package com.github.etfernandes.usersroompaging.service

import com.github.etfernandes.usersroompaging.model.UsersResponse

interface UsersService {

    /**
     * Sending an empty [seed] will retrieve a new set of users
     */
    fun getUsers(seed: String, page: Int, pageSize: Int): SimpleCall<UsersResponse>
}
