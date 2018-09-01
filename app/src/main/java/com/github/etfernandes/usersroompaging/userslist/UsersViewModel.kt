package com.github.etfernandes.usersroompaging.userslist

import androidx.lifecycle.ViewModel
import com.github.etfernandes.usersroompaging.repository.UsersRepository

class UsersViewModel(private val usersRepository: UsersRepository) : ViewModel() {

    val users = usersRepository.getUsers()
    val refresh = usersRepository.onRefreshUsers()

    fun refreshUsers() = usersRepository.refreshUsers()
}
