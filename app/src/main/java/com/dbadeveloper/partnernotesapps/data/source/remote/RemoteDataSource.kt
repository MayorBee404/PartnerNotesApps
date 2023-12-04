package com.dbadeveloper.partnernotesapps.data.source.remote

import com.dbadeveloper.partnernotesapps.data.source.remote.network.ApiResponse
import com.dbadeveloper.partnernotesapps.data.source.remote.network.ApiService
import com.dbadeveloper.partnernotesapps.data.source.remote.response.AuthResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    suspend fun doLogin(username: String, password: String): Flow<ApiResponse<AuthResponse.LoginResponse>> {
        return flow {
            try {
                val response = apiService.doLogin(username, password)
                if(response.status == "success"){
                    emit(ApiResponse.Success(response))
                }else if (response.status == "failed"){
                    emit(ApiResponse.Error(response.message))
                }else{
                    emit(ApiResponse.Error(response.message))
                }
            }catch (e: Exception){
                emit(ApiResponse.Error(e.message.toString()))
            }
            }
        }

    suspend fun doRegister(name: String, email: String, password: String): Flow<ApiResponse<AuthResponse.RegisterResponse>> {
        return flow {
            try {
                val response = apiService.doRegister(name, email, password)
                if(response.status == "success"){
                    emit(ApiResponse.Success(response))
                }else if (response.status == "failed"){
                    emit(ApiResponse.Error(response.message))
                }else{
                    emit(ApiResponse.Error(response.message))
                }
            }catch (e: Exception){
                emit(ApiResponse.Error(e.message.toString()))
            }
        }
    }

    suspend fun getProfile(accessToken: String): Flow<ApiResponse<AuthResponse.LoginResponse>> {
        return flow {
            try {
                val response = apiService.getProfile(accessToken)
                if(response.status == "success"){
                    emit(ApiResponse.Success(response))
                }else if (response.status == "failed"){
                    emit(ApiResponse.Error(response.message))
                }else{
                    emit(ApiResponse.Error(response.message))
                }
                }catch (
                e: Exception
                ){
                emit(ApiResponse.Error(e.message.toString()))
            }
        }
    }
}