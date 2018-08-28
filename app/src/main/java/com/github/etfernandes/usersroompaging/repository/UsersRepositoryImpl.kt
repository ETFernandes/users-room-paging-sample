package com.github.etfernandes.usersroompaging.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.github.etfernandes.usersroompaging.database.UsersDatabase
import com.github.etfernandes.usersroompaging.model.User
import com.github.etfernandes.usersroompaging.model.UsersResponse
import com.github.etfernandes.usersroompaging.service.UsersService
import java.util.concurrent.Executor

private const val PAGE_SIZE = 50

class UsersRepositoryImpl(
    private val usersDatabase: UsersDatabase,
    private val usersService: UsersService,
    private val executor: Executor
) : UsersRepository {

    private val config = PagedList.Config.Builder()
        .setEnablePlaceholders(false)
        .setPageSize(PAGE_SIZE)
        .build()

    override fun getUsers(): LiveData<PagedList<User>> =
        LivePagedListBuilder(usersDatabase.users().getUsers(), config)
            .setBoundaryCallback(UsersBoundaryCallback(PAGE_SIZE, this::handleSuccessfulResponse, this::handleError, usersService))
            .build()

    private fun handleSuccessfulResponse(usersResponse: UsersResponse) {
        executor.execute {
            usersResponse.results
                .map { User(it.gender, it.name, usersResponse.info) }
                .let { usersDatabase.users().insert(it) }
        }
    }

    private fun handleError(throwable: Throwable) {
        Log.e("UsersRepositoryImpl", "Error requesting data from service", throwable)
    }
}
