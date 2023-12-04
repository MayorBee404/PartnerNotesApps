package com.dbadeveloper.partnernotesapps.ui.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.dbadeveloper.partnernotesapps.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val loginUseCase: LoginUseCase,) : ViewModel(){
    fun Context.doLogin (username: String, password: String) = loginUseCase.doLogin(username, password)
}