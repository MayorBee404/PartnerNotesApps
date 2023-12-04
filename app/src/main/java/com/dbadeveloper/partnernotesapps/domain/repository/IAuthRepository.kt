package com.dbadeveloper.partnernotesapps.domain.repository

import com.dbadeveloper.partnernotesapps.data.Resource
import com.dbadeveloper.partnernotesapps.data.source.remote.response.AuthResponse
import kotlinx.coroutines.flow.Flow

interface IAuthRepository {
    fun doLogin(
        username: String,
        password: String
    ): Flow<Resource<AuthResponse.LoginResponse>>

    suspend fun doRegister(
        name: String,
        email: String,
        password: String
    ): Flow<Resource<AuthResponse.RegisterResponse>>

    suspend fun getProfile(accessToken: String): Flow<Resource<AuthResponse.LoginResponse>>
}