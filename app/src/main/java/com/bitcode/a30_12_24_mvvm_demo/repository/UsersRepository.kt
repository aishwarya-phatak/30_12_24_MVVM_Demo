package com.bitcode.a30_12_24_mvvm_demo.repository

import com.bitcode.a30_12_24_mvvm_demo.models.User
import com.bitcode.a30_12_24_mvvm_demo.network.UsersApiService

class UsersRepository(private val usersApiService: UsersApiService){
    suspend fun fetchUsers(pageNumber : Int) : ArrayList<User>{
        return usersApiService.fetchUsers(pageNumber).users
    }
}