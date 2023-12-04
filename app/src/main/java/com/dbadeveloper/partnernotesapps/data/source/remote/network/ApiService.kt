package com.dbadeveloper.partnernotesapps.data.source.remote.network

import com.dbadeveloper.partnernotesapps.data.source.remote.response.AuthResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("/login")
    suspend fun doLogin(
        @Field("email") username: String,
        @Field("password") password: String
    ): AuthResponse.LoginResponse

    @FormUrlEncoded
    @POST("/register")
    suspend fun doRegister(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): AuthResponse.RegisterResponse

    @FormUrlEncoded
    @GET("/users/me")
    suspend fun getProfile(
        @Header("Authorization") accessToken: String
    ):AuthResponse.LoginResponse

}