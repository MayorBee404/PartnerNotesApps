package com.dbadeveloper.partnernotesapps.domain.usecase

import com.dbadeveloper.partnernotesapps.data.Resource
import com.dbadeveloper.partnernotesapps.data.source.remote.response.AuthResponse
import kotlinx.coroutines.flow.Flow

interface LoginUseCase {
    fun doLogin(username: String, password: String): Flow<Resource<AuthResponse.LoginResponse>>
}