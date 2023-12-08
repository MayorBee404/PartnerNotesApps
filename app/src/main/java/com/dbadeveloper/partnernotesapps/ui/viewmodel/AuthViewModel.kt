package com.dbadeveloper.partnernotesapps.ui.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dbadeveloper.partnernotesapps.data.Resource
import com.dbadeveloper.partnernotesapps.domain.usecase.LoginUseCase
import com.dbadeveloper.partnernotesapps.domain.usecase.RegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val registerUseCase: RegisterUseCase
) : ViewModel(){

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading
    fun doLogin (email: String, password: String, context: Context?) {
        viewModelScope.launch {
            delay(2000)
            loginUseCase.doLogin(email, password).flowOn(Dispatchers.IO).collect {
                when(it){
                    is Resource.Success -> {
                        _isLoading.value = false
                        Toast.makeText(context, it.data?.status, Toast.LENGTH_SHORT).show()
                    }
                    is Resource.Loading -> {
                        _isLoading.value = true
                    }
                    is Resource.Error -> {
                        _isLoading.value = false
                        Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                    }
                    is Resource.Empty -> {
                        _isLoading.value = false
                        Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
    }

    fun doRegister(name: String, email: String, password: String, context: Context?) {
        viewModelScope.launch {
            delay(2000)
            registerUseCase.doRegister(name, email, password).flowOn(Dispatchers.IO).collect {
                when(it){
                    is Resource.Success -> {
                        _isLoading.value = false
                        Toast.makeText(context, it.data?.status, Toast.LENGTH_SHORT).show()

                    }
                    is Resource.Loading -> {
                        _isLoading.value = true
                    }
                    is Resource.Error -> {
                        _isLoading.value = false
                        Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                    }
                    is Resource.Empty -> {
                        _isLoading.value = false
                        Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}