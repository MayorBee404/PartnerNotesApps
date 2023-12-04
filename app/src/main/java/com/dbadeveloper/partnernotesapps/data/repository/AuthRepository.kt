package com.dbadeveloper.partnernotesapps.data.repository

import com.dbadeveloper.partnernotesapps.data.Resource
import com.dbadeveloper.partnernotesapps.data.source.remote.RemoteDataSource
import com.dbadeveloper.partnernotesapps.data.source.remote.network.ApiResponse
import com.dbadeveloper.partnernotesapps.data.source.remote.response.AuthResponse
import com.dbadeveloper.partnernotesapps.domain.repository.IAuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class AuthRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource

): IAuthRepository {
    override fun doLogin(username: String, password: String) : Flow<Resource<AuthResponse.LoginResponse>> {
        return flow {
            emit(Resource.Loading())
            remoteDataSource.doLogin(username, password).collect {
                when(it){
                    is ApiResponse.Success -> {

                        emit(Resource.Success(it.data))
                    }
                    is ApiResponse.Error -> {
                        emit(Resource.Error(it.errorMessage))
                    }
                    else -> {
                        emit(Resource.Empty())
                    }
                }
            }
        }
    }
    override suspend fun doRegister(name: String, email: String, password: String): Flow<Resource<AuthResponse.RegisterResponse>> {
        return flow {
            emit(Resource.Loading())
            remoteDataSource.doRegister(name, email, password).collect {
                when(it){
                    is ApiResponse.Success -> {
                        emit(Resource.Success(it.data))
                    }
                    is ApiResponse.Error -> {
                        emit(Resource.Error(it.errorMessage))
                    }
                    else -> {
                        emit(Resource.Empty())
                    }
                }
            }
        }
    }
    override suspend fun getProfile(accessToken: String) : Flow<Resource<AuthResponse.LoginResponse>> {
        return flow {
            emit(Resource.Loading())
            remoteDataSource.getProfile(accessToken).collect {
                when(it){
                    is ApiResponse.Success -> {
                        emit(Resource.Success(it.data))
                    }
                    is ApiResponse.Error -> {
                        emit(Resource.Error(it.errorMessage))
                    }
                    else -> {
                        emit(Resource.Empty())
                    }
                }
            }
        }
    }
}