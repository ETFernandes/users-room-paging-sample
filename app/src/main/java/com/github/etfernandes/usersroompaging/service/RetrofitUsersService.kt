package com.github.etfernandes.usersroompaging.service

import com.github.etfernandes.usersroompaging.model.UsersResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class RetrofitUsersService(private val api: Api) : UsersService {

    override fun getUsers(seed: String, page: Int, pageSize: Int) = api.getUsers(seed, page, pageSize).toSimpleCall()

    interface Api {

        @GET("api/1.2?inc=name,gender&nat=gb")
        fun getUsers(
            @Query("seed") seed: String,
            @Query("page") page: Int,
            @Query("results") pageSize: Int
        ): Call<UsersResponse>
    }

    companion object {

        private const val ENDPOINT = "https://randomuser.me/"

        fun provide(): Api =
            Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().add(KotlinJsonAdapterFactory()).build()))
                .baseUrl(ENDPOINT)
                .build()
                .create(Api::class.java)
    }
}
