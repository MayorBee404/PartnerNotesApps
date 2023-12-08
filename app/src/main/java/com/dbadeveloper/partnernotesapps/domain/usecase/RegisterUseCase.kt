package com.dbadeveloper.partnernotesapps.domain.usecase

import com.dbadeveloper.partnernotesapps.data.Resource
import com.dbadeveloper.partnernotesapps.data.source.remote.response.AuthResponse
import kotlinx.coroutines.flow.Flow

interface RegisterUseCase {
    fun doRegister(
        name: String,
        email: String,
        password: String
    ): Flow<Resource<AuthResponse.RegisterResponse>>
}
