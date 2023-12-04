package com.dbadeveloper.partnernotesapps.domain.interactor

import com.dbadeveloper.partnernotesapps.data.Resource
import com.dbadeveloper.partnernotesapps.data.source.remote.response.AuthResponse
import com.dbadeveloper.partnernotesapps.domain.repository.IAuthRepository
import com.dbadeveloper.partnernotesapps.domain.usecase.LoginUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginInteractor @Inject constructor(private val authRepository: IAuthRepository) : LoginUseCase{
    override fun doLogin(
        username: String,
        password: String
    ): Flow<Resource<AuthResponse.LoginResponse>> {
        return authRepository.doLogin(username, password)
    }

}