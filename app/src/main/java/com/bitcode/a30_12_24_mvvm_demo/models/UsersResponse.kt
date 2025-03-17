package com.bitcode.a30_12_24_mvvm_demo.models

import com.google.gson.annotations.SerializedName

data class UsersResponse(
    var page : Int,

    @SerializedName("per_page")
    var perPage : Int,
    var total : Int,
    @SerializedName("total_pages")
    var totalPages : Int,

    @SerializedName("data")
    var users : ArrayList<User>
)
