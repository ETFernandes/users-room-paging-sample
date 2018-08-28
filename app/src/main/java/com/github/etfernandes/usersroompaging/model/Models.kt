package com.github.etfernandes.usersroompaging.model

data class Info(val page: Int, val seed: String)

data class NetworkUser(val gender: String, val name: Name)

data class Name(val title: String, val first: String, val last: String)

data class UsersResponse(val results: List<NetworkUser>, val info: Info)
