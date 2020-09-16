package com.example.chatmessanger.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chatmessanger.domain.type.HandleOnce
import com.example.chatmessanger.domain.type.Failure

abstract class BaseViewModel: ViewModel() {
    var failureData: MutableLiveData<HandleOnce<Failure>> = MutableLiveData()

    protected fun handleFailure(failure: Failure) {
        this.failureData.value = HandleOnce(failure)
    }
}