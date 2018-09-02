package com.github.etfernandes.usersroompaging.repository

import androidx.paging.PagedList
import com.github.etfernandes.usersroompaging.model.User
import com.github.etfernandes.usersroompaging.model.UsersResponse
import com.github.etfernandes.usersroompaging.service.UsersService

class UsersBoundaryCallback(
    private val numberOfResults: Int,
    private val onSuccess: (UsersResponse) -> Unit,
    private val onFailure: (Throwable) -> Unit,
    private val usersService: UsersService
) : PagedList.BoundaryCallback<User>() {

    private var running = false

    override fun onZeroItemsLoaded() {
        loadUsers("", 1)
    }

    override fun onItemAtEndLoaded(itemAtEnd: User) {
        loadUsers(itemAtEnd.info.seed, itemAtEnd.info.page + 1)
    }

    private fun loadUsers(seed: String, page: Int) {
        if (!running) {
            running = true
            usersService.getUsers(seed, page, numberOfResults)
                .doOnError {
                    running = false
                    onFailure(it)
                }
                .doOnSuccess {
                    running = false
                    if (it.isSuccessful) {
                        it.body()?.let { onSuccess(it) }
                    }
                }
                .run()
        }
    }
}
