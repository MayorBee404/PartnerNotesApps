package com.dbadeveloper.partnernotesapps.domain.interactor

import com.dbadeveloper.partnernotesapps.data.Resource
import com.dbadeveloper.partnernotesapps.data.source.remote.response.AuthResponse
import com.dbadeveloper.partnernotesapps.domain.repository.IAuthRepository
import com.dbadeveloper.partnernotesapps.domain.usecase.RegisterUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RegisterInteractor @Inject constructor( private val authRepository: IAuthRepository) :
    RegisterUseCase {
    override fun doRegister(
        name: String,
        email: String,
        password: String
    ): Flow<Resource<AuthResponse.RegisterResponse>> {
        return authRepository.doRegister(name, email, password)
    }
}