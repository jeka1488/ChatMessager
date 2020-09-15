package com.example.chatmessanger.presentation

import com.example.chatmessanger.cache.SharedPrefsManager
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Authenticator
@Inject constructor(
    val sharedPrefsManager: SharedPrefsManager
){
    fun userLoggedIn() = sharedPrefsManager.containsAnyAccount()
}