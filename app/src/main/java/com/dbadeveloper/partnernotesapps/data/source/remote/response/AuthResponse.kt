package com.dbadeveloper.partnernotesapps.data.source.remote.response

import com.dbadeveloper.partnernotesapps.domain.model.UserData

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

}