package com.example.chatmessanger.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.chatmessanger.domain.account.Register
import com.example.chatmessanger.domain.type.None
import javax.inject.Inject

class AccountViewModel@Inject constructor(
    val registerUseCase: Register
) : BaseViewModel()  {
    var registerData: MutableLiveData<None> = MutableLiveData()

    fun register(email: String, name: String, password: String) {
        registerUseCase(Register.Params(email, name, password)) { it.either(::handleFailure, ::handleRegister) }
    }

    private fun handleRegister(none: None) {
        this.registerData.value = none
    }

    override fun onCleared() {
        super.onCleared()
        registerUseCase.unsubscribe()
    }
}