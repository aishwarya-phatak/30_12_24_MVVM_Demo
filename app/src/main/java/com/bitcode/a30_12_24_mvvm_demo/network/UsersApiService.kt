package com.bitcode.a30_12_24_mvvm_demo.network

import com.bitcode.a30_12_24_mvvm_demo.models.UserPostModel
import com.bitcode.a30_12_24_mvvm_demo.models.UserPostResponseModel
import com.bitcode.a30_12_24_mvvm_demo.models.UsersResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UsersApiService {

    @GET("users")
    suspend fun fetchUsers(@Query("page") pageNumber : Int) : UsersResponse

    @POST("users")
    suspend fun addUser(@Body userPostModel: UserPostModel) : UserPostResponseModel

    companion object{
        private var usersApiService : UsersApiService? = null

        fun getInstance() : UsersApiService{
            if (usersApiService == null){
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://reqres.in/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                usersApiService = retrofit.create(UsersApiService::class.java)
            }
            return usersApiService!!
        }
    }
}