package com.github.etfernandes.usersroompaging.userslist

import androidx.lifecycle.ViewModel
import com.github.etfernandes.usersroompaging.repository.UsersRepository

class UsersViewModel(usersRepository: UsersRepository) : ViewModel() {

    val users = usersRepository.getUsers()
}
