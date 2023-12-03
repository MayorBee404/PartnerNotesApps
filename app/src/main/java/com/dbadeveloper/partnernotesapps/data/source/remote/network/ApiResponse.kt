package com.dbadeveloper.partnernotesapps.data.source.remote.network

sealed class ApiResponse<out R> {
    data class Success<out T>(val value: T) : ApiResponse<T>()
    data class Error(val exception: Exception) : ApiResponse<Nothing>()
    object Empty : ApiResponse<Nothing>()
}