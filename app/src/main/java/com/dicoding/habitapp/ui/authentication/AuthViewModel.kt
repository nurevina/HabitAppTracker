package com.dicoding.habitapp.ui.authentication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dicoding.habitapp.data.HabitRepository

class AuthViewModel(
    private val habitRepository: HabitRepository
) : ViewModel() {

    private val _onGetAuthUiType = MutableLiveData<AuthUIType>()
    val onGetAuthUiType get() = _onGetAuthUiType

    fun setAuthUiType(type : AuthUIType){
        _onGetAuthUiType.value = type
    }


}

enum class AuthUIType{
    SIGN_IN,
    SIGN_UP
}