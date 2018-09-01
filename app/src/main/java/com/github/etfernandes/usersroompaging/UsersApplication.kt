package com.github.etfernandes.usersroompaging

import android.app.Application
import com.github.etfernandes.usersroompaging.database.UsersDatabase
import com.github.etfernandes.usersroompaging.repository.UsersRepository
import com.github.etfernandes.usersroompaging.repository.UsersRepositoryImpl
import com.github.etfernandes.usersroompaging.service.RetrofitUsersService
import com.github.etfernandes.usersroompaging.service.UsersService
import com.github.etfernandes.usersroompaging.userslist.UsersViewModel
import org.koin.android.ext.android.startKoin
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import java.util.concurrent.Executors

class UsersApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val module = module {
            single { UsersRepositoryImpl(get(), get(), Executors.newSingleThreadExecutor()) as UsersRepository }
            single { RetrofitUsersService(RetrofitUsersService.provide()) as UsersService }
            single { UsersDatabase.create(this@UsersApplication) }
            viewModel { UsersViewModel(get()) }
        }

        startKoin(this, listOf(module))
    }
}
