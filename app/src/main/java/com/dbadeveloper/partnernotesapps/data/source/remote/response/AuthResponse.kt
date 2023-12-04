package com.dbadeveloper.partnernotesapps.data.source.remote.response
class AuthResponse {
    data class RegisterResponse(
        val status: String,
        val message: String
    )
    data class LoginResponse(
        val status: String,
        val message: String,
        val data: UserData
    )
    data class UserData(
        val accessToken: String
    )

}