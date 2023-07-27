package com.dbadeveloper.partnernotesapps.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class UserResponse (
    @field:SerializedName("id")
    val id: Int,
    @field:SerializedName("name")
    val name: String,
    @field:SerializedName("username")
    val username: String,
    @field:SerializedName("password")
    val password: String,
)